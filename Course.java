import java.util.ArrayList;

public class Course {
    String courseCode;
    int duration;
    int totalCredits;
    ArrayList<Module> moduleList;

    public void setCourseCode(String courseCode){

    }

    public void setDuration(int duration){

    }

    public void setTotalCredits(int totalCredits){

    }

    public void setModuleList(FileReader fileReader){
        moduleList = fileReader.readCourseModules();
        
    }
}
