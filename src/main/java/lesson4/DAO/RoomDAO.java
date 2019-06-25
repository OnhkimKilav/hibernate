package lesson4.DAO;

import lesson4.model.Filter;
import lesson4.model.Room;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import javax.persistence.criteria.*;
import java.util.Date;
import java.util.List;

public class RoomDAO extends GeneralDAO<Room> {
    public RoomDAO(){
        super(Room.class);
    }

    public List<Room> findRooms(Filter filter) {
        Transaction tr = null;
        List<Room> result = null;

        try(Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            CriteriaBuilder builder = session.getCriteriaBuilder();

            CriteriaQuery<Room> criteriaQuery = builder.createQuery(Room.class);
            Root<Room> root = criteriaQuery.from(Room.class);

            Predicate name = builder.equal(root.join("HOTEL").get("NAME"), filter.getName());
            Predicate country = builder.equal(root.join("HOTEL").get("COUNTRY"), filter.getCountry());
            Predicate city = builder.equal(root.join("HOTEL").get("CITY"), filter.getCity());
            Predicate street = builder.equal(root.join("HOTEL").get("STREET"), filter.getStreet());
            Predicate numberOfGuests = builder.le(root.<Integer>get("NUMBER_OF_GUESTS"), filter.getNumberOfGuests());
            Predicate price = builder.le(root.<Integer>get("PRICE"), filter.getPrice());
            Predicate breakfastIncluded = builder.equal(root.get("BREAKFAST_INCLUDED"), filter.isBreakfastIncluded());
            Predicate petsAllowed = builder.equal(root.get("PETS_ALLOWED"), filter.isPetsAllowed());
            Predicate dateAvailableFrom = builder.greaterThanOrEqualTo(root.<Date>get("DATE_AVAILABLE_FROM"), filter.getDateAvailableFrom());

            criteriaQuery.select(root).where(builder.or(name, country, city, street, numberOfGuests, price,
                    breakfastIncluded, petsAllowed, dateAvailableFrom));

            Query<Room> query = session.createQuery(criteriaQuery);
            result = query.getResultList();

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Book is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }

        System.out.println("Book is done");

        return result;
    }

    public void bookRoom(long roomId, long userId, Date dateFrom, Date dateTo) throws Exception {
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            Room room = findById(roomId, Room.class);


            if (room.getDateAvailableFrom().before(dateFrom) || room.getDateAvailableFrom().equals(dateFrom)) {
                room.setDateAvailableFrom(dateTo);
                session.update(room);
            } else throw new Exception("Sorry, booking a room is impossible.");

            OrderDAO orderDAO = new OrderDAO();
            orderDAO.save(createOrder(room ,dateFrom, dateTo, room.getPrice()));

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Book is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }
        System.out.println("Book is done");
    }

    public void cancelReservation(long roomId, long userId) {
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession()) {

            tr = session.getTransaction();
            tr.begin();

            Room room = session.load(Room.class, roomId);

            room.setDateAvailableFrom(new Date());
            session.update(room);

            OrderDAO orderDAO = new OrderDAO();
            orderDAO.update(createOrder(room ,new Date(), new Date(), room.getPrice()));

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Cancel is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }

        System.out.println("Cancel is done");
    }

    private lesson4.model.Order createOrder(Room room, Date dateFrom, Date dateTo, double moneyPaid){
        lesson4.model.Order order = new lesson4.model.Order();
        order.setRoom(room);
        order.setDateFrom(dateFrom);
        order.setDateTo(dateTo);
        order.setMoneyPaid(moneyPaid);
        return order;
    }
}
