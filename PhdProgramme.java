import java.util.ArrayList;

public class PhdProgramme extends Programme {

    private int ECTSCredits;
    private boolean thesisPassOrFail;
    private String award;

    public PhdProgramme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }

    public void setECTSCredits(int ECTSCredits) {
        this.ECTSCredits = ECTSCredits;
    }

    public int getECTSCredits() {
        return ECTSCredits;
    }

    public boolean isThesisPassOrFail() {
        return thesisPassOrFail;
    }

    public void setThesisPassOrFail(boolean thesisPassOrFail) {
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public String getAward() {
        return award;
    }

    public void setAward(String award) {
        this.award = award;
    }

    public boolean calculateProgression(Transcript transcript) {
        if (transcript.getCumulativeQCA() > 2.0 && transcript.getStudent().getProgramme().getCredits() == super.getCredits()) {
            return true;
        }
        return false;

    }

}