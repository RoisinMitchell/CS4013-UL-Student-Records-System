import java.util.ArrayList;

public class Masters extends Programme {
      private boolean thesisPassOrFail;

    public Masters(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }
    

    public void setThesis(boolean thesis){
        this.thesisPassOrFail = thesis;
    }
}
