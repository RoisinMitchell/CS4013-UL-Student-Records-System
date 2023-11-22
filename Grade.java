import java.util.HashMap;
import java.util.Map;


public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private HashMap<String, Double> gradeScale; // A1 - 80...
    

    // Automatic grade scale
    public Grade(double percentGrade){
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);

        getGradeScale();
    }

    public Grade(HashMap<String, Double> gradeScale, double percentGrade){
        this.gradeScale = gradeScale;
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);
    }

    public HashMap<String, Double> getGradeScale(){
        gradeScale = new HashMap<String, Double>();
        gradeScale.put("A1", 80.0);
        gradeScale.put("A2", 72.0);
        gradeScale.put("B1", 64.0);
        gradeScale.put("B2", 60.0);
        gradeScale.put("B3", 56.0);
        gradeScale.put("C1", 52.0);
        gradeScale.put("C2", 48.0);
        gradeScale.put("C3", 40.0);
        gradeScale.put("D1", 35.0);
        gradeScale.put("D2", 30.0);
        gradeScale.put("F", 0.0);
        return gradeScale;
    }


    public String convertPercentToGrade(double percentGrade){
        String gradeLetter = "";
        HashMap<String, Double> gradeScaleMap = getGradeScale();
        for (Map.Entry<String, Double> entry: gradeScaleMap.entrySet()){
            if (percentGrade >= entry.getValue()) {
                gradeLetter = entry.getKey();
            }
        }
        return gradeLetter;
    }

    public String getGradeLetter(){
        return this.gradeLetter;
    }

    public String toString(){
        return this.gradeLetter;
    }
}
