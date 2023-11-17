public class Module {

    private String moduleCode;
    private String moduleName;
    private int moduleCredits;
    private int qualityHours;

    public Module(String code, String name, int credits, int qualityHours){
        this.moduleCode = code;
        this.moduleName = name;
        this.moduleCredits = credits;
        this.qualityHours = qualityHours;
    }

    public String getModuleCode(){
        return this.moduleCode;
    }

    public String toString(){
        return this.moduleCode + "," + this.moduleName +"," + this.moduleCredits + "," + this.qualityHours;
    }

}

