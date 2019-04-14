package lesson3;

import lesson2.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class HotelDAO {

    private static SessionFactory sessionFactory;

    public static void save(Hotel hotel) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(hotel);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Save is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Save is done");
    }

    public static void update(Hotel hotel) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(hotel);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Update is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Update is done");
    }

    public static void delete(long id) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.delete(session.get(Hotel.class, id));

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Delete is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Delete is done");
    }

    public static Hotel findById(long id) {
        Session session = null;
        Transaction tr = null;
        Hotel hotel = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            hotel = session.get(Hotel.class, id);

            //close session/tr
            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Read is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Read is done");

        return hotel;
    }

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

}
