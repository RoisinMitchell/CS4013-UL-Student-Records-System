import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {
    private String studentID;
    private String studentName;
    private Programme programme;
    private String address;
    private int yearOfStudy;
    private LinkedHashMap<Module, Grade> semesterGrades;
    private boolean completedCoop;
    private String honourType;
    private String awardType;
    private ArrayList<Transcript> previousTranscripts;
    private boolean theisPassOrFail;
    private boolean dissertionPassOrFail;

    public Student(String ID, String name, String address, Programme programme, int yearOfStudy) {
        this.semesterGrades = new LinkedHashMap<>();
        this.previousTranscripts = new ArrayList<>();
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
    }

    public Student(String ID, String name, String address, Programme programme, int yearOfStudy,
            ArrayList<Transcript> previousTranscripts, boolean completedCoop) {
        this.semesterGrades = new LinkedHashMap<>();
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
        this.previousTranscripts = previousTranscripts;
        this.completedCoop = completedCoop;
        this.awardType = "NOTPROGRESS";
    }

    public void setGrade(Module module, Grade grade) {
        this.semesterGrades.put(module, grade);
    }

    public String getStudentID() {
        return this.studentID;
    }

    public String getName() {
        return this.studentName;
    }

    public String getAddress() {
        return this.address;
    }

    public Programme getProgramme() {
        return programme;
    }

    public LinkedHashMap<Module, Grade> getGrades() {
        return this.semesterGrades;
    }

    public int getYearOfStudy() {
        return this.yearOfStudy;
    }

    public void setYearOfStudy(int yearOfStudy) {
        this.yearOfStudy = yearOfStudy;
    }

    public ArrayList<Transcript> getPreviousTranscripts() {
        return this.previousTranscripts;
    }

    public void setHonourType(String honourType) {
        this.awardType = honourType;
    }

    public String getHonourType() {
        return this.awardType;
    }

    public void addTranscript(Transcript transcript) {
        previousTranscripts.add(transcript);
    }

    public void setPreviousTranscripts(Transcript transcript) {
        this.previousTranscripts.add(transcript);
    }

    public void setThesis(boolean theis) {
        this.theisPassOrFail = theis;

    }

    public void setDissertion(boolean dissertion) {
        this.dissertionPassOrFail = dissertion;
    }

    public String toString() {
        // ID, name, address, course
        return this.studentID + ", " + this.studentName + ", " + this.address + ", " + this.programme;
    }

    public boolean isCompletedCoop() {
        return completedCoop;
    }

    public void setCompletedCoop(boolean completedCoop) {
        this.completedCoop = completedCoop;
    }

    public boolean isTheisPassOrFail() {
        return theisPassOrFail;
    }

    public void setTheisPassOrFail(boolean theisPassOrFail) {
        this.theisPassOrFail = theisPassOrFail;
    }

    public String getAwardType() {
        return awardType;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

}