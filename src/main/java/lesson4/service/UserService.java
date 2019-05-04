package lesson4.service;

import lesson4.DAO.UserDAO;
import lesson4.model.User;

/**
 * Created by Valik on 05.11.2018.
 */
public class UserService {
    private UserDAO userDAO = new UserDAO();

    public UserService() throws Exception {
    }

    public User registerUser(User user) throws Exception {
        //check business logic
        //нет пустых значений

        for(User user1 : userDAO.registerUser(user)){

        }

        return userDAO.registerUser(user);
    }

    public User findUserById(Long id) throws Exception {
        for (User user : userDAO.listUser()) {
            if (user.getId() == id)
                return user;
        }
        throw new NoSuchFieldError("User " + id + " don't found");
    }

    /*public void logIn(String userName, String password) throws Exception {
        //прочитать всех юзеров с файла
        //проверить есть ли на файле юзер с таким именем и паролем
        if (userName == null)
            throw new IllegalArgumentException("User name can't be null");
        if (password == null)
            throw new IllegalArgumentException("Password can't be null");
        if (logInUser != null)
            throw new UserLogInException("User " + logInUser.getUserName() + " is currently logged in");

        int index = 0;
        for(User user : userDAO.listUser())
            if (user.getUserName().equals(userName) && user.getPassword().equals(password)) {
                logInUser = user;
                break;
            } else if (index == fileUsers.length - 1)
                throw new UserNotRegisterException("User wasn't register. Or you aren't correct writing a password or an user name");

            index++;
        }
    }*/

    /*public void logOut() {
        if (logInUser != null)
            logInUser = null;
    }*/

    private void checkUserName(String userName) throws Exception {
        for (User user : userDAO.listUser())
            if (user.getUserName().equals(userName))
                throw new UserNotRegisterException(userName + " already in use. Use a different name");
    }
}
