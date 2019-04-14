package lesson3;

import lesson2.Product;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class RoomDAO {

    private static SessionFactory sessionFactory;

    public static void save(Room room) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(room);

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

    public static void update(Room room) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(room);

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
            session.delete(session.get(Room.class, id));

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

    public static Room findById(long id) {
        Session session = null;
        Transaction tr = null;
        Room room = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            room = session.get(Room.class, id);

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

        return room;
    }

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
