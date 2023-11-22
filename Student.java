import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
public class Student {
    private String studentID;
    private String studentName;
    private String course;
    private String address;
    private int currentYearOfStudy;
    private int semseter;
    private HashMap<Module, Grade> currentGrades;
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

    public void setGrade(Module module, Grade grade){
        this.currentGrades.put(module, grade);
    }
    public HashMap<Module, Grade> getGrade(){
        return this.currentGrades;
    }

    public void setTranscript(HashMap<Module, Grade> currentGrades){
        Transcript transcript = new Transcript(studentID, );// still be done
        transcripts.add(transcript);

    }

    public Transcript getTranscript(){
        return transcripts.get(0);
        
    }

    
    public String getCourse(){
        return course;
    }
    
    public int getCurrentYearOfStudy(){
        return this.currentYearOfStudy;
    }

    public void setTranscripts(Transcript transcript){
        this.transcripts.add(transcript);
    }

    public String toString(){
        // ID, name, address, course
        return this.studentID + "," + this.studentName + "," + this.address + "," + this.course;
    }
    public boolean equals(Object other){
        if(other == null) return false;
        return (((Student) this).getStudentID() == ((Student) other).getStudentID() &&
        ((Student) this).getName() == ((Student) other).getName() &&
        ((Student) this).getCourse() == ((Student) other).getCourse() &&
        ((Student) this).getAddress() == ((Student) other).getAddress() &&
        ((Student) this).getCurrentYearOfStudy() == ((Student) other).getCurrentYearOfStudy()
        );
    }
    

}