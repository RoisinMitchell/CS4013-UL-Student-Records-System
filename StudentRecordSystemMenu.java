import java.io.IOException;
import java.util.Scanner;
public class StudentRecordSystemMenu {
    private Scanner in;
    private StudentRecordSystem system;
    public StudentRecordSystemMenu(){
        in = new Scanner(System.in);
        system = new StudentRecordSystem();
        try {
        system.setModules("Modules.csv");
        system.setCourses("Courses.csv");
        system.setStudents("Students.csv");
        } catch (IOException e){
            System.out.println("Something Failed up");
        };
        // further setup
    }

    public void run() throws IOException{
        boolean running = true;
        while(running){
            
            System.out.println("1)Add Student Grades\n2)Transcripts\n3)Review \n4)Add Students\n5)Quit" );
            String command = in.nextLine();
            if(command.equals("1")){
                System.out.println("Type Filename");
                command = in.nextLine();
                system.setGrades(command);
                System.out.println("Thank you");
                //system.addGrades(Command);
            }
            else if(command.equals("2")){
                
                System.out.println("1) Individual Student\n 2) All Students");
                


            }
            else if(command.equals("3")){

                System.out.println("This works");
            
            }else if(command.equals("4")){

                System.out.println("1) Individual Student\n 2) Mutiply Students");

                command = in.nextLine();

                if(command.equals("1")){
                    // NEEDS MORE WORK
                    System.out.println("id, name, address, currentYear");
                }
                else if(command.equals("2")){

                    System.out.println("filename");

                    command = in.nextLine();
                    
                     /*    try{
                           // system.addStudents(command); // NEEDS WAY TO ADD STUDENTS NOT JUST REPLACE ALL OF EM
                        } catch (IOException e){
                            System.out.println("Invalid file name");
                        } */
                    }
                    
                
               
            }else if(command.equals("5")){
                
                System.out.println("Exiting");
                running = false;
            }else{
               System.out.println("Invaild Command");
            }

        }
    }

} 
