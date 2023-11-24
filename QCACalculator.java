import java.util.HashMap;

public class QCACalculator {

    private Grade grade;
    private Module module;
    private HashMap<Module,Grade> studentGrades;
    private HashMap<String, Double> hashMapGrade; // A1 - 4.0...

    public QCACalculator(HashMap<Module,Grade> studentGrades){
        this.studentGrades = studentGrades;
        getTheGradeTable();
    }

    private HashMap<String, Double> getTheGradeTable(){
        hashMapGrade = new HashMap<String, Double>();
        hashMapGrade.put("A1", 4.00);
        hashMapGrade.put("A2", 3.60);
        hashMapGrade.put("B1", 3.20);
        hashMapGrade.put("B2", 3.00);
        hashMapGrade.put("B3", 2.80);
        hashMapGrade.put("C1", 2.60);
        hashMapGrade.put("C2", 2.40);
        hashMapGrade.put("C3", 2.00);
        hashMapGrade.put("D1", 1.60);
        hashMapGrade.put("F", 0.00);
        hashMapGrade.put("NG", 0.00);
        return hashMapGrade;
    }

    private int getCredits(){
        return module.getModuleCredits();
    }

    private int getQualityHours(){
        return module.getQualityHours();
    }


    // QCS = QPV * Credits
    private double calculateQCS(){
        double summationQCS = 0.0;
        for (Grade grade: studentGrades.values()){
            summationQCS += hashMapGrade.get(grade.getGradeLetter()) * getCredits();
        }
        return summationQCS;
    }


    // semester QCA = summation(QCS)/summation(AH-NQH)
    public double calculateQCA(){
        return calculateQCS()/30;
    }
 
}
