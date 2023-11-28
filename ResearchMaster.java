
import java.util.ArrayList;

public class ResearchMaster extends MasterProgramme {
    
    private boolean thesisPassOrFail;
    private int ectCredits;


    public ResearchMaster(String programmeCode, String programmeName, int duration, int credits, int ectCredits) {
        super(programmeCode, programmeName, duration, credits);
        this.ectCredits = ectCredits;
    }
    
    public void setThesis(boolean thesisPassOrFail){
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public int getEct(){
        return ectCredits;
    }
    public boolean calculateProgression(Transcript transcript){

        if(!thesisPassOrFail){
            return false;
        }

        return true;

    }
}
