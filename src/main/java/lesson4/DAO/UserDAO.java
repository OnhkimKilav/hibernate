package lesson4.DAO;

import lesson4.model.Room;
import lesson4.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO extends GeneralDAO {

    protected UserDAO(Class clazz) {
        super(clazz);
    }

    public User registerUser(User user){
        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            session.save(user);

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Register is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Register is done");

        return session.load(User.class, user.getId());
    }

    public void login (String userName, String password){
        Session session = null;
        Transaction tr = null;

        try {
            session = createSessionFactory().openSession();
            tr = session.getTransaction();
            tr.begin();

            List listUsers = session.createQuery("SELECT * TABLE USER WHERE USER_NAME = ? AND PASSWORD = ?")
                    .setParameter(0, userName)
                    .setParameter(1, password)
                    .list();

            for(Object o : listUsers){

            }

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Register is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        } finally {
            if (session != null)
                session.close();
        }

        System.out.println("Register is done");

    }

}
