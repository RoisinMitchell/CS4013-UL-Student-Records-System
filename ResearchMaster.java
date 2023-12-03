
import java.util.ArrayList;

public class ResearchMaster extends MasterProgramme {

    private boolean thesisPassOrFail;
    private int ECTSCredits;


    public ResearchMaster(String programmeCode, String programmeName, int duration, int credits) {
        super(programmeCode, programmeName, duration, credits);
        this.ECTSCredits = credits;
    }

    public void setThesis(boolean thesisPassOrFail) {
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public int getECTSCredits() {
        return ECTSCredits;
    }

    public boolean calculateProgression(Transcript transcript) {

        if (!thesisPassOrFail) {
            return false;
        }
        return true;
    }
}
