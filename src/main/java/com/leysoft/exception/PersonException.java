
package com.leysoft.exception;

public class PersonException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public PersonException() {
        super();
    }

    public PersonException(String message, Throwable cause) {
        super(message, cause);
    }

    public PersonException(String message) {
        super(message);
    }
}
