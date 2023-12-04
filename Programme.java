import java.util.ArrayList;

/**
 * An abstract class representing a generic academic programme.
 * Subclasses are expected to provide specific implementations.
 * Implements the Review interface for reviewing student progress.
 */
public abstract class Programme implements Review {

    private ArrayList<Module> modules;
    private String programmeCode;
    private String programmeName;
    private int duration;
    private int credits;

    /**
     * Constructs a new Programme with the given parameters.
     *
     * @param modules       The list of modules associated with the programme.
     * @param programmeCode The unique code identifying the programme.
     * @param programmeName The name of the academic programme.
     * @param duration      The duration of the programme in years.
     * @param credits       The total credits associated with the programme.
     */
    public Programme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        this.modules = modules;
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.duration = duration;
        this.credits = credits;
    }

    /**
     * Gets the unique code identifying the programme.
     */
    public String getProgrammeCode() {
        return this.programmeCode;
    }

    public String toString() {
        return this.programmeCode + ", " + this.programmeName;
    }
}
