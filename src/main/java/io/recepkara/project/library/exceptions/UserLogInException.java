package io.recepkara.project.library.exceptions;

public class UserLogInException extends RuntimeException{
    public UserLogInException(String message) {
        super(message);
    }

    public UserLogInException(String message, Throwable cause) {
        super(message, cause);
    }
}
