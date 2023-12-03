import java.util.ArrayList;

public class TradtionalPhd extends PhdProgramme implements Review {

    private boolean thesisPassOrFail;

    // no modules, awarded
    // pass/Fail
    public TradtionalPhd(ArrayList<Module> modules, String programmeCode, String programmeName, int duration,
            int credits, boolean thesisPassOrFail) {
        super(modules, programmeCode, programmeName, duration, credits);
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public void setThesisPassOrFail(boolean thesisPassOrFail) {
        this.thesisPassOrFail = thesisPassOrFail;
    }

    public boolean getThesisPassOrFail() {
        return thesisPassOrFail;
    }

    public boolean calculateProgression(Transcript transcript) {
        if (thesisPassOrFail) {
            transcript.getStudent().getProgramme().setCredits(270);
            setAward(getAward());
            return true;
        }
        return false;

    }

    @Override
    public boolean reviewCredits(Student student) {
        int credits = student.getProgramme().getCredits();
        // if ()
        return thesisPassOrFail;

    }

    @Override
    public boolean reviewRepeat(Student student) {
        if (!student.isTheisPassOrFail()) {
            // fail
            // goes to repeater.csv
            return true;
        }
        return false;
    }

    @Override
    public boolean reviewProgression(Student student) {
        boolean progression = true;
        ArrayList<Transcript> previousTranscripts = student.getPreviousTranscripts();
        for (Transcript transcript : previousTranscripts) {
            if (!transcript.isProgression()) {
                progression = false;
            }
        }
        return progression;
    }

    @Override
    public boolean reviewGraduate(Student student) {
        if (student.getAwardType() != "NOTPROGRESS") {
            return true;
        }
        return false;

    }

}
