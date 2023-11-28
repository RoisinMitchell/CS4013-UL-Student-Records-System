import java.util.*;


public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private int gradeScheme;
    private LinkedHashMap<String, Double> gradeConversionChart; // A1 - 80...

    public Grade(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }

    public Grade(double percentGrade, int gradeScheme) {
        this.gradeScheme = gradeScheme;
        setGradeConversionChart(gradeScheme);
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);
    }

    private void setGradeConversionChart(int gradeScheme) {
        gradeConversionChart = new LinkedHashMap<>();

        if (gradeScheme == 0) {
            gradeConversionChart.put("A1", 80.0);
            gradeConversionChart.put("A2", 72.0);
            gradeConversionChart.put("B1", 64.0);
            gradeConversionChart.put("B2", 60.0);
            gradeConversionChart.put("B3", 56.0);
            gradeConversionChart.put("C1", 52.0);
            gradeConversionChart.put("C2", 48.0);
            gradeConversionChart.put("C3", 40.0);
            gradeConversionChart.put("D1", 35.0);
            gradeConversionChart.put("D2", 30.0);
            gradeConversionChart.put("F", 0.0);

        } else if (gradeScheme == 1) {
            gradeConversionChart.put("A1", 90.0);
            gradeConversionChart.put("A2", 82.0);
            gradeConversionChart.put("B1", 74.0);
            gradeConversionChart.put("B2", 70.0);
            gradeConversionChart.put("B3", 66.0);
            gradeConversionChart.put("C1", 62.0);
            gradeConversionChart.put("C2", 58.0);
            gradeConversionChart.put("C3", 50.0);
            gradeConversionChart.put("D1", 45.0);
            gradeConversionChart.put("D2", 40.0);
            gradeConversionChart.put("F", 0.0);

        } else if (gradeScheme == 2) {
            gradeConversionChart.put("A1", 70.0);
            gradeConversionChart.put("A2", 62.0);
            gradeConversionChart.put("B1", 54.0);
            gradeConversionChart.put("B2", 50.0);
            gradeConversionChart.put("B3", 46.0);
            gradeConversionChart.put("C1", 42.0);
            gradeConversionChart.put("C2", 38.0);
            gradeConversionChart.put("C3", 30.0);
            gradeConversionChart.put("D1", 25.0);
            gradeConversionChart.put("D2", 20.0);
            gradeConversionChart.put("F", 0.0);
        }
    }

    private String convertPercentToGrade(double percentGrade) {
        String gradeLetter = "";

        for (Map.Entry<String, Double> entry : gradeConversionChart.entrySet()) {
            if (percentGrade >= entry.getValue()) {
                gradeLetter = entry.getKey();
                break;
            }
        }
        return gradeLetter;
    }

    public String getGradeLetter() {
        return this.gradeLetter;
    }

    public String toString() {
        return this.gradeLetter;
    }
}