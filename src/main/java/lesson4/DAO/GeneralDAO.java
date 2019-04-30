package lesson4.DAO;

import lesson4.controller.interfaceGeneralDAO;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public abstract class GeneralDAO<T> implements interfaceGeneralDAO<T> {
    private static SessionFactory sessionFactory;

    private Class<T> clazz;

    protected GeneralDAO(Class<T> clazz) {
        this.clazz = clazz;
    }

    public void save(T t) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(t);

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

    public void update(T t) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(t);

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

    public void delete(T t) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.delete(t);

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

    public T findById(long id, Class<T> clazz) {
        Session session = null;
        Transaction tr = null;
        T entity = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            entity = session.get(clazz, id);

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

        return entity;
    }

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }

}
