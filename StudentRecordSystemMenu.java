import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
public class StudentRecordSystemMenu {
    
    private Scanner in;

    private StudentRecordSystem recordSystem;

    private ArrayList<Transcript> transcript;
    private boolean running;


    public StudentRecordSystemMenu(){
        
        // scanner
        in = new Scanner(System.in);

        running = true;

        // record system object
        recordSystem = new StudentRecordSystem();

        try {

        // loading of the "database"
        
        recordSystem.setModules("Modules.csv");

        recordSystem.setProgrammes("Programmes.csv");

        recordSystem.setStudents("Students.csv");

        recordSystem.setTranscripts("Transcripts.csv");

        
        } catch (IOException e){
            // in case something goes wrong in the booting of the database
            System.out.println("Falied to Load Database");
            running = false;
            
        };
        // further setup
    }

    public void run() throws IOException{
        
        
        while(this.running){
            System.out.println("1) Add Grades 2) Review 3) Quit");
            
            String command = in.nextLine();
            
           




            if(command.equals("1")){
                System.out.println("Input Filename E.g ModuleGrade.csv");
                command = in.nextLine();
                recordSystem.setGrades(command);
                
            }else if(command.equals("2")){
                System.out.println("Making Transcripts");
                
                System.out.println("1) Individual Transcript 2) All Transcripts 3) Back 4) Quit");

                command = in.nextLine();

                ArrayList<Transcript> transcripts = recordSystem.holdReview();
                
                boolean secondMenu = true;

                while (secondMenu){
               
                if(command.equals("1")){
                    
                    System.out.println("Student id e.g");


                    String student = in.nextLine();

                    
                        for(Transcript transcript: transcripts){
                        
                            if((transcript.getStudent()).getStudentID().equals(student) ){
                                System.out.println("Student id, Name, Address, CourseCode, Course Name, Course Length, Semster, Year, QCA, Module Code, Module Name, Credits, Hours, Grade");
                                System.out.println(transcript);
                            }
                            
                        }

                }else if (command.equals("2")){
                    System.out.println("Student id, Name, Address, CourseCode, Course Name, Course Length, Semster, Year, QCA, Module Code, Module Name, Credits, Hours, Grade");
                    for(Transcript transcript: transcripts){
                        System.out.println(transcript.toString() + "");
                    }
                    


                }else if (command.equals("3")){
                    
                    
                    secondMenu = false;
                    System.out.println("Add Grades");


                }else if(command.equals("4")){

                   
                    this.running = false;
                    secondMenu = false;
                    System.out.println("Quiting");
                }
                
                
                else {
                    System.out.println("Invalid input");
                }
            }

            }// FOR TESTING TO BE REMOVED 
            else if (command.equals("test")){

                //FOR TESTING SET GRADES
                    recordSystem.setGrades("ModuleGrade.csv");
                    recordSystem.setGrades("ModuleGrade2.csv");
                    recordSystem.setGrades("ModuleGrade3.csv");
                    recordSystem.setGrades("ModuleGrade4.csv");

                    ArrayList<Transcript> test = recordSystem.holdReview();

                     for(Transcript transcript: test){
                        
                            if((transcript.getStudent()).getStudentID().equals("230000") ){
                                
                                System.out.println(transcript);
                            }
                            
                        }                    
                    running = false;

         
                }else if(command.equals("3")){
                
                System.out.println("Quiting");
                this.running = false;
            }else{

                System.out.println("Invaild command");
            }
           
        }
    }

} 
