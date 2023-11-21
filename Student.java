import java.io.IOException;
import java.util.ArrayList;

public class Student {
    private String studentID;
    private String studentName;
    private String course;
    private String address;
    private int currentYearOfStudy;
    private ArrayList<Grade> currentGrades;

    private ArrayList<Transcript> transcripts;


    // Constructor to specify a student who has just enrolled (First Year)
    public Student(String ID, String name, String address, String course){
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.course = course;
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

    public void setGrade(Grade grade){
        this.currentGrades.add(grade);
    }

    public void setTranscript(ArrayList<Grade> grades){
        // 1. create a transcript object and load the varibales and grades into it
    }

    public void setTranscripts(Transcript transcript){
        this.transcripts.add(transcript);
    }

    public String toString(){
        // ID, name, address, course
        return this.studentID + "," + this.studentName + "," + this.address + "," + this.course;
    }


}