package lesson4.exception;

/**
 * Created by Valik on 10.11.2018.
 */
public class UserNotAdminException extends Exception {
    public UserNotAdminException(String message) {
        super(message);
    }
}
