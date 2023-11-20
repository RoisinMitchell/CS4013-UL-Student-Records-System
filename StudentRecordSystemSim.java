import java.io.IOException;

public class StudentRecordSystemSim {

    // Initialise student record system (database)
    // Provide Command Line Interface functionality
   public static void main(String[] args) throws IOException{
    
    StudentRecordSystemMenu menu = new StudentRecordSystemMenu();
    menu.run();
   }
} 
