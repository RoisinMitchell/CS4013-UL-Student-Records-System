import java.util.ArrayList;

public class UnderGraduateProgramme implements Programme{

    private ArrayList<Student> students; 
    private StudentRecordSystem recordSystem;

    /**
     * 
     * @return
     
    public ArrayList<Transcript> getTranscripts() {
        return transcripts;
    }*/

    public ArrayList<Student> getProgramOfStudents(){
        ArrayList<Student> studentsArrayList = recordSystem.getStudents();
        for (Student students: studentsArrayList){
            // check if the student doing a UnderGraduateProgramme
        }
        return students;

    }

    @Override
    public void enrollStudents(ArrayList<Student> students){

    }

    @Override
    public void getModule(ArrayList<Module> modules) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getModule'");
    }


}
