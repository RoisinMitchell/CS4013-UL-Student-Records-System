import java.util.ArrayList;
import java.util.LinkedHashMap;

public class Student {
    private final String studentID;
    private final String studentName;
    private final Programme programme;
    private String address;
    private int yearOfStudy;
    private LinkedHashMap<Module, Grade> semesterGrades;
    private ArrayList<Transcript> transcripts;
    private Transcript currentTranscript;
    private String awardType;
    private double cumulativeQca;
    private double semesterQca;

    private String repeatStatus;

    public Student(String ID, String name, String address, Programme programme) {
        this.semesterGrades = new LinkedHashMap<>();
        this.transcripts = new ArrayList<>();
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = 1;
    }

    public Student(String ID, String name, String address, Programme programme, int yearOfStudy,
            ArrayList<Transcript> previousTranscripts) {
        this.semesterGrades = new LinkedHashMap<>();
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = yearOfStudy;
        this.transcripts = previousTranscripts;
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

    public ArrayList<Transcript> getTranscripts() {
        return this.transcripts;
    }

    public void setAwardType(String awardType) {
        this.awardType = awardType;
    }

    public String getAwardType(String awardType) {
        return this.awardType;
    }

    public void setTranscripts(Transcript transcript) {
        this.transcripts.add(transcript);
    }

    public void clearGrades() {
        semesterGrades.clear();
    }

    public String toString() {
        // ID, name, address, course
        return this.studentID + ", " + this.studentName + ", " + this.address + ", " + this.programme;
    }

    public Transcript getCurrentTranscript() {
        return this.currentTranscript;
    }

    public void setCurrentTranscript(Transcript transcript) {
        this.currentTranscript = transcript;
    }

    public void setRepeatStatus(String repeatStatus) {
        this.repeatStatus = repeatStatus;
    }

    public void clearSemesterGrades() {
        this.semesterGrades.clear();
    }

}