/**
 * Represents an academic module with associated details.
 */
public class Module {
    private String moduleCode;
    private String moduleName;
    private int credits;
    private int attendedHours;
    private int gradeScheme;

    /**
     * Constructs a new Module with the given parameters.
     * @param gradeScheme  The grading scheme identifier for the module.
     */
    public Module(String moduleCode, String moduleName, int credits, int attendedHours, int gradeScheme) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.credits = credits;
        this.attendedHours = attendedHours;
        this.gradeScheme = gradeScheme;
    }

    /**
     * Gets the unique code identifying the module.
     */
    public String getModuleCode() {
        return moduleCode;
    }

    /**
     * Gets the name of the academic module.
     */
    public String getModuleName() {
        return moduleName;
    }

    /**
     * Gets the number of credits associated with the module.
     */
    public int getModuleCredits() {
        return credits;
    }

    /**
     * Gets the total hours attended for the module.
     */
    public int getAttendedHours() {
        return attendedHours;
    }

    /**
     * Gets the grading scheme identifier for the module.
     */
    public int getGradeScheme() {
        return gradeScheme;
    }

    /**
     * Returns a string representation of the module.
     */
    public String toString() {
        return this.moduleCode + ", " + this.moduleName;
    }
}
