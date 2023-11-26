import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;

public class Student {
    private String studentID;
    private String studentName;
    private Programme programme;
    private String address;
    private int yearOfStudy;
    private LinkedHashMap<Module, Grade> semesterGrades;

    private ArrayList<Transcript> previousTranscripts;


    public Student(String ID, String name, String address, Programme programme){
        this.semesterGrades = new LinkedHashMap<>();
        this.previousTranscripts = new ArrayList<>();

        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = 1;

    }

    public Student(String ID, String name, String address, Programme programme, int currentYearOfStudy, ArrayList<Transcript> previousTranscripts){
        this.semesterGrades = new LinkedHashMap<>();

        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = currentYearOfStudy;
        this.previousTranscripts = previousTranscripts;
    }

    public void setGrade(Module module, Grade grade){
        this.semesterGrades.put(module, grade);
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

    public Programme getProgramme(){
        return programme;
    }

    public LinkedHashMap<Module, Grade> getGrades(){
        return this.semesterGrades;
    }

    public int getYearOfStudy(){
        return this.yearOfStudy;
    }

    public ArrayList<Transcript> getPreviousTranscripts(){
        return this.previousTranscripts;
    }

    public String toString(){
        // ID, name, address, course
        return this.studentID + ", " + this.studentName + ", " + this.address + ", " + this.programme;
    }
}