import java.util.ArrayList;

public class Programme {

    private ArrayList<Student> students;
    private ArrayList<Module> modules;
    private String programmeCode;
    private String programmeName;
    private int duration;
    private int credits;

    public Programme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits){
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

    public String getProgrammeName(){
        return this.programmeName;
    }

    public int getDuration(){
        return this.duration;
    }

    public int getCredits(){
        return this.credits;
    }
    public String toString(){
        
        String output = this.programmeCode +", " + this.programmeName;
        return output;
    }

}
