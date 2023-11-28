import java.util.ArrayList;

public class MasterProgramme extends Programme{
    

    public MasterProgramme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }
     public MasterProgramme( String programmeCode, String programmeName, int duration, int credits) {
        super(programmeCode, programmeName, duration, credits);
    }
    


    public boolean calculateProgression(Transcript transcript){
        if (!super.calculateProgression(transcript)){
            return false;
        }
        return true;
    }
}
