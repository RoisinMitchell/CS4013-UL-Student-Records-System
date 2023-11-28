import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Transcript {

    private Student student;
    private int semester;
    private String academicYear;
    private double semesterQCA;
    private double cumulativeQCA;
    private LinkedHashMap<Module,Grade> grades;
    private boolean progression;
    private double QCS;
    private int attendedHours;

    public Transcript(Student student, int semester, String academicYear, double semesterQCA, double cumulativeQCA, double QCS, int attendedHours, LinkedHashMap<Module,Grade> grades) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = grades;
        this.semesterQCA = semesterQCA;
        this.cumulativeQCA = cumulativeQCA;
        this.attendedHours = attendedHours;
        this.QCS = QCS;
    }

    public Transcript(Student student, int semester, String academicYear) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = student.getGrades();

        QCACalculator qcaObj = new QCACalculator(this.grades, student);
        this.attendedHours = qcaObj.getAttendedHours();
        this.semesterQCA = qcaObj.calculateSemesterQca();
        this.cumulativeQCA = qcaObj.calculateCumulativeQca();
        this.QCS = qcaObj.getQCS();
        
    }

    public Student getStudent(){
        return student;
    }

    public double getSemesterQCA(){
        return this.semesterQCA;
    }

    public double getCumulativeQCA(){
        return this.cumulativeQCA;
    }
    public LinkedHashMap<Module, Grade> getGrades(){
        return grades;
    }

    public double getQCS(){
        return this.QCS;
    }

    public double getAttendedHours(){
        return this.attendedHours;
    }


// 2827379, 1, 22/23, 3.82, 3.23, MA4402, A1, CS4013, A2, CS4006, C2, CS4023, A2, CS4076, B2
    public String toString(){
        // Using decimal format to round qca to two decimal places
        DecimalFormat f = new DecimalFormat("##.00");
        
        String out = this.student.getStudentID() + ", " + this.semester + ", " + this.academicYear +  ", " + f.format(semesterQCA) + ", " + f.format(cumulativeQCA) + ", " + f.format(QCS) + ", " + this.attendedHours;

        for ( Entry<Module, Grade> map : grades.entrySet()){
            out += ", " + (map.getKey()).getModuleCode() + ", " + map.getValue().getGradeLetter();
        }
        return out;
    }
}