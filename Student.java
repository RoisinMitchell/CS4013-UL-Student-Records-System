import java.util.ArrayList;

public class Student {
    private String studentID;
    private String studentName;
    private String course;
    private String address;
    private int currentYearOfStudy;


    // Constructor to specify a student who has just enrolled (First Year)
    public Student(String ID, String name, String address, String course){
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.course = course;
        this.currentYearOfStudy = 1;
    }

    // Constructor to specify the students current year of study (Current Student)
    public Student(String ID, String name, String address, String course,int currentYearOfStudy){
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.course = course;
        this.currentYearOfStudy = currentYearOfStudy;
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

    public String getCourse(){
        return this.course;
    }

    public int getCurrentYearOfStudy(){
        return this.currentYearOfStudy;
    }

    public String toString(){
        // ID, name, address, course
        return this.studentID + "," + this.studentName + "," + this.address + "," + this.course;
    }


}