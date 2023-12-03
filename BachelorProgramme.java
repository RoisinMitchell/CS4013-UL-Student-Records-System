import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Set;

public class BachelorProgramme extends Programme implements Review {
    public BachelorProgramme(ArrayList<Module> modules, String programmeCode, String programmeName, int duration, int credits) {
        super(modules, programmeCode, programmeName, duration, credits);
    }

    @Override
    public boolean determineStudentProgression(Transcript transcript) {
        Student student = transcript.getStudent();
        LinkedHashMap<Module, Grade> grades = transcript.getGrades();
        Set<Module> modules = grades.keySet();
        double semesterQca = 0;

        if(transcript == null){
            ArrayList<Transcript> transcripts = student.getTranscripts();
            semesterQca = transcripts.get(transcripts.size()-1).getSemesterQCA();
        }else{
            semesterQca = transcript.getSemesterQCA();
        }

        for (Module module : modules) {
            String grade = grades.get(module).getGradeLetter();
            if (grade.equals("F") || grade.equals("NG") || grade.equals("I")) {
                return false;
            } else if (grade.equals("D1") || grade.equals("D2") && semesterQca < 2.00) {
                return false;
            } else if (semesterQca < 2.00){
                return false;
            }
        }
        return true;
    }

    @Override
    public String getAwardType(Student student) {
        return null;
    }

    @Override
    public String determineRepeatStatus(Transcript transcript) {
        String repeatStatus;
        ArrayList<Module> repeatModules = new ArrayList<>();

        LinkedHashMap<Module, Grade> grades = transcript.getGrades();

        Set<Module> modules = grades.keySet();
        double semesterQca = transcript.getSemesterQCA();

        for (Module module : modules) {
            String grade = grades.get(module).getGradeLetter();
            if (grade.equals("F") || grade.equals("NG") || grade.equals("N")) {
                repeatModules.add(module);
            }
        }

        if (semesterQca < 2.00) {
            for (Module module : modules) {
                String grade = grades.get(module).getGradeLetter();
                if (grade.equals("D1") || grade.equals("D2")) {
                    repeatModules.add(module);
                }
            }
        }

        // Checking if QCA >= 2.00 is achievable after repeating modules
        // Grade is capped at C3 for repeats
        LinkedHashMap<Module, Grade> projectedGrades = new LinkedHashMap<>();
        projectedGrades.putAll(transcript.getGrades());
        for (Module module : repeatModules) {
            Grade maxGrade = new Grade("C3");
            projectedGrades.replace(module, maxGrade);
        }

        QCACalculator qca = new QCACalculator(projectedGrades);
        double projectedQca = qca.calculateSemesterQca();

        if (projectedQca >= 2.00 && repeatModules.size() <= 3){
            repeatStatus = "Repeat Exam";
            for (Module module : repeatModules) {
                repeatStatus += ", " + module.getModuleCode();
            }
        } else {
            repeatStatus = "Repeat Semester, " + transcript.getSemester();
        }
        return repeatStatus;
    }

}