import java.util.ArrayList;

public class Master extends Programme {
    private boolean thesisPassOrFail;

    public Master(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }


    public void setThesis(boolean thesis) {
        this.thesisPassOrFail = thesis;
    }
}
