package com.makersharks.ManuSearch.exception;

/**
 * The ManuSearchException class represents a custom exception specific to the ManuSearch application.
 * It extends RuntimeException to allow unchecked exceptions to be thrown and handled as needed.
 */
public class ManuSearchException extends RuntimeException {

    /**
     * Constructor to create a new instance of ManuSearchException with a specified message.
     *
     * @param message The detail message for the exception.
     *                This message provides information about the nature of the exception.
     */
    public ManuSearchException(String message) {
        super(message);
    }
}
