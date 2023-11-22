import java.util.ArrayList;

public class PostGraduateProgramme implements Programme{
    private String programeCode;
    private String programeName;
    private int duration;
    private int requiredCredits;
    private ArrayList<Module> moduleList;
    private ArrayList<Student>   students = new ArrayList<Student>();



    
    public PostGraduateProgramme(String programeCode, String programeName, int duration, int requiredCredits, ArrayList<Module> moduleList, ArrayList<Student> students){
        this.programeCode = programeCode;
        this.programeName = programeName;
        this.duration = duration;
        this.requiredCredits = requiredCredits;
        this.moduleList = moduleList;
        for (int i = 0; i< students.size(); i++ ){
            if((students.get(i)).getCourse() == programeCode){
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
    @Override
    public ArrayList<Student> getStudents(){
        return students;
    }
    public int getRequiredCredits() {
        return requiredCredits;
    }


}
