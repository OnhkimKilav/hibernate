package lesson2;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {

    private static SessionFactory sessionFactory;

    public static void saveAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            for (Product product : products)
                session.save(product);

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

    public static void updateAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            for (Product product : products)
                session.update(product);

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

    public static void deleteAll(List<Product> products) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            for (Product product : products)
                session.delete(product);

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

    public static void save(Product product) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.save(product);

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

    public static void update(Product product) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.update(product);

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

    public static void delete(Product product) {
        Session session = null;
        Transaction tr = null;

        try {
            //create session/tr
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            //action
            session.delete(product);

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

    public static Product findById(long id) {
        Session session = null;
        Transaction tr = null;
        Product product = new Product();

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            product = session.get(Product.class, id);

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

    public static ArrayList<Product> findByName(String name) {
        Session session = null;
        Transaction tr = null;
        ArrayList<Product> products = new ArrayList<>();

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            Query query = sessionFactory.getCurrentSession().createQuery("from Product where name=:name");
            query.setParameter("name", name);
            products.add((Product) query.uniqueResult());

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

    public static List findByContainedName(String name) {
        Session session = null;
        Transaction tr = null;
        Criteria criteria = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            criteria = session.createCriteria(Product.class)
                    .add(Restrictions.like("NAME", "%" + name + "%"));

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

        return criteria.list();
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



    //public static void

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
