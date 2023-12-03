import java.util.ArrayList;

public abstract class Programme{

    private ArrayList<Student> students;
    private final ArrayList<Module> modules;
    private final String programmeCode;
    private final String programmeName;
    private final int duration;
    private final int credits;

    public Programme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        this.modules = modules;
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.duration = duration;
        this.credits = credits;
    }

    public void setStudents(ArrayList<Student> students){
        this.students = students;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public ArrayList<Module> getModules(){
        return this.modules;
    }

    public String getProgrammeCode(){
        return this.programmeCode;
    }

    public int getDuration(){
        return this.duration;
    }

    public int getCredits(){
        return this.credits;
    }

    public String toString(){
        return this.programmeCode + ", " + this.programmeName;
    }

    public abstract boolean determineStudentProgression(Transcript transcript);

    public abstract String determineRepeatStatus(Transcript transcript);

}
