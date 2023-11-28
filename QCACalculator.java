import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class QCACalculator {

    private Student student;
    private int moduleCredits;
    private double cumulativeQCS;
    private double semesterQCA;
    private double cumulativeQCA;
    private HashMap<Module, Grade> studentGrades;
    private HashMap<String, Double> hashMapGrade; // A1 - 4.0...

    public QCACalculator(HashMap<Module, Grade> studentGrades, Student student) {
        this.studentGrades = studentGrades;
        this.student = student;
        getTheGradeTable();
    }

    private HashMap<String, Double> getTheGradeTable() {
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
        hashMapGrade.put("D2", 1.20);
        hashMapGrade.put("F", 0.00);
        hashMapGrade.put("NG", 0.00);
        return hashMapGrade;
    }

    /* 
    private int getQualityHours(){
        return module.getQualityHours();
    }*/

    public double calculateCumulativeQCS(ArrayList<Transcript> transcripts){
        double cumulativeQCS = 0.0;
        for(Transcript transcript: transcripts){
            for (Map.Entry<Module, Grade> entry : transcript.getGrades().entrySet()) {
                Module module = entry.getKey();
                Grade grade = entry.getValue();
                cumulativeQCS += hashMapGrade.get(grade.getGradeLetter()) * module.getModuleCredits();
                this.moduleCredits = module.getModuleCredits();
            }
        }
        return cumulativeQCS;

    }

    // QCS(semester QCS) = QPV * Credits
    private double calculateSemesterQCS() {
        double semesterQCS = 0.0;
        for (Map.Entry<Module, Grade> entry : studentGrades.entrySet()) {
            Module module = entry.getKey();
            Grade grade = entry.getValue();
            semesterQCS += hashMapGrade.get(grade.getGradeLetter()) * module.getModuleCredits();
            this.moduleCredits = module.getModuleCredits();
        }
        return semesterQCS;
    }

    public int calculateSemesterAH() {
        return studentGrades.size()*moduleCredits;
    }

    public int calculateCumulativeAH(ArrayList<Transcript> transcripts) {
        int moduleNumber = transcripts.size()*5;
         System.out.println("moduleNumber: "+moduleNumber);
        int cumulativeAH = moduleNumber * this.moduleCredits;
        System.out.println("cumulativeAH: "+cumulativeAH);
        return cumulativeAH;
    }

    // semester QCA = summation(QCS)/summation(AH-NQH)
    public double calculateSemesterQCA() {
        this.semesterQCA = calculateSemesterQCS() / calculateSemesterAH();
        return this.semesterQCA;
    }

    public double calculateCumulativeQCA(ArrayList<Transcript> transcripts) {
        this.cumulativeQCA = calculateCumulativeQCS(transcripts) / calculateCumulativeAH(transcripts);
        return this.cumulativeQCA;
    }

    public double getSemesterQCA() {
        return this.semesterQCA;
    }

    public double getCumulativeQCA() {
        return this.cumulativeQCA;
    }
}
