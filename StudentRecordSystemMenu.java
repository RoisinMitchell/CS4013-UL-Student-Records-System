import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecordSystemMenu {
    
    private Scanner in;

    private StudentRecordSystem recordSystem;

    private ArrayList<Transcript> transcript;

    public StudentRecordSystemMenu(){
        in = new Scanner(System.in);

        recordSystem = new StudentRecordSystem();

        try {

        
        
        recordSystem.setModules("Modules.csv");

        recordSystem.setProgrammes("Programmes.csv");

        recordSystem.setStudents("Students.csv");



        
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
                recordSystem.setGrades(command);
                
            }else if(command.equals("2")){
                System.out.println("Making Transcripts");
                
                System.out.println("1) Individual Transcript 2) All Transcripts 3) Quit");

                command = in.nextLine();

                if(command.equals("1")){
                    
                    System.out.println("NOT YET IMPLEMENTED");

                }else if (command.equals("2")){

            
                    ArrayList<Transcript> transcripts = recordSystem.holdReview();
                    for(Transcript transcript: transcripts){
                        System.out.println(transcript.toString() + "");
                    }


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
