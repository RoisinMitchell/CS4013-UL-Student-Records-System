import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecordSystemMenu {
    
    private Scanner in;

    private StudentRecordSystem recordSystem;

    private ArrayList<Transcript> thisYearsTranscripts;
    private boolean running;

    public StudentRecordSystemMenu(){
        // scanner
        in = new Scanner(System.in);
        running = true;
        recordSystem = new StudentRecordSystem();

        //Setting existing records for the system to run on
        try {
            recordSystem.setRecords("Modules.csv", "Programmes.csv", "Students.csv", "Transcripts.csv");
        } catch (IOException e){
            System.out.println("Failed to load files. Check if the files exist or check that the file follows the conventions");
            running = false;
        }
    }

    public void run() throws IOException{
        while(this.running){
            System.out.println("\nChoose an option:");
            System.out.println("1) Submit module grades \n2) Hold review \n3) Quit");
            
            String command = in.nextLine();

            if(command.equals("1")){
                System.out.println("Input Filename e.g. ModuleGrade.csv");
                command = in.nextLine();
                recordSystem.setGrades(command);
                
            }else if(command.equals("2")){
                System.out.println("\nEnd of grading period. Now calculating transcripts...\n");
                System.out.println("Choose an option:");
                System.out.println("1) Student transcript\n2) Current semester transcripts\n3) Back \n4) Quit");

                command = in.nextLine();

                this.thisYearsTranscripts = recordSystem.holdReview();

                boolean secondMenu = true;

                while (secondMenu) {
                    if (command.equals("1")) {
                        System.out.println("Student ID e.g. 2118737");

                        String student = in.nextLine();

                        for (Transcript transcript : thisYearsTranscripts) {
                            if ((transcript.getStudent()).getStudentID().equals(student)) {
                                System.out.println("Student ID, Semester, Academic Year, Semester QCA, Cumulative QCA, Module, Grade, Module, Grade,...");
                                System.out.println(transcript.toString());
                            }
                        }



                    } else if (command.equals("2")) {
                        System.out.println("Student ID, Semester, Academic Year, Semester QCA, Cumulative QCA, Module, Grade, Module, Grade,...");
                        for (Transcript transcript : thisYearsTranscripts) {
                            System.out.println(transcript.toString() + "");
                        }
                        // Closing the menu down
                        secondMenu = false;
                        running = false;

                    } else if (command.equals("3")) {
                        secondMenu = false;
                        System.out.println("Add Grades");

                    } else if (command.equals("4")) {
                        this.running = false;
                        secondMenu = false;
                        System.out.println("Quiting");

                    } else {
                        System.out.println("Invalid input");
                    }
                }
            }// FOR TESTING TO BE REMOVED 
            else if (command.equals("test")){

                //FOR TESTING SET GRADES
                    recordSystem.setGrades("ET4011-Grades.csv");
                    recordSystem.setGrades("CS4043-Grades.csv");
                    recordSystem.setGrades("CS4141-Grades.csv");
                    recordSystem.setGrades("MA4111-Grades.csv");
                    recordSystem.setGrades("CS4221-Grades.csv");

                    ArrayList<Transcript> test = recordSystem.holdReview();

                     for(Transcript transcript: test){
                         System.out.println(transcript.toString() + "\n");
                     }

                    running = false;

            }else if(command.equals("3")){
                System.out.println("Quiting");
                this.running = false;

            }else{
                System.out.println("Invalid command");
            }
        }
    }
} 
