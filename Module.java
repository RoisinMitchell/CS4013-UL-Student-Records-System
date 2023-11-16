import java.util.HashMap;

public class Module {
    String code;
    int credits;
    int qualityHours;
    HashMap<String, Double> gradeBound; //What ever data structure we want??
    public Module(FileReader e){
     //   FileReader;
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
        return 2;
    }
    public void setQualityHours(int qualityHours){
        
    }
    public HashMap<String, Double> getGradeBound(){
        return gradeBound;
    }
    public void setGradeBound(HashMap<String,Double> gradeBound){
        
    }
}
