import java.util.ArrayList;

public class QCACalculator {
    
     * Knows QPV
     * Knows module credits
     * Can Calculate QCS (QPV * Credits)
     * Can calculate QCA
     

    StudentRecordSystem recordSystem = new StudentRecordSystem();
    private ArrayList<Grade> gradesList = recordSystem.getGrades();
    private ArrayList<Module> modulesList = recordSystem.getModules();
    
    public double getQPV(String studentID) {
        gradesList = recordSystem.getGrades();
        double studentQPV = 0.0;
        for (Grade grade : gradesList) {
            if (grade.getStudentID().equals(studentID)) {
                String studentGrade = grade.getGradeByID(studentID);
                studentQPV = grade.getQPV(studentGrade);
            }
        }
        return studentQPV;
    }

    public int getModuleCreditsByID(String studentID){
        int moduleCredits = 0;
        String moduleCode = "";
        for (Grade grade : gradesList) {
            if (grade.getStudentID().equals(studentID)) {
                moduleCode = grade.getModuleCodeByID(studentID);
            }
        }
        for (Module module : modulesList) {
            moduleCredits = module.getModuleCreditsByCode(moduleCode);
        }
        return moduleCredits;
    }

    public double calculateQCS(String studentID) {
        return getQPV(studentID) * getModuleCreditsByID(studentID);
    }

    public double calculateQCA() {
        // sumation of QCS/sumation of(AH-NQH)
        return 1.0;
    }
 
}
