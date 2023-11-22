import java.util.ArrayList;

public class Department {

    private ArrayList<PostGraduateProgramme> postGradProgrammes;
    private ArrayList<UnderGraduateProgramme> underGradProgrammes;

    public void holdReview(ArrayList<Transcript> transcripts){
        /*
        if module fail - requestRepeatModule(transcript);
        if enough modules failed - requestRepeatSemester(transcript);
        After setting the progression on the bottom of transcript write all transcripts to csv
         */
    }

    //Sets a variable on the transcript that shows if a student needs to repeat any module
    private void requestRepeatModule(Transcript transcript){
        transcript.setRepeatModule();
    }


    private void requestRepeatSemester(Transcript transcript){
        transcript.setRepeatYear();
    }

}
