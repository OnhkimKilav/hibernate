import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

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

    public static void updateAll(List<Product> products){
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

    public static void deleteAll(List<Product> products){
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

    public static void update(Product product){
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

    public static void delete(Product product){
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

    public static Product findById(long id){
        Session session = null;
        Transaction tr = null;
        Product product = new Product();

        try{
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

    public static ArrayList<Product> findByName(String name){
        Session session = null;
        Transaction tr = null;
        ArrayList<Product> products = new ArrayList<>();

        try{
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            products.add(session.get(Product.class, name));

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

    //public static void

    public static SessionFactory createSessionFactory() {
        //singleton pattern
        if (sessionFactory == null)
            sessionFactory = new Configuration().configure().buildSessionFactory();
        return sessionFactory;
    }
}
