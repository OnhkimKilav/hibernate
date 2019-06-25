package lesson4.DAO;

import lesson4.model.Room;
import lesson4.model.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class UserDAO extends GeneralDAO {

    public UserDAO(){
        super(User.class);
    }

    public void registerUser(User user){
        Transaction tr = null;

        try (Session session = createSessionFactory().openSession();){
            tr = session.getTransaction();
            tr.begin();

            session.save(user);

            tr.commit();
        } catch (HibernateException e) {
            System.err.println("Register is failed");
            System.out.println(e.getMessage());

            if (tr != null)
                tr.rollback();
        }

        System.out.println("Register is done");

    }

    public void login (String userName, String password){
        Transaction tr = null;

        try(Session session = createSessionFactory().openSession();) {

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
        }

        System.out.println("Register is done");

    }

}
