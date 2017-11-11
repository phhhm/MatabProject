package biz;

/**
 * Created by parham on 23/10/2017.
 */
public class NullEntityException extends Exception {
    public NullEntityException() {
        super();
    }

    public NullEntityException(String message) {
        super(message);
    }
}
