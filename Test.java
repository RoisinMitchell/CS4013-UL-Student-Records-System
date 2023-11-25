import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        StudentRecordSystem system = new StudentRecordSystem();

        system.setModules("Modules.csv");
        ArrayList<Module> modules = system.getModules();

        for(Module module : modules){
            System.out.println(module.toString());
        }

        system.setProgrammes("Programmes.csv");
        ArrayList<Programme> programmes = system.getProgrammes();

        for(Programme programme : programmes){
            System.out.println(programme.toString());
        }

        system.setStudents("Students.csv");
        ArrayList<Student> students = system.getStudents();

        for(Student student : students){
            System.out.println(student.toString());
        }
    }
}
