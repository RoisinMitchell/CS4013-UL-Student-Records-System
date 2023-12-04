import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Represents a student enrolled in a program with associated personal information, academic details,
 * and a history of grades and transcripts.
 */
public class Student {
    private final String studentID;
    private final String studentName;
    private final Programme programme;
    private String address;
    private int yearOfStudy;
    private LinkedHashMap<Module, Grade> semesterGrades;
    private ArrayList<Transcript> transcripts;
    private Transcript currentTranscript;

    /**
     * Constructs a new Student object with the specified ID, name, address, and associated program.
     * Initialises the semester grades with an empty map and sets the initial year of study to 1.
     */
    public Student(String ID, String name, String address, Programme programme) {
        this.semesterGrades = new LinkedHashMap<>();
        this.transcripts = new ArrayList<>();
        this.studentID = ID;
        this.studentName = name;
        this.address = address;
        this.programme = programme;
        this.yearOfStudy = 1;
    }

    /**
     * Constructs a new Student object with the specified ID, name, address, associated program,
     * current year of study and a list of previous transcripts.
     */
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

    /**
     * Sets the grade for a specific module in the current semester.
     *
     * @param module The module for which the grade is set.
     * @param grade  The grade achieved in the module.
     */
    public void setGrade(Module module, Grade grade) {
        this.semesterGrades.put(module, grade);
    }

    /**
     * Retrieves the unique identifier of the student.
     */
    public String getStudentID() {
        return this.studentID;
    }

    /**
     * Retrieves the name of the student.
     */
    public String getName() {
        return this.studentName;
    }

    /**
     * Retrieves the program in which the student is enrolled.
     */
    public Programme getProgramme() {
        return programme;
    }

    /**
     * Retrieves the grades for the current semester.
     *
     * @return A map of module to grade for the current semester.
     */
    public LinkedHashMap<Module, Grade> getGrades() {
        return this.semesterGrades;
    }

    /**
     * Retrieves the list of transcripts for the student.
     */
    public ArrayList<Transcript> getTranscripts() {
        return this.transcripts;
    }

    /**
     * Adds a transcript to the list of transcripts for the student.
     */
    public void setTranscripts(Transcript transcript) {
        this.transcripts.add(transcript);
    }

    /**
     * Sets the current transcript for the student.
     */
    public void setCurrentTranscript(Transcript transcript) {
        this.currentTranscript = transcript;
    }

    /**
     * Clears the semester grades for the student.
     */
    public void clearSemesterGrades() {
        this.semesterGrades.clear();
    }

    /**
     * Provides a string representation of the student, including ID, name, address, and program.
     */
    public String toString() {
        return this.studentID + ", " + this.studentName + ", " + this.address + ", " + this.programme;
    }
}