import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

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

    // for the master research without module
    public Programme(String programmeCode, String programmeName, int duration, int credits){
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
    public boolean calculateProgression(Transcript transcript){
       
        if(transcript.getCumulativeQCA() < 2.0){
            
            return false;
        }
        // CHECKS FOR F,NG,D or D1
        
        LinkedHashMap<Module, Grade> currentGrades = transcript.getGrades();
        for(Map.Entry<Module, Grade> entry : currentGrades.entrySet()){
         
            if (entry.getValue().getGradeLetter().equals("F") || entry.getValue().getGradeLetter().equals("NG") || entry.getValue().getGradeLetter().equals("D1")
            || entry.getValue().getGradeLetter().equals("I") || entry.getValue().getGradeLetter().equals("D")){
                return false;

            } 
        }
        
        
        return true;
    }

    public void calculateHonourType(Student student, double qca){
        // getting the QCA of the the last transcript to calculate the honour type
        
        
        if(qca >= 3.40){
            student.setHonourType("First Honours Class");
        }else if(qca>= 3.00){
            student.setHonourType("Second Honours  Class 2.1");
        }else if(qca >=2.60){
            student.setHonourType("Second Honours Class 2.2");
        }else{
            student.setHonourType("Third Honours Class");
        }
    }



    


}
