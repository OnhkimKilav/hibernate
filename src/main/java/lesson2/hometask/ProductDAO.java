package lesson2.hometask;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;

    public static Product findById(long id){
        Session session = null;
        Transaction tr = null;
        Product product = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            product = (Product) session.createQuery("SELECT * FROM PRODUCT WHERE ID = ?")
                    .setLong(0, id);

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

        return product;
    }

    public static List findByName(String name){
        Session session = null;
        Transaction tr = null;
        List products = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            products = session.createQuery("SELECT * FROM PRODUCT WHERE NAME = ?")
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

        return products;
    }

    public static List findByContainedName(String name){
        Session session = null;
        Transaction tr = null;
        List products = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            products = session.createQuery("SELECT * FROM PRODUCT WHERE NAME LIKE ?")
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

        return products;
    }

    public static List findByPrice(int price, int delta) {
        Session session = null;
        Transaction tr = null;
        List results = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            results = session.createQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ?")
                    .setInteger(0, price - delta)
                    .setInteger(1, price + delta)
                    .list();

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

        return results;
    }

    public static List findByNameSortedAsc(String name) {
        Session session = null;
        Transaction tr = null;
        List results = null;


        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            results = session.createQuery("SELECT * FROM PRODUCT WHERE NAME = ? ORDER BY NAME ASC")
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

        return results;
    }

    public static List findByNameSortedDesc(String name) {
        Session session = null;
        Transaction tr = null;
        List results = null;


        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            results = session.createQuery("SELECT * FROM PRODUCT WHERE NAME = ? ORDER BY NAME DESC")
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

        return results;
    }

    public static List findByPriceSortedDesc(int price, int delta) {
        Session session = null;
        Transaction tr = null;
        List results = null;


        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            results = session.createQuery("SELECT * FROM PRODUCT WHERE PRICE BETWEEN ? AND ? ORDER BY PRICE DESC")
                    .setInteger(0, price - delta)
                    .setInteger(1, price + delta)
                    .list();


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

        return results;
    }

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
