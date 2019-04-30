package lesson4.controller;

import lesson4.model.User;

public class UserController {
    private UserService userService = new UserService();

    public UserController() throws Exception {
    }

    public User registerUser(User user) throws Exception {
        return userService.registerUser(user);
    }

    public void logIn(String userName, String password) throws Exception {
        userService.logIn(userName, password);
    }

    public void logOut(){
        userService.logOut();
    }
}
