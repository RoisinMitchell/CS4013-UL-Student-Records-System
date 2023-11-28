import java.util.ArrayList;

public class StructuredPhd extends PhdProgramme {
    private boolean thesisPassOrFail;
    private int ECTSCredits;

    // 1st class houers
    public StructuredPhd(ArrayList<Module> modules, String programmeCode, String programmeName, int duration,
                         int credits, boolean thesisPassOrFail, int ECTSCredits) {
        super(modules, programmeCode, programmeName, duration, credits);
        this.thesisPassOrFail = thesisPassOrFail;
        this.ECTSCredits = ECTSCredits;
    }

    public boolean calculateProgression(Transcript transcript) {
        // check 
        // QCA
        // thesis
        if (thesisPassOrFail && transcript.getCumulativeQCA() > 2.0) {
            return true;
        }
        return false;
    }

    public boolean isThesisPassOrFail() {
        return thesisPassOrFail;
    }

    public void setThesisPassOrFail(boolean thesisPassOrFail) {
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public int getECTSCredits() {
        return ECTSCredits;
    }

    public void setECTSCredits(int eCTSCredits) {
        ECTSCredits = eCTSCredits;
    }
}
