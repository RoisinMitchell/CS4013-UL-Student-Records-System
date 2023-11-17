import java.util.ArrayList;

public class Course {
    String courseCode;
    String courseName;
    int duration;
    int courseCredits;
    ArrayList<Module> moduleList;

    public Course(String courseCode, String courseName, int duration, int totalCredits, ArrayList<Module> moduleList){
        this.moduleList = new ArrayList<Module>();
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.duration = duration;
        this.courseCredits = totalCredits;
        this.moduleList = moduleList;
    }

    public String toString(){
        String out = this.courseCode + "," + this.courseName + "," + this.duration + "," + this.courseCredits;

        for(Module module: this.moduleList){
            out += "," + module.getModuleCode();
        }
        return out;

    }
}
