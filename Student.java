import java.util.ArrayList;

public class Student {
    private int studentID;
    private String name;
    private String course;
    private String address;
    private int currentYearOfStudy;
    private ArrayList<Transcript> studentTranscripts;

    public Student(int ID, String name, String address, String course){
        this.studentID = ID;
        this.name = name;
        this.address = address;
        this.course = course;
        this.currentYearOfStudy = 1;
    }

    public int getStudentID(){
        return this.studentID;
    }

    public String getName(){
        return this.name;
    }

    public String getAddress(){
        return this.address;
    }

    public String getCourse(){
        return this.course;
    }

    public int getCurrentYearOfStudy(){
        return this.currentYearOfStudy;
    }

    public String toString(){
        // ID, name, address, course
        return "";
    }


}
