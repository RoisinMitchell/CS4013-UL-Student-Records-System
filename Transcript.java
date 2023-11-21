import java.util.ArrayList;

public class Transcript {

    private Student student;
    private String semester;
    private String academicYear;

    private double QCA;
    private ArrayList<Grade> grades;

    public Transcript(Student student, String semester, String academicYear) {
        this.grades = new ArrayList<Grade>();
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;

    }

    // Setting grades on the transcript one by one
    public void setGrade(Grade grade){
        this.grades.add(grade);
    }


    // 1. Set QCA with the calculator using the list of grades in this class
    public void setQCA(){
    }


    public String toString(){
        String out = student.toString() + ", " + semester + ", " + academicYear;
        for(Grade grade : grades){
            out += ", " + grade.toString();
        }
        return out;
    }

}
