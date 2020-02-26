package org.uptospeed.backend.exceptions;

import javax.ws.rs.core.Response.Status;

public enum CommonExceptionConstants {

    /**
     * Thrown if a date inserted is in the wrong format.
     */
    WRONG_FORMAT(Status.BAD_REQUEST);

    private final Status statusCode;

    CommonExceptionConstants(final Status statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Return {@link CommonExceptionConstants} respective {@link Status} code.
     *
     * @return {@link Status} The {@link CommonExceptionConstants} respective {@link Status} code.
     */
    public Status getStatusCode() {
        return this.statusCode;
    }

}
