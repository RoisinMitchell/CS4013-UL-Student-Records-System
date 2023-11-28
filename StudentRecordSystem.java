import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StudentRecordSystem {

    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Programme> programmes;
    private ArrayList<Transcript> previousTranscripts;
    private ArrayList<Transcript> currentTranscripts;

    public StudentRecordSystem() {
        this.modules = new ArrayList<>();
        this.students = new ArrayList<>();
        this.programmes = new ArrayList<>();
        this.previousTranscripts = new ArrayList<>();
        this.currentTranscripts = new ArrayList<>();
    }

    public void setRecords(String moduleFile, String programmeFile, String studentFile, String transcriptFile) throws IOException {
        setModules(moduleFile);
        setProgrammes(programmeFile);
        setStudents(studentFile);
        setPreviousTranscripts(transcriptFile);
    }

    /*
    Module data is read on one line comma separated (Module Code, Name, Credits, Quality Hours, Grade Scheme(0-2))
    The grade scheme is an offset for the percent to grade calculation that represents the different grade bands in different modules
    e.g. CS4013, Object Oriented Development, 6, 30, 0
     */
    private void setModules(String fileName) throws IOException {
        CsvReader modulesCsv = new CsvReader(fileName);
        ArrayList<String> moduleList = modulesCsv.toArrayList();

        for (String module : moduleList) {
            String[] moduleDetails = module.split(",");

            String code = moduleDetails[0].trim();
            String name = moduleDetails[1].trim();
            int credits = Integer.parseInt(moduleDetails[2].trim());
            int qualityHours = Integer.parseInt(moduleDetails[3].trim());
            int gradeScheme = Integer.parseInt(moduleDetails[4].trim());

            Module moduleObj = new Module(code, name, credits, qualityHours, gradeScheme);
            this.modules.add(moduleObj);
        }
    }

    /*
    Student data is read on one line comma separated (ID, name, address, course)
    e.g. 21193762, Roisin Mitchell, 31 Limerick, LM121
     */
    private void setStudents(String fileName) throws IOException {
        CsvReader studentsCsv = new CsvReader(fileName);
        ArrayList<String> studentList = studentsCsv.toArrayList();

        // Iterating over the list of students
        for (String student : studentList) {
            //Splitting the line of student data at every comma, stored in an array
            String[] studentDetails = student.split(",");

            // Creating variables to be used when instantiate a Course object
            String id = studentDetails[0].trim();
            String name = studentDetails[1].trim();
            String address = studentDetails[2].trim();
            Programme programme = getProgramme(studentDetails[3].trim());
            int yearOfStudy = Integer.parseInt(studentDetails[4].trim());

            // Instantiating a Course object and storing in array list
            Student studentObj = new Student(id, name, address, programme, yearOfStudy);
            this.students.add(studentObj);
        }
    }

    /*
    Programme data is read on one line comma separated (Programme Type, Programme Code, Name, DurationInYears, Credits, Module1, Module2, Module3...)
    e.g. BSc, LM121, Computer Science, 4, 120, CS4004, CS4013, CS4141, ET4021, CS4023
     */
    private void setProgrammes(String fileName) throws IOException {
        CsvReader underGraduateProgrammesCsv = new CsvReader(fileName);
        ArrayList<String> programmeList = underGraduateProgrammesCsv.toArrayList();

        // Iterating over the lines of programme data in the file
        for (String programmeString : programmeList) {
            //Splitting the line of programme data at every comma, stored in an array
            String[] programmeDetails = programmeString.split(",");

            // Creating variables to be used when instantiating a Programme object
            String programmeType = programmeDetails[0].trim();
            String programmeCode = programmeDetails[1].trim();
            String programmeName = programmeDetails[2].trim();
            int duration = Integer.parseInt(programmeDetails[3].trim());
            int credits = Integer.parseInt(programmeDetails[4].trim());

            ArrayList<Module> moduleList = new ArrayList<>();
            // Iterating over the remaining data in the array courseDetails (all the module codes associated to the course)
            for (int i = 5; i < programmeDetails.length; i++) {
                // Retrieving the module information from the RecordSystem and adding the module
                Module module = getModule(programmeDetails[i].trim());
                moduleList.add(module);
            }

            Programme programme;

            if (programmeType.equalsIgnoreCase("BSc")) {
                programme = new BachelorProgramme(moduleList, programmeCode, programmeName, duration, credits);

            } else if (programmeType.equalsIgnoreCase("MSc")) {
                programme = new MasterProgramme(moduleList, programmeCode, programmeName, duration, credits);

            } else {
                throw new RecordSystemException("Programme type does not exist: " + programmeType);
            }

            programmes.add(programme);
        }
    }

    // A single transcript record is read in line by line with the following details:
    // (ID, Semester, Academic Year, Semester QCA, Cumulative QCA, Module, Grade, Module, Grade...)
    // e.g. 2918382, 1, 2022/2023, 4.0, 4.0, CS4043, A1, CS4141, A1, CS4221, A1, ET4011, A1, MA4111, A1
    private void setPreviousTranscripts(String fileName) throws IOException {
        CsvReader transcriptsCsv = new CsvReader(fileName);
        ArrayList<String> transcriptStrings = transcriptsCsv.toArrayList();

        for(int j=0;j<transcriptStrings.size()-1;j++){

        //}
        //for (String transcriptString : transcriptStrings) {
            //String[] transcriptDetails = transcriptString.split(",");
            String[] transcriptDetails = transcriptStrings.get(j).split(",");

            Student student = getStudent(transcriptDetails[0].trim());
            int semester = Integer.parseInt(transcriptDetails[1].trim());
            String academicYear = transcriptDetails[2].trim();
            double semesterQCA = Double.parseDouble(transcriptDetails[3].trim());
            double cumulativeQCA = Double.parseDouble(transcriptDetails[4].trim());

            LinkedHashMap<Module, Grade> grades = new LinkedHashMap<>();

            for (int i = 5; i < transcriptDetails.length - 1; i++) {
                Module module = getModule(transcriptDetails[i].trim());
                i++;
                Grade grade = new Grade(transcriptDetails[i].trim());
                grades.put(module, grade);
            }

            Transcript transcript = new Transcript(student, semester, academicYear, semesterQCA, cumulativeQCA, grades);
            this.previousTranscripts.add(transcript);
        }
    }

    /*
The first line of the csv is Module details for which the grades belong to
e.g. CS4023, Sem1, 23/24

Every line after this will contain student ID and percentage achieved in the module
e.g. 21193762, 89
*/
    public void setGrades(String fileName) throws IOException {

        CsvReader gradesCsv = new CsvReader(fileName);
        ArrayList<String> moduleGrades = gradesCsv.toArrayList();

        // Parsing the first index in the array list as it contains the module details
        String[] moduleDetails = moduleGrades.get(0).split(",");
        String moduleCode = moduleDetails[0].trim();
        String semester = moduleDetails[1].trim();
        String academicYear = moduleDetails[2].trim();
        Module module = getModule(moduleCode.trim());

        moduleGrades.remove(0);

        for (String studentGrade : moduleGrades) {
            //Splitting the line of student data at every comma and stored in an array
            String[] gradeDetails = studentGrade.split(",");
            String studentId = gradeDetails[0].trim();
            double percentGrade = Double.parseDouble(gradeDetails[1].trim());

            // Getting the grade scheme from the module
            int gradeScheme = getModule(moduleCode.trim()).getGradeScheme();

            // Passing the grade scale to the grade class to be used in conversion
            Grade grade = new Grade(percentGrade, gradeScheme);

            //Locating the student in the record system
            Student student = getStudent(studentId);
            // Setting grade on the student object
            student.setGrade(module, grade);
        }
    }

    // To hold a review will accumulate all the student grades and set transcripts
    public ArrayList<Transcript> holdReview() {
        LocalDate date = LocalDate.now();
        int year = date.getYear();

        // Getting semester from current date
        int semester = findSemester(date);
        String academicYear = year + "/" + (year + 1); // Formatting to 2023/2024


        for (Student student : students) {
            LinkedHashMap<Module,Grade> grades = student.getGrades();

            Transcript transcript = new Transcript(student, semester, academicYear);

            currentTranscripts.add(transcript);

            if (student.getProgramme().calculateProgression(transcript)) {

                if (student.getYearOfStudy() + 1 > student.getProgramme().getDuration()) {

                if(student.getYearOfStudy() + 1 > student.getProgramme().getDuration()){
                    // GRADUATE ADDs an honour to the student
                    student.getProgramme().calculateHonourType(student, transcript.getCumulativeQCA());
                    
                }
                else{
                    // Student progresses a year
                    student.setYearOfStudy(student.getYearOfStudy() + 1);
                    }
                }
            }
        }
        return currentTranscripts;
    }

    public void exportTranscripts(String fileName) {
        ArrayList<Transcript> allTranscripts = new ArrayList<>();
        allTranscripts.addAll(previousTranscripts);
        allTranscripts.addAll(currentTranscripts);

        CsvWriter writer = new CsvWriter(fileName);
        writer.transcriptsToFile(allTranscripts);
    }

    public ArrayList<Module> getModules() {
        return this.modules;
    }

    public ArrayList<Student> getStudents() {
        return this.students;
    }

    public ArrayList<Programme> getProgrammes() {
        return this.programmes;
    }

    public ArrayList<Transcript> getPreviousTranscripts() {
        return this.previousTranscripts;
    }

    public ArrayList<Transcript> getCurrentTranscripts() {
        return this.currentTranscripts;
    }

    public Module getModule(String moduleCode) {
        for (Module module : modules) {
            boolean match = module.getModuleCode().equalsIgnoreCase(moduleCode);
            if (match) {
                return module;
            }
        }
        throw new RecordSystemException("Module not found: " + moduleCode);
    }

    public Student getStudent(String studentID) {
        for (Student student : students) {
            boolean match = student.getStudentID().equalsIgnoreCase(studentID);

            if (match) {
                return student;
            }
        }
        throw new RecordSystemException("Student not found: " + studentID);
    }

    public Programme getProgramme(String programmeCode) {
        for (Programme programme : programmes) {
            boolean match = programme.getProgrammeCode().equalsIgnoreCase(programmeCode);

            if (match) {
                return programme;
            }
        }
        throw new RecordSystemException("Programme not found: " + programmeCode);
    }

    private int findSemester(LocalDate date) {

        int year = date.getYear();

        // Semester 1 bounds for finding the current semester (Start date and Results date)
        LocalDate sem1Start = LocalDate.of(year, 9, 20);
        LocalDate sem1End = LocalDate.of(year + 1, 1, 25);

        // Semester 2 bounds for finding the current semester (Start date and Results date)
        LocalDate sem2Start = LocalDate.of(year + 1, 1, 29);
        LocalDate sem2End = LocalDate.of(year + 1, 6, 21);

        int semester = 0;

        if (date.isEqual(sem1Start) || (date.isAfter(sem1Start) && date.isBefore(sem1End))) {
            semester = 1;
        } else if (date.isEqual(sem2Start) || (date.isAfter(sem2Start) && date.isBefore(sem2End))) {
            semester = 2;
        }
        return semester;
    }

    private void resetStudentsGrades(){
        for(Student student : students){
            student.resetGrades();
        }
    }
}

