import java.util.HashMap;

public class Module {
    private String moduleCode;
    private String moduleName;
    private int credits;
    private int qualityHours;

    private int gradeScheme;

    public Module(String moduleCode,String moduleName,int credits,int qualityHours, int gradeScheme){
        this.moduleCode = moduleCode;
        this.moduleName = moduleName;
        this.credits = credits;
        this.qualityHours = qualityHours;
        this.gradeScheme = gradeScheme;
    }

    public String getModuleCode(){
        return moduleCode;
    }

    public String getModuleName(){
        return moduleName;
    }

    public int getModuleCredits(){
        return credits;
    }

    public int getQualityHours(){
        return qualityHours;
    }

    public int getGradeScheme(){
        return gradeScheme;
    }

    public String toString(){
        return this.moduleCode;
    }

}
