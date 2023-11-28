import java.util.ArrayList;

public class TaughtMaster extends MasterProgramme {
    

    public TaughtMaster(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }


    public boolean calculateProgression(Transcript transcript){
        if(!super.calculateProgression(transcript)){
            return false;
        }
        return true;
    }
    
}
