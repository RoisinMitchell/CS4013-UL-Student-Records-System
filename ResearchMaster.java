
import java.util.ArrayList;

public class ResearchMaster extends MasterProgramme {
    
    private boolean thesisPassOrFail;
    private int ect;


    public ResearchMaster(String programmeCode, String programmeName, int duration, int credits) {
        super(programmeCode, programmeName, duration, credits);
        this.ect = 180;
    }
    
    public void setThesis(boolean thesisPassOrFail){
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public int getEct(){
        return ect;
    }
    public boolean calculateProgression(Transcript transcript){

        if(!thesisPassOrFail){
            return false;
        }

        return true;

    }
}
