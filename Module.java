import java.util.ArrayList;
import java.util.HashMap;

public class Module {
    String code;
    int credits;
    int qualityHours;
    HashMap<String, Double> gradeScale; //What ever data structure we want??
    public Module(FileReader e){
        ArrayList<String> moduleDetails = e.getArrayList();
        this.gradeScale = e.getGradeScale();
        this.code = moduleDetails.get(0);
        this.credits = Integer.parseInt(moduleDetails.get(1));
        this.qualityHours = Integer.parseInt(moduleDetails.get(2));
    }
    public String getCode(){
        return " ";
    }
    public void setCode(String code){

    }
    public void setCredits(int credits){
        this.credits = credits;
    }
    public int getCredits(){
        return credits;
    }
    public int getQualityHours(){
        return qualityHours;
    }
    public void setQualityHours(int qualityHours){
        this.qualityHours = qualityHours; 
    }
    public HashMap<String, Double> getGradeScale(){
        return gradeScale;
    }
    public void setGradeScale(HashMap<String,Double> gradeScale){
        
    }
    public String toString(){
        String output = code + " " + credits + " " + qualityHours;
        return output;
    }
}
