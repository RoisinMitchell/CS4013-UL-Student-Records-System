import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class Student {
    private String studentID;
    private String studentName;
    private String programme;
    private String address;
    private int currentYearOfStudy;

    private HashMap<Module, Grade> grades;


    // Constructor to specify a student who has just enrolled (First Year)
    public Student(String ID, String name, String address, String programme){
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.currentYearOfStudy = 1;
    }

    public String getStudentID(){
        return this.studentID;
    }

    public String getName(){
        return this.studentName;
    }

    public String getAddress(){
        return this.address;
    }

    public void setGrade(Module module, Grade grade){
        this.grades.put(module, grade);
    }

    public HashMap<Module, Grade> getGrades(){
        return this.grades;
    }

    
    public String getProgramme(){
        return programme;
    }
    
    public int getCurrentYearOfStudy(){
        return this.currentYearOfStudy;
    }


    public String toString(){
        // ID, name, address, course
        return this.studentID + "," + this.studentName + "," + this.address + "," + this.programme;
    }
    public boolean equals(Object other){
        if(other == null) return false;
        return (((Student) this).getStudentID() == ((Student) other).getStudentID() &&
        ((Student) this).getName() == ((Student) other).getName() &&
        ((Student) this).getProgramme() == ((Student) other).getProgramme() &&
        ((Student) this).getAddress() == ((Student) other).getAddress() &&
        ((Student) this).getCurrentYearOfStudy() == ((Student) other).getCurrentYearOfStudy()
        );
    }
    

}