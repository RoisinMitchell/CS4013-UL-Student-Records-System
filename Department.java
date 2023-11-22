import java.util.ArrayList;
import java.util.HashMap;

public class Department {

    private ArrayList<PostGraduateProgramme> postGradProgrammes;
    private ArrayList<UnderGraduateProgramme> underGradProgrammes;

    private ArrayList<Transcript> postGradTranscripts;
    private ArrayList<Transcript> underGradTranscripts;

    public void holdReview(ArrayList<Transcript> transcripts) {

        ArrayList<Student> postGradList = postGradProgrammes.getStudents();

        for (Student student : postGradList) {
            Transcript transcript = new Transcript(student, "Sem1", "23/24");
            postGradTranscripts.add(transcript);
        }

        ArrayList<Student> underGradList = underGradProgrammes.getStudents();

        for (Student student : underGradList) {
            Transcript transcript = new Transcript(student, "Sem1", "23/24");
            underGradTranscripts.add(transcript);
        }

    }

    /*
    //Sets a variable on the transcript that shows if a student needs to repeat any module
    private void requestRepeatModule(Transcript transcript){
        transcript.setRepeatModule();
    }


    private void requestRepeatSemester(Transcript transcript){
        transcript.setRepeatYear();
    }

     */

        }
