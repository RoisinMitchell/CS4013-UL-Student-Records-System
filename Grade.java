import java.util.HashMap;

public class Grade {
    private String studentID;
    private String moduleCode;
    private String courseCode;
    private String grade;
    
    private HashMap<String, Double> hashMapGrade;

    public Grade(String studentID, String moduleCode, String courseCode, String grade){
        this.studentID = studentID;
        this.moduleCode = moduleCode;
        this.courseCode = courseCode;
        this.grade = grade;
        hashMapGrade = getTheGradeTable();
    }

    public HashMap<String, Double> getTheGradeTable(){
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

    public double getQPV(String gradeSymbol){
        // return QPV, e.g. 4.00
        double QPV = hashMapGrade.get(gradeSymbol);
        return QPV;
    } 

    public String toString(){
        String out = this.studentID + "," + this.moduleCode + "," + this.courseCode + "," + this.grade;

        return out;
    }
}
