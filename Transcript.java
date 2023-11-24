import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transcript {

    private Student student;
    private String semester;
    private String academicYear;
    private double QCA;
    private HashMap<Module,Grade> grades;
    private String output = "";



    public Transcript(Student student, String semester, String academicYear, double QCA, HashMap<Module,Grade> grades) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = grades;
        this.QCA = QCA;
    }

    public Transcript(Student student, String semester, String academicYear) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        // gets the hashmap from student
        this.grades = student.getGrades();
        this.QCA = setQCA(grades);
    }

    private double setQCA(HashMap<Module,Grade> studentGrades){
        QCACalculator qca = new QCACalculator(studentGrades);
        return qca.calculateQCA();
    } 

    public HashMap<Module,Grade> getGrades(){
        return grades;
    }

    public void setGrades(Module module,Grade grade) throws RecordSystemException{
        if (grades.containsKey(module)){
            throw new RecordSystemException("Module already has a grade for student " + student.getStudentID());
        }
        grades.put(module,grade);
    }

    public Student getStudent(){
        return student;
    }


    public String toString(){
        String out = student.toString() + ", " + semester + ", " + academicYear;

        grades.forEach((module, grade) -> output += module.getModuleName() + ((String) grade.toString()));
        out += output;
        out += "\n QCA = " + QCA;
        return out;
    }

}