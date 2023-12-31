import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map.Entry;

public class Transcript {
    private Student student;
    private String semester;
    private String academicYear;
    private double semesterQCA;
    private double cumulativeQCA;
    private LinkedHashMap<Module, Grade> grades;
    private double QCS;
    private int attendedHours;

    /**
     * Represents a student's academic transcript, including information about courses, grades, and calculated metrics.
     */
    public Transcript(Student student, String semester, String academicYear, double semesterQCA, double cumulativeQCA,
                      double QCS, int attendedHours, LinkedHashMap<Module, Grade> grades) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = grades;
        this.semesterQCA = semesterQCA;
        this.cumulativeQCA = cumulativeQCA;
        this.attendedHours = attendedHours;
        this.QCS = QCS;
    }

    /**
     * Represents a student's academic transcript, including information about courses, grades, and calculated metrics.
     */
    public Transcript(Student student, String semester, String academicYear, LinkedHashMap<Module, Grade> grades) {
        this.student = student;
        this.semester = semester;
        this.academicYear = academicYear;
        this.grades = grades;
        QCACalculator qcaObj = new QCACalculator(this.grades, student);
        this.attendedHours = qcaObj.getAttendedHours();
        this.semesterQCA = qcaObj.calculateSemesterQca();
        this.cumulativeQCA = qcaObj.calculateCumulativeQca();
        this.QCS = qcaObj.getQCS();
    }

    /**
     * Retrieves the student associated with the transcript.
     *
     * @return The student object.
     */
    public Student getStudent() {
        return student;
    }

    /**
     * Retrieves the semester of the transcript.
     *
     * @return The semester string.
     */
    public String getSemester() {
        return this.semester;
    }


    /**
     * Retrieves the semester Quality Credit Average (QCA).
     *
     * @return The semester QCA value.
     */
    public double getSemesterQCA() {
        return this.semesterQCA;
    }

    /**
     * Retrieves the LinkedHashMap containing modules and their corresponding grades.
     *
     * @return The grades map.
     */
    public LinkedHashMap<Module, Grade> getGrades() {
        return grades;
    }

    /**
     * Retrieves the Quality Credit Score (QCS).
     *
     * @return The QCS value.
     */
    public double getQCS() {
        return this.QCS;
    }

    /**
     * Retrieves the total attended hours.
     *
     * @return The total attended hours.
     */
    public double getAttendedHours() {
        return this.attendedHours;
    }


    /**
     * Generates a formatted string representation of the transcript.
     *
     * @return The formatted string.
     */
    public String toString() {
        // Using decimal format to round qca to two decimal places
        DecimalFormat f = new DecimalFormat("0.00");

        String out = this.student.getStudentID() + ", " + this.semester + ", " + this.academicYear + ", "
                + f.format(semesterQCA) + ", " + f.format(cumulativeQCA) + ", " + f.format(QCS) + ", "
                + this.attendedHours;

        for (Entry<Module, Grade> map : grades.entrySet()) {
            out += ", " + (map.getKey()).getModuleCode() + ", " + map.getValue().getGradeLetter();
        }

        return out;
    }

    /**
     * Prints a formatted representation of the transcript to the console.
     */
    public void format() {
        // Using decimal format to round qca to two decimal places
        DecimalFormat f = new DecimalFormat("0.00");

        System.out.println("-------------------------------------------------------------------------------------");
        System.out.printf("|%-10s %-50s %-10s %-10s|\n", "Student ID", this.student.getStudentID(), this.academicYear,
                this.semester);
        System.out.printf("|%-10s %-50s %-10s %-10s|\n", "Module", "Title", "Grade", "Credits");

        for (Entry<Module, Grade> map : grades.entrySet()) {
            System.out.print("|");
            System.out.printf("%-10s %-50s %-10s %-10s|\n", map.getKey().getModuleCode(), map.getKey().getModuleName(),
                    map.getValue().getGradeLetter(), map.getKey().getModuleCredits());

        }
        System.out.printf("|%-20s %-10s %-20s %-30s|\n", "Semester QCA", f.format(semesterQCA), "Cumulative QCA",
                f.format(cumulativeQCA));
        System.out.println("-------------------------------------------------------------------------------------");
    }
}
