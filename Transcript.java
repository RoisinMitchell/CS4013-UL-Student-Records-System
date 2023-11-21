import java.util.ArrayList;

public class Transcript {

    private String id;
    private String name;
    private String address;
    private double QCA;
    ArrayList<Grade> grades;

    public Transcript(Student student, ArrayList<Grade> grades) {
        this.id = student.getStudentID();
        this.name = student.getName();
        this.address = student.getAddress();
        this.grades = grades;
        // this.QCA = QCA_Calculator.getQCA(grades);
    }

    public String toString(){
        String out = id + " ," + name + " ," + address + " ,";
        for(Grade grade : grades){
            out += grade.toString();
        }
        return id + " ," + name + " ," + address + "\n"; // Complete with qca and grades
    }

}
