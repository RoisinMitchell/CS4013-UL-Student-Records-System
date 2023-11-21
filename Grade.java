import java.util.HashMap;


public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private HashMap<String, Double> gradeScale; // A1 - 80...


    // Automatic grade scale
    public Grade(double percentGrade){
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);

     // 1. Add an automatic gradeScale to the constructor
    }

    public Grade(HashMap<String, Double> gradeScale, double percentGrade){
        this.gradeScale = gradeScale;
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);
    }

    // 2. Create method to convert percentGrade to gradeLetter
    public String convertPercentToGrade(double percentGrade){
        return "";
    }

    public String toString(){
        return this.gradeLetter;
    }
}
