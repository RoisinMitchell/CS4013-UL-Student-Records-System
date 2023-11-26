import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        StudentRecordSystem system = new StudentRecordSystem();
        system.setRecords("Modules.csv", "Programmes.csv", "Students.csv", "Transcripts.csv");

        ArrayList<Module> modules = system.getModules();
        ArrayList<Programme> programmes = system.getProgrammes();
        ArrayList<Student> students = system.getStudents();
        ArrayList<Transcript> transcripts = system.getPreviousTranscripts();

        for(Module module : modules){
            System.out.println(module.toString());
        }

        for(Programme programme : programmes){
            System.out.println(programme.toString());
        }

        for(Student student : students){
            System.out.println(student.toString());
        }

        system.setGrades("ET4011-Grades.csv");
        system.setGrades("CS4043-Grades.csv");
        system.setGrades("CS4141-Grades.csv");
        system.setGrades("MA4111-Grades.csv");
        system.setGrades("CS4221-Grades.csv");

        ArrayList<Transcript> transcriptsNew = system.holdReview();

        for(Transcript transcript : transcriptsNew){
            System.out.println("------------\nNEW TRANSCRIPT\n" + transcript.toString() + "\n");
        }

        system.exportTranscripts("Transcripts.csv");

    }
}
