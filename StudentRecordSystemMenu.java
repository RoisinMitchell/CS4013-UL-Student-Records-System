import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecordSystemMenu {
    
    private Scanner in;

    private StudentRecordSystem system;

    private ArrayList<Transcript> transcript;

    public StudentRecordSystemMenu(){
        in = new Scanner(System.in);
        system = new StudentRecordSystem();
        try {
        system.setModules("Modules.csv");
        system.setProgrammes("Programmes.csv");
        system.setStudents("Students.csv");
        } catch (IOException e){
            System.out.println("Something Failed up");
        };
        // further setup
    }

    public void run() throws IOException{
        
        boolean running = true;
        
        while(running){
            System.out.println("1) Add Grades 2) Review 3) Quit");
            
            String command = in.nextLine();
            
            if(command.equals("1")){
                System.out.println("Input Filename E.g ModuleGrade.csv");
                command = in.nextLine();
                system.setGrades(command);
                
            }else if(command.equals("2")){
                System.out.println("Making Transcripts");
                
                System.out.println("1) Individual Transcript 2) All Transcripts 3) Quit");

                command = in.nextLine();

                if(command.equals("1")){
                    
                    System.out.println("NOT YET IMPLEMENTED");

                }else if (command.equals("2")){

                    Department department = new Department();
                    department.holdReview(transcript, system.getPostGraduateProgrammes());
                    department.getPostGradTranscripts();
                    System.out.println(department.getPostGradTranscripts());


                }else if (command.equals("3")){
                    running = false;
                }else {
                    System.out.println("Invalid input");
                }
            

            }else if(command.equals("3")){
                
                System.out.println("Quiting");
                running = false;
            }else{

                System.out.println("Invaild command");
            }
           
        }
    }

} 
