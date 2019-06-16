package com.test.buttons.exception;


public class EntityNotFoundException extends Exception {

    private static final long serialVersionUID = -4402041616690277553L;

    /**
     * Base exception constructor
     */
    public EntityNotFoundException() {
        super();
    }

    /**
     * Constructor
     *
     * @param message
     * @param cause
     * @param enableSuppression
     * @param writableStackTrace
     */
    public EntityNotFoundException(String message, Throwable cause, boolean enableSuppression,
                                   boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    /**
     * Constructor with message and a cause
     *
     * @param message
     * @param cause
     */
    public EntityNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    /**
     * Constructor with message
     *
     * @param
     */
    public EntityNotFoundException(String id) {
        super("Id " + id + " not found");
    }


    /**
     * Constructor with a cause
     *
     * @param cause
     */
    public EntityNotFoundException(Throwable cause) {
        super(cause);
    }
}