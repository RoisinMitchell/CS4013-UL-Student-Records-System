import java.util.ArrayList;
import java.util.HashMap;

public class Module {
    String code;
    String name;
    int credits;
    int qualityHours;
    HashMap<String, Double> gradeScale; //What ever data structure we want??
    public Module(String code,String name,int credits,int qualityHours){
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.qualityHours = qualityHours;
    }
    public String getCode(){
        return code;
    }
    public void setCode(String code){
        this.code= code;
    }
    public void setName(String name){
        this.name = name;
    }
    public String getName(){
        return name;
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
        this.gradeScale = gradeScale;
    }
    public String toString(){
        return this.code + "," + this.name +"," + this.credits + "," + this.qualityHours;
    }
}
