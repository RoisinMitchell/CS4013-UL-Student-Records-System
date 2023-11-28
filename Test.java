import java.io.IOException;
import java.util.ArrayList;

public class Test {
    public static void main(String[] args) throws IOException {
        StudentRecordSystem system = new StudentRecordSystem();
        system.setRecords("Records/Modules.csv", "Records/Programmes.csv", "Records/Students.csv", "Records/Transcripts.csv");

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

        system.setGrades("1-CS4012.csv");
        system.setGrades("1-CS4043.csv");
        system.setGrades("1-CS4141.csv");
        system.setGrades("1-CS4221.csv");
        system.setGrades("1-CS4222.csv");

        ArrayList<Transcript> transcriptsNew = system.holdReview();

        for(Transcript transcript : transcriptsNew){
            System.out.println("------------\nNEW TRANSCRIPT\n" + transcript.toString() + "\n");
        }

        system.exportTranscripts("Transcripts.csv");

    }
}
