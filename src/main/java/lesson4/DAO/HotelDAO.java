package lesson4.DAO;

import lesson4.model.Hotel;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class HotelDAO extends GeneralDAO<Hotel>{

    public HotelDAO(){
        super(Hotel.class);
    }

    public List<Hotel> findHotelByName(String name){
        Session session = null;
        Transaction tr = null;
        List hotels = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            hotels = session.createQuery("SELECT * FROM HOTEL WHERE NAME = ?")
                    .setString(0, name).list();

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Find is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Find is done");

        return hotels;
    }

    public List<Hotel> findHotelByCity(String city){
        Session session = null;
        Transaction tr = null;
        List hotels = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            hotels = session.createQuery("SELECT * FROM HOTEL WHERE CITY = ?")
                    .setString(0, city).list();

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Find is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Find is done");

        return hotels;
    }
}
