import java.util.ArrayList;

public abstract class Programme implements Review {

    private ArrayList<Module> modules;
    private String programmeCode;
    private String programmeName;
    private int duration;
    private int credits;

    public Programme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        this.modules = modules;
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.duration = duration;
        this.credits = credits;
    }

    public String getProgrammeCode() {
        return this.programmeCode;
    }

    public String toString() {
        return this.programmeCode + ", " + this.programmeName;
    }
}
