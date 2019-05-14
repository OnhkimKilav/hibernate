package lesson4.controller;

import lesson4.model.User;
import lesson4.service.UserService;

public class UserController {
    private UserService userService = new UserService();

    public UserController() throws Exception {
    }

    public void registerUser(User user) throws Exception {
        userService.registerUser(user);
    }

    /*public void logIn(String userName, String password) throws Exception {
        userService.logIn(userName, password);
    }

    public void logOut(){
        userService.logOut();
    }*/
}
