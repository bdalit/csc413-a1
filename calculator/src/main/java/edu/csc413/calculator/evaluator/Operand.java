package edu.csc413.calculator.evaluator;

/** Represents an integer operand in a valid mathematical expression. */
public abstract class Operand {
    private int value;
    public abstract int precedence();

    /**
     * Constructs an Operand from a String token. We assume that the token has already been checked to be valid by the
     * isValid static method.
     *
     * @param token String representation of the operand
     */
    public Operand(String token) {
        this.value = Integer.parseInt(token);
    }


    public Operand(int value) {
        this.value = value;
    }

    /**
     * Returns the value represented by the operand.
     *
     * @return The integer representation of the operand
     */
    public int getValue() {
        return value;
    }

    /**
     * Checks whether the provided token represents a valid integer operand.
     *
     * @param token The potential operand as a token being checked
     * @return True if token is a valid integer operand, and false otherwise
     */
    public static boolean isValid(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
}
