/*QPV (Quality Point Value) = Numerical value assigned to grades A1 to NG
        QCS (Quality Credit Score) =(QPV Score) * (Module Credit Value)
        Att Hrs = Attempted Hours
        Non-Q Hours = Non-quality Hours

 */
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class QCACalculator {

    private LinkedHashMap<String, Double> qpvConversionChart;
    private LinkedHashMap<Module, Grade> grades;
    private double QCS;
    private Student student;
    private int attendedHours;

    public QCACalculator(LinkedHashMap<Module, Grade> grades, Student student) {

        //Loading QPV chart for use later
        qpvConversionChart = new LinkedHashMap<>();
        qpvConversionChart.put("A1", 4.00);
        qpvConversionChart.put("A2", 3.60);
        qpvConversionChart.put("B1", 3.20);
        qpvConversionChart.put("B2", 3.00);
        qpvConversionChart.put("B3", 2.80);
        qpvConversionChart.put("C1", 2.60);
        qpvConversionChart.put("C2", 2.40);
        qpvConversionChart.put("C3", 2.00);
        qpvConversionChart.put("D1", 1.60);
        qpvConversionChart.put("D2", 1.20);
        qpvConversionChart.put("F", 0.00);
        qpvConversionChart.put("NG", 0.00);
        this.grades = grades;
        this.student = student;

        //Setting total attended hours for the semester
        Set<Module> keys = grades.keySet();
        int totalAH = 0;

        for (Module module : keys) {
            totalAH += module.getAttendedHours();
        }
        this.attendedHours = totalAH;
    }

    private double getTotalQCS() {
        //QPV * Credits
        Set<Module> keys = grades.keySet();
        double totalQCS = 0;

        for (Module key : keys) {
            String grade = grades.get(key).getGradeLetter();
            int credits = key.getModuleCredits();
            double qpv = qpvConversionChart.get(grade);
            totalQCS += qpv * credits;
        }
        this.QCS = totalQCS;
        return totalQCS;
    }

    public double calculateSemesterQca(){
        return getTotalQCS() / this.attendedHours;
    }

    public double calculateCumulativeQca(){
        ArrayList<Transcript> transcripts = this.student.getPreviousTranscripts();
        double cumulativeQCS = 0;
        double cumulativeAH = 0;

        if(transcripts.isEmpty()){
            return 0;
        }else{
            for(Transcript transcript : transcripts){
                cumulativeQCS += transcript.getQCS();
                cumulativeAH += transcript.getAttendedHours();
            }
        }
        return (cumulativeQCS + QCS) / (cumulativeAH + attendedHours);
    }
 
    public double getQCS(){
        return this.QCS;
    }

    public int getAttendedHours(){
        return this.attendedHours;
    }
}
