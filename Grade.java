import java.util.HashMap;
import java.util.Map;


public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private int gradeScheme;
    private HashMap<String, Double> conversionChart; // A1 - 80...


    public Grade(double percentGrade, Module module){
        this.percentGrade = percentGrade;
        this.gradeScheme = module.getGradeScheme();
        this.gradeLetter = convertPercentToGrade(percentGrade, module.getGradeScheme());
    }

    public Grade(String gradeLetter){
        this.gradeLetter = gradeLetter;
    }


    public Grade(double percentGrade, int gradeScheme){
        this.gradeScheme = gradeScheme;
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade, gradeScheme);
        this.conversionChart = getConversionChart(gradeScheme);
    }

    private HashMap<String, Double> getConversionChart(int gradeScheme){

        // Functionality to pick from 3 different gradeScale Conversion table
        // If statements to chose 1, 2, or 3
        // gradeScheme will come from the Module
        conversionChart = new HashMap<String, Double>();
        conversionChart.put("A1", 80.0);
        conversionChart.put("A2", 72.0);
        conversionChart.put("B1", 64.0);
        conversionChart.put("B2", 60.0);
        conversionChart.put("B3", 56.0);
        conversionChart.put("C1", 52.0);
        conversionChart.put("C2", 48.0);
        conversionChart.put("C3", 40.0);
        conversionChart.put("D1", 35.0);
        conversionChart.put("D2", 30.0);
        conversionChart.put("F", 0.0);
        return conversionChart;
    }


    private String convertPercentToGrade(double percentGrade, int gradeScheme){
        String gradeLetter = "";
        HashMap<String, Double> gradeSchemeMap = getConversionChart(gradeScheme);
        for (Map.Entry<String, Double> entry: gradeSchemeMap.entrySet()){
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
