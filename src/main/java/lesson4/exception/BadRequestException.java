package lesson4.exception;

/**
 * Created by Valik on 28.11.2018.
 */
public class BadRequestException extends Exception{
    public BadRequestException(String message) {
        super(message);
    }
}
