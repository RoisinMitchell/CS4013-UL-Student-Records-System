import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

// The idea behind this class is that it is like the operating system of the whole student record system.
// it is where the functionality of the Menu option are held. It is also the place where we communicate with our records stored in csv files.
// The records are necessary for simulating a scenario where some students will graduate

public class StudentRecordSystem{

    private ArrayList<Module> modules;
    private ArrayList<Student> students;
    private ArrayList<Programme> programmes;
    private ArrayList<Transcript> transcripts;


    public StudentRecordSystem(){
        this.modules = new ArrayList<Module>();
        this.students = new ArrayList<Student>();
        this.programmes = new ArrayList<Programme>();
        this.transcripts = new ArrayList<Transcript>();
    }

    /*
    Module data is read on one line comma separated (Module Code, Name, Credits, Quality Hours)
    e.g. CS4013, Object Oriented Development, 6, 30
     */
    public void setModules(String fileName) throws IOException {
        CsvReader modulesCsv = new CsvReader(fileName);
        ArrayList<String> moduleList = modulesCsv.toArrayList();

        for(String module : moduleList){
            String[] moduleDetails = module.split(",");

            String code = moduleDetails[0].trim();
            String name = moduleDetails[1].trim();
            int credits = Integer.parseInt(moduleDetails[2].trim());
            int qualityHours = Integer.parseInt(moduleDetails[3].trim());

            Module moduleObj = new Module(code, name, credits, qualityHours);
            this.modules.add(moduleObj);
        }
    }

    /*
    Student data is read on one line comma separated (ID, name, address, course)
    e.g. 21193762, Roisin Mitchell, 31 Limerick, LM121
     */
    public void setStudents(String fileName) throws IOException {
        CsvReader studentsCsv = new CsvReader(fileName);
        ArrayList<String> studentList = studentsCsv.toArrayList();

        // Iterating over the list of students
        for(String student : studentList){
            //Splitting the line of student data at every comma, stored in an array
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

    /*
    Programme data is read on one line comma separated (Programme Type, Programme Code, Name, DurationInYears, Credits, Module1, Module2, Module3...)
    e.g. BSc, LM121, Computer Science, 4, 120, CS4004, CS4013, CS4141, ET4021, CS4023
     */
    public void setProgrammes (String fileName) throws IOException{
        CsvReader underGraduateProgrammesCsv = new CsvReader(fileName);
        ArrayList<String> programmeList = underGraduateProgrammesCsv.toArrayList();

        // Iterating over the lines of programme data in the file
        for(String programmeString : programmeList){
            //Splitting the line of programme data at every comma, stored in an array
            String[] programmeDetails = programmeString.split(",");

            // Creating variables to be used when instantiating a Programme object
            String programmeType = programmeDetails[0].trim();
            String programmeCode = programmeDetails[1].trim();
            String programmeName = programmeDetails[2].trim();
            int duration = Integer.parseInt(programmeDetails[3].trim());
            int credits = Integer.parseInt(programmeDetails[4].trim());

            ArrayList<Module> moduleList = new ArrayList<Module>();
            // Iterating over the remaining data in the array courseDetails (all the module codes associated to the course)
            for(int i = 5; i < programmeDetails.length; i++){
                // Retrieving the module information from the RecordSystem and adding the module
                Module module = getModule(programmeDetails[i].trim());
                moduleList.add(module);
            }

            Programme programme;

            if(programmeType.equalsIgnoreCase("BSc")){
                programme = new BachelorProgramme(moduleList, programmeCode, programmeName, duration, credits);

            }else if(programmeType.equalsIgnoreCase("MSc")){
                programme = new MasterProgramme(moduleList, programmeCode, programmeName, duration, credits);

            }else{
                throw new RecordSystemException("Programme type does not exist: " + programmeType);
            }

            programmes.add(programme);
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

        for(String studentGrade : moduleGrades) {
            //Splitting the line of student data at every comma and stored in an array
            String[] gradeDetails = studentGrade.split(",");
            String studentId = gradeDetails[0].trim();
            double percentGrade = Double.parseDouble(gradeDetails[1].trim());

            // Getting the grade scale from the module

            int gradeScheme = getModule(moduleCode.trim()).getGradeScheme();

            // Passing the grade scale to the grade class to be used in conversion
            Grade grade = new Grade(percentGrade, gradeScheme);

            //Locating the student in the record system
            Student student = getStudent(studentId);
            // Setting grade on the student object
            student.setGrade(module, grade);
        }

    }

    // This is reading a csv of transcripts. Not the new transcripts to be generated.
    // This will not calculate qca
    public void setTranscripts(String fileName) throws IOException {
        CsvReader transcriptsCsv = new CsvReader(fileName);
        ArrayList<String> transcriptStrings = transcriptsCsv.toArrayList();

        for (String transcriptString : transcriptStrings) {
            String[] transcriptDetails = transcriptString.split(",");

            Student student = getStudent(transcriptDetails[0].trim());
            String semester = transcriptDetails[1].trim();
            String academicYear = transcriptDetails[2].trim();
            double QCA = Double.parseDouble(transcriptDetails[3].trim());

            HashMap<Module, Grade> grades = new HashMap<>();

            for (int i = 4; i < transcriptDetails.length; i++) {
                Module module = getModule(transcriptDetails[i].trim());
                i++;
                Grade grade = new Grade(transcriptDetails[i].trim());
                grades.put(module, grade);
            }

            Transcript transcript = new Transcript(student, semester, academicYear, QCA, grades);
            this.transcripts.add(transcript);

        }
    }


    /* The holdReview method will be an option on the menu.
    It will signify the end of the semester grading period and
    should trigger the review of every student.
    This review is the creation of the transcripts & the return of
    those transcripts either to screen or to csv file (or both).
     */
    public ArrayList<Transcript> holdReview(){

        ArrayList<Transcript> semesterTranscripts = new ArrayList<>();

        for(Student student : students){
            Transcript transcript = new Transcript(student, "1", "23/24");  // Why is semester and year a string you are entering here??
            semesterTranscripts.add(transcript);
        }

        return semesterTranscripts;
    }

    public ArrayList<Module> getModules(){
        return this.modules;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public ArrayList<Programme> getProgrammes(){
        return this.programmes;
    }


    public Module getModule(String moduleCode){
        for(Module module : modules){
            boolean match = module.getModuleCode().equalsIgnoreCase(moduleCode);
            if(match){
                return module;
            }
        }
        throw new RecordSystemException("Module not found: " + moduleCode);
    }


    public Student getStudent(String studentID){
        for(Student student : students){
            boolean match = student.getStudentID().equalsIgnoreCase(studentID);
            if(match){
                return student;
            }
        }
        throw new RecordSystemException("Student not found: " + studentID);
    }

    public Programme getProgramme(String programmeCode){
        for(Programme programme : programmes){
            boolean match = programme.getProgrammeCode().equalsIgnoreCase(programmeCode);

            if(match){
                return programme;
            }
        }
        throw new RecordSystemException("Student not found: " + programmeCode);
    }



}

