package exception;

import java.io.Serializable;

/**
 * Class for implements own application exception
 */
public class AppException extends  Exception {

    public AppException() {
        super();
    }

    public AppException(String message, Throwable cause) {
        super(message, cause);
    }

    public AppException(String message) {
        super(message);
    }
}
