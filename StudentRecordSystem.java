import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

/**
 * Represents the Student Record System, managing modules, students, programmes, transcripts, and repeat student data.
 * This class provides methods to set and retrieve records, grades, and transcripts for the simulation.
 */

public class StudentRecordSystem {
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Programme> programmes;
    private ArrayList<Transcript> transcripts;
    String semester;
    private String academicYear;
    private ArrayList<String> repeatStudents;

    /**
     * Constructs a StudentRecordSystem object with empty lists for modules, students, programmes, transcripts,
     * and repeat students.
     */
    public StudentRecordSystem() {
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
        this.programmes = new ArrayList<>();
        this.transcripts = new ArrayList<>();
        this.repeatStudents = new ArrayList<>();
    }

    /**
     * Sets records for modules, programmes, students, transcripts, and repeat students using provided CSV files.
     *
     * @param moduleFile      The file containing module records.
     * @param programmeFile   The file containing programme records.
     * @param studentFile     The file containing student records.
     * @param transcriptFile  The file containing transcript records.
     * @param repeatStudents  The file containing repeat student records.
     */
    public void setRecords(String moduleFile, String programmeFile, String studentFile, String transcriptFile,
                           String repeatStudents) throws IOException {
        setModules(moduleFile);
        setProgrammes(programmeFile);
        setStudents(studentFile);
        setTranscripts(transcriptFile);
        setRepeatStudents(repeatStudents);
    }

    private void setModules(String fileName) throws IOException {
        CsvReader modulesCsv = new CsvReader(fileName);
        ArrayList<String> moduleList = modulesCsv.toArrayList();

        for (String module : moduleList) {
            String[] moduleDetails = module.split(",");

            String code = moduleDetails[0].trim();
            String name = moduleDetails[1].trim();
            int credits = Integer.parseInt(moduleDetails[2].trim());
            int attendedHours = Integer.parseInt(moduleDetails[3].trim());
            int gradeScheme = Integer.parseInt(moduleDetails[4].trim());

            Module moduleObj = new Module(code, name, credits, attendedHours, gradeScheme);
            this.modules.add(moduleObj);
        }
    }

    private void setStudents(String fileName) throws IOException {
        CsvReader studentsCsv = new CsvReader(fileName);
        ArrayList<String> studentList = studentsCsv.toArrayList();

        // Iterating over the list of students
        for (String student : studentList) {
            // Splitting the line of student data at every comma, stored in an array
            String[] studentDetails = student.split(",");

            // Creating variables to be used when instantiate a Course object
            String id = studentDetails[0].trim();
            String name = studentDetails[1].trim();
            String address = studentDetails[2].trim();
            Programme programme = getProgramme(studentDetails[3].trim());

            // Instantiating a Course object and storing in array list
            Student studentObj = new Student(id, name, address, programme);
            this.students.add(studentObj);
        }
    }

    private void setProgrammes(String fileName) throws IOException {
        CsvReader programmesCsv = new CsvReader(fileName);
        ArrayList<String> programmeList = programmesCsv.toArrayList();

        // Iterating over the lines of programme data in the file
        for (String programmeString : programmeList) {
            // Splitting the line of programme data at every comma, stored in an array
            String[] programmeDetails = programmeString.split(",");

            // Creating variables to be used when instantiating a Programme object
            String programmeType = programmeDetails[0].trim();
            String programmeCode = programmeDetails[1].trim();
            String programmeName = programmeDetails[2].trim();
            int duration = Integer.parseInt(programmeDetails[3].trim());
            int credits = Integer.parseInt(programmeDetails[4].trim());

            ArrayList<Module> moduleList = new ArrayList<>();
            // Iterating over the remaining data in the array courseDetails (all the module
            // codes associated to the course)
            for (int i = 5; i < programmeDetails.length; i++) {
                // Retrieving the module information from the RecordSystem and adding the module
                Module module = getModule(programmeDetails[i].trim());
                moduleList.add(module);
            }

            if (programmeType.equalsIgnoreCase("BSc")) {
                Programme programme = new BachelorProgramme(moduleList, programmeCode, programmeName, duration,
                        credits);
                programmes.add(programme);
            } else {
                throw new RecordSystemException("Programme type does not exist: " + programmeType);
            }
        }
    }

    private void setTranscripts(String fileName) throws IOException {
        CsvReader transcriptsCsv = new CsvReader(fileName);
        ArrayList<String> transcriptStrings = transcriptsCsv.toArrayList();

        for (String transcriptString : transcriptStrings) {
            String[] transcriptDetails = transcriptString.split(",");

            Student student = getStudent(transcriptDetails[0].trim());
            String semester = transcriptDetails[1].trim();
            String academicYear = transcriptDetails[2].trim();
            double semesterQCA = Double.parseDouble(transcriptDetails[3].trim());
            double cumulativeQCA = Double.parseDouble(transcriptDetails[4].trim());
            double QCS = Double.parseDouble(transcriptDetails[5].trim());
            int attendedHours = Integer.parseInt((transcriptDetails[6].trim()));

            LinkedHashMap<Module, Grade> grades = new LinkedHashMap<>();

            for (int i = 7; i < transcriptDetails.length - 1; i++) {
                Module module = getModule(transcriptDetails[i].trim());
                i++;
                Grade grade = new Grade(transcriptDetails[i].trim());
                grades.put(module, grade);
            }

            Transcript transcript = new Transcript(student, semester, academicYear, semesterQCA, cumulativeQCA, QCS,
                    attendedHours, grades);
            this.transcripts.add(transcript);
            student.setTranscripts(transcript);
        }
    }

    /**
     * Sets grades for a specific module using the provided CSV files.
     */
    public void setGrades(String fileName) throws IOException {

        CsvReader gradesCsv = new CsvReader(fileName);
        ArrayList<String> moduleGrades = gradesCsv.toArrayList();

        // Parsing the first index in the array list as it contains the module details
        String[] moduleDetails = moduleGrades.get(0).split(",");
        String moduleCode = moduleDetails[0].trim();
        this.semester = moduleDetails[1].trim();
        this.academicYear = moduleDetails[2].trim();
        Module module = getModule(moduleCode.trim());

        moduleGrades.remove(0);

        // Parsing csv for module grade
        for (String studentGrade : moduleGrades) {
            // Splitting the line of student data at every comma and stored in an array
            String[] gradeDetails = studentGrade.split(",");
            String studentId = gradeDetails[0].trim();
            double percentGrade = Double.parseDouble(gradeDetails[1].trim());
            int gradeScheme = getModule(moduleCode.trim()).getGradeScheme();
            Grade grade = new Grade(percentGrade, gradeScheme);
            Student student = getStudent(studentId);

            student.setGrade(module, grade);
        }
    }

    /**
     * Holds a review period for the simulation, determining student progression and repeat conditions.
     *
     * @return A list of transcripts from the review period.
     */
    public ArrayList<Transcript> holdReview() {
        ArrayList<Transcript> newTranscripts = new ArrayList<>();
        for (Student student : students) {
            LinkedHashMap<Module, Grade> grades = student.getGrades();
            if (!grades.isEmpty()) {
                Transcript transcript = new Transcript(student, this.semester, this.academicYear, grades);
                student.setCurrentTranscript(transcript);
                newTranscripts.add(transcript);

                Programme programme = student.getProgramme();

                // Checking if the student progresses to the next semester without deficient grades or QCA
                boolean progresses = programme.determineStudentProgression(transcript);

                // If the student has deficiencies we determine the repeat conditions
                if (!progresses) {
                    String studentRepeatStatus = student.getStudentID() + ", "
                            + programme.determineRepeatStatus(transcript);
                    this.repeatStudents.add(studentRepeatStatus);
                }

                transcripts.add(transcript);
            }
        }
        // Returning the transcripts from the review period only
        return newTranscripts;
    }

    /**
     * Exports transcripts to a CSV file.
     */
    public void exportTranscripts(String fileName) {
        CsvWriter writer = new CsvWriter(fileName);
        writer.writeTranscriptsToFile(this.transcripts);
    }

    /**
     * Exports repeat student data to a CSV file.
     */
    public void exportRepeatStudents(String fileName) {
        CsvWriter writer = new CsvWriter(fileName);
        writer.writeRepeatStudentsToFile(this.repeatStudents);
    }

    /**
     * Retrieves a module based on its module code.
     *
     * @return The Module object
     */
    public Module getModule(String moduleCode) {
        for (Module module : modules) {
            boolean match = module.getModuleCode().equalsIgnoreCase(moduleCode);
            if (match) {
                return module;
            }
        }
        throw new RecordSystemException("Module not found: " + moduleCode);
    }

    /**
     * Retrieves a student based on their student ID.
     *
     * @return The Student object.
     */
    public Student getStudent(String studentID) {
        for (Student student : students) {
            boolean match = student.getStudentID().equalsIgnoreCase(studentID);

            if (match) {
                return student;
            }
        }
        throw new RecordSystemException("Student not found: " + studentID);
    }

    /**
     * Retrieves a programme based on its programme code.
     *
     * @return The Programme object.
     */
    public Programme getProgramme(String programmeCode) {
        for (Programme programme : programmes) {
            boolean match = programme.getProgrammeCode().equalsIgnoreCase(programmeCode);

            if (match) {
                return programme;
            }
        }
        throw new RecordSystemException("Programme not found: " + programmeCode);
    }

    /**
     * Sets repeat student data using the provided CSV file.
     */
    public void setRepeatStudents(String fileName) throws IOException {
        CsvReader repeatStudentsCsv = new CsvReader(fileName);
        ArrayList<String> repeatStudentsList = repeatStudentsCsv.toArrayList();

        if (!repeatStudentsList.isEmpty()) {
            this.repeatStudents.addAll(repeatStudentsList);
        }
    }

    /**
     * Retrieves the list of repeat student status.
     */
    public ArrayList<String> getRepeatStudentStatus() {
        return this.repeatStudents;
    }

    /**
     * Retrieves the list of students.
     */
    public ArrayList<Student> getStudents() {
        return students;
    }

    public void clearRepeatStudents(){
        repeatStudents.clear();
    }
}
