package exception;

/**
 * Class for implements own database exception
 */
public class DBException extends AppException {

    public DBException() {
        super();
    }

    public DBException(String message, Throwable cause) {
        super(message, cause);
    }
}
