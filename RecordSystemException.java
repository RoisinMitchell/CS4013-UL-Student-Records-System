/**
 * The {@code RecordSystemException} class represents an exception specific to the student record system.
 * It extends the {@code RuntimeException} class, indicating that it is an unchecked exception.
 */
public class RecordSystemException extends RuntimeException {
    /**
     * Constructs a new {@code RecordSystemException} with the specified reason.
     */
    public RecordSystemException(String reason){
        super(reason);
    }
}
