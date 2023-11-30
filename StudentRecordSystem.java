import java.io.*;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class StudentRecordSystem {
    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Programme> programmes;
    private ArrayList<Transcript> previousTranscripts;
    private ArrayList<Transcript> currentTranscripts;
    String semester;
    private String academicYear;
    private boolean completedCoop;

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


            if (programmeType.equalsIgnoreCase("BSc")) {
                BachelorProgramme programme = new BachelorProgramme(moduleList, programmeCode, programmeName, duration, credits);
                programmes.add(programme);
            } else if (programmeType.equalsIgnoreCase("MSc")) {
                MasterProgramme programme = new MasterProgramme(moduleList, programmeCode, programmeName, duration, credits);
                programmes.add(programme);
            } else {
                throw new RecordSystemException("Programme type does not exist: " + programmeType);
            }

        }
    }

    private void setPreviousTranscripts(String fileName) throws IOException {
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
            Transcript transcript = new Transcript(student, semester, academicYear, semesterQCA, cumulativeQCA, QCS, attendedHours, grades);
            this.previousTranscripts.add(transcript);
            student.setPreviousTranscripts(transcript);
        }
    }

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
            //Splitting the line of student data at every comma and stored in an array
            String[] gradeDetails = studentGrade.split(",");
            String studentId = gradeDetails[0].trim();
            double percentGrade = Double.parseDouble(gradeDetails[1].trim());
            int gradeScheme = getModule(moduleCode.trim()).getGradeScheme();
            Grade grade = new Grade(percentGrade, gradeScheme);
            Student student = getStudent(studentId);

            student.setGrade(module, grade);
        }
    }

    public ArrayList<Transcript> holdReview() {
        for (Student student : students) {
            LinkedHashMap<Module, Grade> grades = student.getGrades();
            Transcript transcript = new Transcript(student, this.semester, this.academicYear, grades);
            currentTranscripts.add(transcript);

            if (student.getProgramme().calculateProgression(transcript)) {

                if (student.getYearOfStudy() + 1 > student.getProgramme().getDuration()) {

                    if (student.getYearOfStudy() + 1 > student.getProgramme().getDuration()) {
                        // GRADUATE ADDs an honour to the student
                        student.getProgramme().calculateHonourType(student, transcript.getCumulativeQCA());
                        System.out.println(student.getStudentID() + "GRADUATED");
                    } else {
                        // Student progresses a year
                        student.setYearOfStudy(student.getYearOfStudy() + 1);
                    }
                }
            }
        }
        return currentTranscripts;
    }


    
     public void setTheses(String filename) throws FileNotFoundException{
        CsvReader theses = new CsvReader(filename);
        try {
            ArrayList<String> thesesThatPass = theses.toArrayList();

            for(String theis: thesesThatPass){
                String[] studentIdResult = theis.split(",");
                for(Student student : students){
                    if(studentIdResult[1].trim().equals(student.getStudentID())){
                        String programCode = student.getProgramme().getProgrammeCode();
                        for(Programme programme : programmes){
                            String programesProgrameCode = programme.getProgrammeCode();
                            if(programCode.equals(programesProgrameCode)){
                                
                            }
                       }
                       

                    }
                }
            }

            
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        
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
}

