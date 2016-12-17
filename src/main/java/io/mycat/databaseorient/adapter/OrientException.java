package io.mycat.databaseorient.adapter;

/**
 * Created by jiang on 2016/12/17 0017.
 */
public class OrientException extends Exception {
    /**
     * Constructs a new exception with the specified detail message.  The
     * cause is not initialized, and may subsequently be initialized by
     * a call to {@link #initCause}.
     *
     * @param message the detail message. The detail message is saved for
     *                later retrieval by the {@link #getMessage()} method.
     */
    public OrientException(String message) {
        super(message);
    }
}
