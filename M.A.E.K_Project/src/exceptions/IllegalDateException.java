package exceptions;

/**
 * The IllegalDateException is thrown when an invalid date is encountered.
 * This exception is used to indicate that a date does not meet the required format or constraints.
 */
public class IllegalDateException extends Exception {
    private static final long serialVersionUID = 1L;

    /**
     * Constructs a new IllegalDateException with the specified detail message.
     *
     * @param message the detail message
     */
    public IllegalDateException(String message) {
        super(message);
    }
}