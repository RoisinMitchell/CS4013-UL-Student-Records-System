import java.util.ArrayList;

public class TradtionalPhd extends PhdProgramme {

    private boolean thesisPassOrFail;
    private int ECTSCredits;

    // no modules, awarded 
    // pass/Fail
    public TradtionalPhd(ArrayList<Module> modules, String programmeCode, String programmeName, int duration,
            int credits, boolean thesisPassOrFail, int ECTSCredits) {
        super(modules, programmeCode, programmeName, duration, credits);
        this.thesisPassOrFail = thesisPassOrFail;
        this.ECTSCredits = ECTSCredits;
    }

    public void setThesisPassOrFail(boolean thesisPassOrFail){
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public boolean getThesisPassOrFail(){
        return thesisPassOrFail;
    }

    public void setECTSCredits(int ECTSCredits){
        this.ECTSCredits = ECTSCredits;
    }

    public int getECTSCredits(){
        return ECTSCredits;
    }

    public boolean calculateProgression(Transcript transcript){
        if(thesisPassOrFail){
            // or setECTSCredits(270)?
            return true;
        }
        return false;
        
    }
    
    
}
