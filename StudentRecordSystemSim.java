import java.io.IOException;

/**
 * The main class for the Student Record System simulation.
 * This class contains the main method that initialises the system menu and starts the simulation.
 */
public class StudentRecordSystemSim {
    public static void main(String[] args) throws IOException {

        StudentRecordSystemMenu menu = new StudentRecordSystemMenu();
        menu.run();
    }
} 
