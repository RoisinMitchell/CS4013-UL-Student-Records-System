import java.util.ArrayList;

public class PostGraduateProgramme implements Programme{
    private String programmeCode;
    private String programmeName;
    private int duration;
    private int requiredCredits;
    private ArrayList<Module> moduleList;
    private ArrayList<Student>   students = new ArrayList<Student>();



    
    public PostGraduateProgramme(String programmeCode, String programmeName, int duration, int requiredCredits, ArrayList<Module> moduleList, ArrayList<Student> students){
        this.programmeCode = programmeCode;
        this.programmeName = programmeName;
        this.duration = duration;
        this.requiredCredits = requiredCredits;
        this.moduleList = moduleList;
        for (int i = 0; i< students.size(); i++ ){
            if((students.get(i)).getProgramme() == programmeCode){
                students.add(students.get(i));
            }
        }
    }
  

    @Override
    public void addModules(ArrayList<Module> modules) {

    }

    @Override
    public void enrollStudents(ArrayList<Student> students){

    }

    public ArrayList<Student> getStudents(){
        return students;
    }
    public int getRequiredCredits() {
        return requiredCredits;
    }


}
