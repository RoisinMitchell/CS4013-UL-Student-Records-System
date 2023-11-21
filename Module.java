import java.util.HashMap;

public class Module {
    private String code;
    private String name;
    private int credits;
    private int qualityHours;
    private String department;// to be changed to department object if we ever make it
    HashMap<String, Double> gradeScale; //What ever data structure we want??
    public Module(String code,String name,int credits,int qualityHours){
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.qualityHours = qualityHours;
    }// constructor for if we decide to implement departments
    public Module(String code, String name, int credits, int qualityHours, String department){
        this.code = code;
        this.name = name;
        this.credits = credits;
        this.qualityHours = qualityHours;
        this.department = department;
        // gradeScale = department.getGradeScale 
    }
    public String getModuleCode(){
        return code;
    }
    public void setModduleCode(String code){
        this.code= code;
    }
    public void setModuleName(String name){
        this.name = name;
    }
    public String getModuleName(){
        return name;
    }
    public void setModuleCredits(int credits){
        this.credits = credits;
    }
    public int getModuleCredits(){
        return credits;
    }
    public int getModuleCreditsByCode(String code){
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
    public boolean equals(Object other){
        if(other == null) return false;
        return (((Module) this).getModuleCode() == ((Module) other).getModuleCode() &&
        ((Module) this).getModuleName() == ((Module) other).getModuleName() &&
        ((Module) this).getModuleCredits() == ((Module) other).getModuleCredits() &&
        ((Module) this).getQualityHours() == ((Module) other).getQualityHours());
    }
}
