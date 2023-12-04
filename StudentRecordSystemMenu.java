import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Represents the menu interface for the Student Record System simulation.
 * This class manages user interactions and serves as the main entry point for
 * the simulation.
 */
public class StudentRecordSystemMenu {
    private final Scanner in;
    private final StudentRecordSystem recordSystem;
    private ArrayList<Transcript> transcripts;

    private boolean running;

    /**
     * Constructs a StudentRecordSystemMenu object, initialising the scanner, system
     * records, and running status.
     * Loads existing records for the system to run on.
     */
    public StudentRecordSystemMenu() {
        in = new Scanner(System.in);
        running = true;
        recordSystem = new StudentRecordSystem();

        try {
            recordSystem.setRecords("Records/Modules.csv", "Records/Programmes.csv", "Records/Students.csv",
                    "Records/Transcripts.csv", "Records/RepeatStudents.csv");
        } catch (IOException e) {
            System.out.println(
                    "Failed to load files. Check if the files exist or check that the file follows the conventions");
            running = false;
        }
    }

    /**
     * Runs the Student Record System simulation menu.
     */
    public void run() throws IOException {
        while (this.running) {

            System.out.println("\nChoose an option:");
            System.out.println("1) Submit Module Grades \n2) Hold Exam Review \n3) Quit");

            String command = in.nextLine();

            if (command.equals("1")) {
                System.out.println("Input Filename e.g Grades/1-CS4012.csv");
                command = in.nextLine();
                recordSystem.setGrades(command);

            } else if (command.equals("2")) {
                System.out.println("\nEnd of grading period. Now calculating transcripts...\n");

                this.transcripts = recordSystem.holdReview();
                recordSystem.exportTranscripts("Records/Transcripts.csv");
                recordSystem.exportRepeatStudents("Records/RepeatStudents.csv");

                System.out.println("Choose an option:");
                System.out.println(
                        "1) Search Transcripts\n2) Current Semester Transcripts\n3) Check Repeat Students\n4) Back");

                command = in.nextLine();

                boolean secondMenu = true;
                boolean thirdMenu = false;

                while (secondMenu) {
                    if (command.equals("1")) {

                        thirdMenu = true;
                        while (thirdMenu) {
                            System.out.println("\nChoose an option:");
                            System.out.println("1) By Student\n2) By Programme\n3) Back");
                            command = in.nextLine();

                            if (command.equals("1")) {
                                System.out.println("Student ID e.g. 2118737");
                                command = in.nextLine();

                                for (Transcript transcript : transcripts) {
                                    if ((transcript.getStudent()).getStudentID().equals(command)) {

                                        transcript.format();
                                    }
                                }
                                thirdMenu = true;
                            } else if (command.equals("2")) {
                                System.out.println("Programme Code e.g LM121");
                                command = in.nextLine();

                                for (Transcript transcript : transcripts) {
                                    if (transcript.getStudent().getProgramme().getProgrammeCode()
                                            .equalsIgnoreCase(command)) {
                                        transcript.format();
                                    }
                                }
                                thirdMenu = true;
                            } else if (command.equals("3")) {
                                thirdMenu = false;
                                System.out.println("\nChoose an option:");
                                System.out.println(
                                        "1) Search Transcripts\n2) Current Semester Transcripts\n3) Check Repeat Students\n4) Back");
                                command = in.nextLine();
                            }
                        }
                    } else if (command.equals("2")) {
                        for (Transcript transcript : transcripts) {
                            transcript.format();
                        }
                        secondMenu = true;
                        System.out.println("\nChoose an option:");
                        System.out.println(
                                "1) Search Transcripts\n2) Current Semester Transcripts\n3) Check Repeat Students\n4) Back");
                        command = in.nextLine();

                    } else if (command.equals("3")) {
                        ArrayList<String> repeatStudents = recordSystem.getRepeatStudentStatus();
                        System.out.println("\nRepeat Details:");
                        for (String repeatStatus : repeatStudents) {
                            System.out.println(repeatStatus);
                        }
                        secondMenu = true;
                        System.out.println("\nChoose an option:");
                        System.out.println(
                                "1) Search Transcripts\n2) Current Semester Transcripts\n3) Check Repeat Students\n4) Back");
                        command = in.nextLine();

                    } else if (command.equals("4")) {
                        secondMenu = false;

                        for (Student student : recordSystem.getStudents()) {
                            student.clearSemesterGrades();
                            student.clearTranscript();
                        }
                        recordSystem.clearRepeatStudents();

                        recordSystem.setRecords("Records/Modules.csv", "Records/Programmes.csv", "Records/Students.csv",
                                "Records/Transcripts.csv", "Records/RepeatStudents.csv");

                    } else {
                        System.out.println("Invalid input");
                        command = in.nextLine();
                    }
                }
            } else if (command.equals("3")) {
                System.out.println("Quiting");
                this.running = false;

            } else if (command.equals("sem1")) {
                recordSystem.setGrades("Grades/1-CS4012.csv");
                recordSystem.setGrades("Grades/1-CS4141.csv");
                recordSystem.setGrades("Grades/1-CS4221.csv");
                recordSystem.setGrades("Grades/1-ET4011.csv");
                recordSystem.setGrades("Grades/1-MA4111.csv");

            } else if (command.equals("sem2")) {
                recordSystem.setGrades("Grades/2-CS4043.csv");
                recordSystem.setGrades("Grades/2-CS4182.csv");
                recordSystem.setGrades("Grades/2-CS4222.csv");
                recordSystem.setGrades("Grades/2-ET4162.csv");
                recordSystem.setGrades("Grades/2-MA4402.csv");

            } else if (command.equals("sem3")) {
                recordSystem.setGrades("Grades/3-CS4004.csv");
                recordSystem.setGrades("Grades/3-CS4013.csv");
                recordSystem.setGrades("Grades/3-CS4023.csv");
                recordSystem.setGrades("Grades/3-CS4178.csv");
                recordSystem.setGrades("Grades/3-CS4416.csv");

            } else if (command.equals("sem4")) {
                recordSystem.setGrades("Grades/4-CS4006.csv");
                recordSystem.setGrades("Grades/4-CS4076.csv");
                recordSystem.setGrades("Grades/4-CS4115.csv");
                recordSystem.setGrades("Grades/4-CS4815.csv");
                recordSystem.setGrades("Grades/4-MA4413.csv");

            } else if (command.equals("sem6")) {
                recordSystem.setGrades("Grades/6-CS4084.csv");
                recordSystem.setGrades("Grades/6-CS4106.csv");
                recordSystem.setGrades("Grades/6-CS4116.csv");
                recordSystem.setGrades("Grades/6-CS4187.csv");
                recordSystem.setGrades("Grades/6-CS4457.csv");

            } else if (command.equals("sem7")) {
                recordSystem.setGrades("Grades/7-CS4011.csv");
                recordSystem.setGrades("Grades/7-CS4125.csv");
                recordSystem.setGrades("Grades/7-CS4287.csv");
                recordSystem.setGrades("Grades/7-CS4337.csv");
                recordSystem.setGrades("Grades/7-CS4617.csv");

            } else if (command.equals("sem8")) {
                recordSystem.setGrades("Grades/8-CS4158.csv");
                recordSystem.setGrades("Grades/8-CS4168.csv");
                recordSystem.setGrades("Grades/8-CS4227.csv");
                recordSystem.setGrades("Grades/8-CS4618.csv");
                recordSystem.setGrades("Grades/8-CS5705.csv");

            } else {
                System.out.println("Invalid Input");
                command = in.nextLine();
            }
        }
    }
}