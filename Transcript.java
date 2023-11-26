import java.util.ArrayList;
import java.util.HashMap;
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

    public Transcript(Student student, int semester, String academicYear, double semesterQCA, double cumulativeQCA, LinkedHashMap<Module,Grade> grades) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = grades;
        this.semesterQCA = semesterQCA;
        this.cumulativeQCA = cumulativeQCA;
    }

    public Transcript(Student student, int semester, String academicYear) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;

        // Get the grades from the student object
        this.grades = student.getGrades();

        QCACalculator qca = new QCACalculator(this.grades, this.student);
        this.semesterQCA = qca.calculateSemesterQCA();
        this.cumulativeQCA = qca.calculateCumulativeQCA();
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

// 2827379, 1, 22/23, 3.82, 3.23, MA4402, A1, CS4013, A2, CS4006, C2, CS4023, A2, CS4076, B2
    public String toString(){
        String out = student.getStudentID() + ", " + this.semester + ", " + this.academicYear +  ", " + this.semesterQCA + ", " + this.cumulativeQCA;

        for ( Entry<Module, Grade> map : grades.entrySet()){
            out += ", " + (map.getKey()).getModuleCode() + ", " + map.getValue().getGradeLetter();
        }
        return out;
    }
}