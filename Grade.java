
import java.util.HashMap;

public class Grade {
    private double QPV; // 
    private String gradeSymbol; // A1, B2...
    private HashMap<String, Double> hashMapGrade;


    public void getTheGradeTable(){
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
    }

    public void convertGradeToSetQPV(String gradeSymbol){
    } 


=======

public class Grade {
    private double QPV;
    private String gradeSymbol; // A1, B2...


}
