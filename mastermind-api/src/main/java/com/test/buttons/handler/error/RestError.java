package com.test.buttons.handler.error;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * DTO for transferring error message with a list of field errors.
 */
public class RestError implements Serializable {

    private static final long serialVersionUID = 1L;

    private final Long timestamp;

    private final Integer status;

    private final String error;

    private final String description;

    /**
     * Protected default constructor to allow JAXB marshalling.
     */
    protected RestError() {
        this.error = null;
        this.description = null;
        this.status = null;
        this.timestamp = Calendar.getInstance().getTimeInMillis();
    }

    public RestError(String message) {
        this(message, null, null);
    }

    public RestError(String message, Integer status) {
        this(message, null, status);
    }

    public RestError(String message, String description) {
        this.error = message;
        this.description = description;
        this.status = null;
        this.timestamp = Calendar.getInstance().getTimeInMillis();

    }

    public RestError(String message, String description, Integer status) {
        this.error = message;
        this.description = description;
        this.status = status;
        this.timestamp = Calendar.getInstance().getTimeInMillis();

    }



    public String getError() {
        return error;
    }

    public String getDescription() {
        return description;
    }

    public Integer getStatus() {
        return status;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "RestError [timestamp=" + timestamp + ", status=" + status + ", error=" + error + ", description="
                + description + "]";
    }

}