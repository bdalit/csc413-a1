package edu.csc413.calculator.exceptions;

/** Exception representing an arithmetic expression that is invalid and unable to be evaluated. */
public class InvalidExpressionException extends Exception {
    /** Constructs an InvalidExpressionException with the provided exception and detailed message. */
    public InvalidExpressionException(String message) {
        super(message);
    }
}
