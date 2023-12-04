/**
 * The {@code Review} interface represents a mechanism to review a student's academic progress and
 * determine if the student should progress to the next semester or if repeat conditions apply.
 */
public interface Review {

    /**
     * Determines whether a student should progress to the next semester based on the provided transcript.
     */
    public boolean determineStudentProgression(Transcript transcript);

    /**
     * Determines the repeat status for a student based on the provided transcript.
     */
    public String determineRepeatStatus(Transcript transcript);
}
