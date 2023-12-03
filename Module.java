public class Module {
    private String moduleCode;
    private String moduleName;
    private int credits;
    private int attendedHours;
    private int gradeScheme;

    public Module(String moduleCode, String moduleName, int credits, int attendedHours, int gradeScheme) {
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.credits = credits;
        this.attendedHours = attendedHours;
        this.gradeScheme = gradeScheme;
    }

    public String getModuleCode() {
        return moduleCode;
    }

    public String getModuleName() {
        return moduleName;
    }

    public int getModuleCredits() {
        return credits;
    }

    public int getAttendedHours() {
        return attendedHours;
    }

    public int getGradeScheme() {
        return gradeScheme;
    }

    public String toString() {
        return this.moduleCode + ", " + this.moduleName;
    }
}
