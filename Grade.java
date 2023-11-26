import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;


public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private int gradeScheme;
    private LinkedHashMap<String, Double> conversionChart; // A1 - 80...


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

    private LinkedHashMap<String, Double> getConversionChart(int gradeScheme){

        // Functionality to pick from 3 different gradeScale Conversion table
        // If statements to chose 1, 2, or 3
        // gradeScheme will come from the Module
        conversionChart = new LinkedHashMap<String, Double>();
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

    private LinkedHashMap<String, Double> getConversionChart1(int gradeScheme){

        // Functionality to pick from 3 different gradeScale Conversion table
        // If statements to chose 1, 2, or 3
        // gradeScheme will come from the Module
        conversionChart = new LinkedHashMap<String, Double>();
        conversionChart.put("A1", 90.0);
        conversionChart.put("A2", 82.0);
        conversionChart.put("B1", 74.0);
        conversionChart.put("B2", 70.0);
        conversionChart.put("B3", 66.0);
        conversionChart.put("C1", 62.0);
        conversionChart.put("C2", 58.0);
        conversionChart.put("C3", 50.0);
        conversionChart.put("D1", 45.0);
        conversionChart.put("D2", 40.0);
        conversionChart.put("F", 0.0);
        return conversionChart;
    }

    private LinkedHashMap<String, Double> getConversionChart2(int gradeScheme){

        // Functionality to pick from 3 different gradeScale Conversion table
        // If statements to chose 0, 1, or 2
        // gradeScheme will come from the Module
        conversionChart = new LinkedHashMap<String, Double>();
        conversionChart.put("A1", 70.0);
        conversionChart.put("A2", 62.0);
        conversionChart.put("B1", 54.0);
        conversionChart.put("B2", 50.0);
        conversionChart.put("B3", 46.0);
        conversionChart.put("C1", 42.0);
        conversionChart.put("C2", 38.0);
        conversionChart.put("C3", 30.0);
        conversionChart.put("D1", 25.0);
        conversionChart.put("D2", 20.0);
        conversionChart.put("F", 0.0);
        return conversionChart;

    }


    private String convertPercentToGrade(double percentGrade, int gradeScheme){
        String gradeLetter = "";
        HashMap<String, Double> gradeSchemeMap = new HashMap<String, Double>();
        if(gradeScheme == 0){
            gradeSchemeMap = getConversionChart(gradeScheme);
        } else if(gradeScheme == 1){
            gradeSchemeMap = getConversionChart1(gradeScheme);
        } else{
            gradeSchemeMap = getConversionChart2(gradeScheme);
        }

        for (Map.Entry<String, Double> entry: gradeSchemeMap.entrySet()){
            if (percentGrade >= entry.getValue()) {
                gradeLetter = entry.getKey();
                break;
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
