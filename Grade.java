import java.util.*;

/**
 * Represents the academic grade of a student, including letter grade and percentage.
 */
public class Grade {
    private String gradeLetter; // A1, B2...
    private double percentGrade; // 81%, 60%...
    private int gradeScheme;
    /**
     * A mapping of grade letters to their equivalent percentage values.
     */
    private LinkedHashMap<String, Double> gradeConversionChart; // A1 = 80...

    /**
     * Constructs a Grade object with the specified letter grade.
     *
     * @param gradeLetter The letter representation of the grade.
     */
    public Grade(String gradeLetter) {
        this.gradeLetter = gradeLetter;
    }


    /**
     * Constructs a Grade object with the specified percentage grade and grading scheme.
     *
     * @param percentGrade The numerical percentage grade.
     * @param gradeScheme  The identifier for the grading scheme.
     */
    public Grade(double percentGrade, int gradeScheme) {
        this.gradeScheme = gradeScheme;
        setGradeConversionChart(gradeScheme);
        this.percentGrade = percentGrade;
        this.gradeLetter = convertPercentToGrade(percentGrade);
    }

    /**
     * Sets the grade conversion chart based on the specified grading scheme.
     */
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

    /**
     * Converts a percentage grade to a corresponding letter grade based on the conversion chart.
     * @return The letter representation of the grade.
     */
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

    /**
     * Gets the letter representation of the grade.
     */
    public String getGradeLetter() {
        return this.gradeLetter;
    }

    /**
     * Returns a string representation of the grade.
     */
    public String toString() {
        return this.gradeLetter;
    }
}