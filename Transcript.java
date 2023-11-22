import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class Transcript {

    private Student student;
    private String semester;
    private String academicYear;
    private double QCA;
    private HashMap<Module,Grade> studentGrades; 
    private String output = "";


    public Transcript(){}
        
    
    public Transcript(Student student, String semester, String academicYear) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.studentGrades = student.getGrade();
        //setQCA(studentGrades);
    }

    // Setting grades on the transcript one by one


    // 1. Set QCA with the calculator using the list of grades in this class
    /*public void setQCA(HashMap<Module,Grade> studentGrades){
        
        QCACalculator qca = new QCACalculator(HashMap<Module,Grade> studentGrades);
        this.QCA = qca.getQCA();
        
    } */


// interface perhapsdauahdquh implement qca maybe ?????

    public HashMap<Module,Grade> getStudentGrades(){
        return studentGrades;
    }





    public void setGrades(Module module,Grade grade) throws RecordSystemException{
        if (studentGrades.containsKey(module)){
            throw new RecordSystemException("Module already has a grade for student" + student.getStudentID());
        }
        studentGrades.put(module,grade);
    }
// qca needs credits and grade
    

    public String toString(){
       

        String out = student.toString() + ", " + semester + ", " + academicYear;

        studentGrades.forEach((module, grade) -> output += module.getModuleName() + ((String) grade.toString()));
        out += output;
        return out;
    }

}
