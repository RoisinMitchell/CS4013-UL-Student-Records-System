import java.util.HashMap;

public class Module {
    private String code;
    private String name;
    private int credits;
    private int qualityHours;
    HashMap<String, Double> gradeScale;

    public Module(String code,String name,int credits,int qualityHours){
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.qualityHours = qualityHours;
    }

    public void setModuleCode(String code){
        this.code= code;
    }

    public void setModuleName(String name){
        this.name = name;
    }

    public void setModuleCredits(int credits){
        this.credits = credits;
    }

    public void setQualityHours(int qualityHours){
        this.qualityHours = qualityHours;
    }

    public void setGradeScale(HashMap<String,Double> gradeScale){
        this.gradeScale = gradeScale;
    }

    public String getModuleCode(){
        return code;
    }

    public String getModuleName(){
        return name;
    }

    public int getModuleCredits(){
        return credits;
    }

    public int getQualityHours(){
        return qualityHours;
    }

    public HashMap<String, Double> getGradeScale(){
        return gradeScale;
    }


    public String toString(){
        return this.code + "," + this.name +"," + this.credits + "," + this.qualityHours;
    }
}
