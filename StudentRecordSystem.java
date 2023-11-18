import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import java.util.ArrayList;

public class StudentRecordSystem{

    private ArrayList<Module> modules; // Database of modules
    private ArrayList<Student> students; // Database of students
    private ArrayList<Course> courses; // Database of courses
    private ArrayList<Grade> grades; // Database of grades


    public StudentRecordSystem(){
        modules = new ArrayList<Module>();
        students = new ArrayList<Student>();
        courses = new ArrayList<Course>();
        grades = new ArrayList<Grade>();
    }

    /*
    Initialises the database of modules stored in the csv
    Module data is read on one line comma separated (Module Code, Name, Credits, Quality Hours)
    e.g. CS4013, Object Oriented Development, 6, 30
     */
    public void setModules(String fileName) throws IOException {
        ArrayList<String> moduleList = fileToArrayList(fileName);

        for(String student : moduleList){
            String[] moduleDetails = student.split(",");
            String code = moduleDetails[0].trim();
            String name = moduleDetails[1].trim();
            int credits = Integer.parseInt(moduleDetails[2].trim());
            int qualityHours = Integer.parseInt(moduleDetails[3].trim());

            Module moduleObj = new Module(code, name, credits, qualityHours);
            modules.add(moduleObj);

        }
    }

    /*
    Initialises the database of students stored in the csv
    Student data is read on one line comma separated (ID, name, address, course)
    e.g. 21193762, Roisin Mitchell, 31 Limerick, LM051
     */
    public void setStudents(String fileName) throws IOException {
        ArrayList<String> studentList = fileToArrayList(fileName);

        // Iterating over the list of students
        for(String student : studentList){
            //Splitting the line of student data at every comma, stored in an array
            String[] studentDetails = student.split(",");

            // Creating variables to be used when instantiate a Course object
            String id = studentDetails[0].trim();
            String name = studentDetails[1].trim();
            String address = studentDetails[2].trim();
            String course = studentDetails[3].trim();

            // Instantiating a Course object and storing in array list
            Student studentObj = new Student(id, name, address, course);
            students.add(studentObj);
        }
    }

    /*
    Initialises a database of grades stored in the csv
    grade data is read on one line comma separated (studentID, moduleCode, courseCode, grade)
    e.g. 22334728, CS4013, LM051, A1
     */
    public void setCourses(String fileName) throws IOException{
        ArrayList<String> gradeList = fileToArrayList(fileName);

        // Iterating over the lines of grade data in the file
        for(String gradeLine : gradeList){
            //Splitting the line of course data at every comma, stored in an array
            String[] gradeDetails = gradeLine.split(",");

            // Creating variables to be used when instantiate a Course object
            String studentID = gradeDetails[0].trim();
            String moduleCode = gradeDetails[1].trim();
            String courseCode = gradeDetails[2].trim();
            String grade = gradeDetails[3].trim();

            // Instantiating a Grade object and storing in array list
            Grade gradeObj = new Grade(studentID, moduleCode, courseCode, grade);
            grades.add(gradeObj);
        }
    }

    /*
    Initialises the database of students stored in the csv
    Student data is read on one line comma separated (ID, name, address, course)
    e.g. 21193762, Roisin Mitchell, 31 Limerick, LM051
     */
    public void setGrades(String fileName) throws IOException {
        ArrayList<String> studentList = fileToArrayList(fileName);

        // Iterating over the list of students
        for(String student : studentList){
            //Splitting the line of student data at every comma, stored in an array
            String[] studentDetails = student.split(",");

            // Creating variables to be used when instantiate a Course object
            String id = studentDetails[0].trim();
            String name = studentDetails[1].trim();
            String address = studentDetails[2].trim();
            String course = studentDetails[3].trim();

            // Instantiating a Course object and storing in array list
            Student studentObj = new Student(id, name, address, course);
            students.add(studentObj);
        }
    }

    // Method converts a csv file into an array list, where each line of the csv is at an index of the array list
    public ArrayList<String> fileToArrayList(String fileName) throws IOException {
        // Try read the file in
        try (BufferedReader buffer = new BufferedReader(new FileReader(fileName))) {
            String line;
            ArrayList<String> lines = new ArrayList<String>();

            // Iterating over each line in the file until there is no line left
            while ((line = buffer.readLine()) != null) {
                // Adding the line to an array list
                lines.add(line);
            }
            return lines;
        }
    }


    public ArrayList<Module> getModules(){
        return this.modules;
    }

    public ArrayList<Student> getStudents(){
        return this.students;
    }

    public ArrayList<Course> getCourses(){
        return this.courses;
    }

    public Module getModule(String moduleCode){
        for(Module module : modules){
            boolean match = module.getModuleCode().equals(moduleCode);
            if(match){
                return module;
            }
        }
        throw new RuntimeException("not a module"); //change to throw exception "module not in records"
    }
}

