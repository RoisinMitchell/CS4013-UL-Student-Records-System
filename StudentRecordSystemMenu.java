import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Set;

public class StudentRecordSystemMenu {
    private final Scanner in;
    private final StudentRecordSystem recordSystem;
    private ArrayList<Transcript> thisYearsTranscripts;
    private boolean running;

    public StudentRecordSystemMenu() {
        in = new Scanner(System.in);
        running = true;
        recordSystem = new StudentRecordSystem();

        // Setting existing records for the system to run on
        try {
            recordSystem.setRecords("Records/Modules.csv", "Records/Programmes.csv", "Records/Students1.csv",
                    "Records/Transcripts.csv");
        } catch (IOException e) {
            System.out.println(
                    "Failed to load files. Check if the files exist or check that the file follows the conventions");
            running = false;
        }
    }

    public void run() throws IOException {
        while (this.running) {
            System.out.println("\nChoose an option:");
            System.out.println("1) Submit module grades \n2) submit thesis\n3) submit dissertions\n4) Hold review \n5) Quit"); //submit thesis / dissertions

            String command = in.nextLine();

            if (command.equals("1")) {
                System.out.println("Input Filename e.g. ModuleGrade.csv");
                command = in.nextLine();
                recordSystem.setGrades(command);

            } else if(command.equals("2")){


                System.out.println("Input FileName");

            } else if(command.equals("3")){
              
                System.out.println("Input Filename");


            } else if (command.equals("4")) {
                System.out.println("\nEnd of grading period. Now calculating transcripts...\n");
                System.out.println("Choose an option:");
                System.out.println("1) search transcripts\n2) Current Semster transcripts\n3) Back \n4) Quit");
                //
                command = in.nextLine();
                this.thisYearsTranscripts = recordSystem.holdReview();
                boolean secondMenu = true;
                boolean thirdMenu = false;
                while (secondMenu) {
                    System.out.println("1) search transcripts\n2) Current Semster transcripts\n3) Back \n4) Quit");
                    if (command.equals("1")) {
                       
                        thirdMenu = true;
                        while(thirdMenu){
                            
                            System.out.println("1) By StudentID\n 2) By Module\n 3) By Program\n");
                            command = in.nextLine();

                            if(command.equals("1")){
                                System.out.println("Student ID e.g. 2118737");
                                command = in.nextLine();

                                for (Transcript transcript : thisYearsTranscripts) {
                                    if ((transcript.getStudent()).getStudentID().equals(command)) {
                                        
                                        transcript.format();
                                    }
                                }
                                thirdMenu = false;
                            } 
                            else if(command.equals("2")){
                                System.out.println("Module Code e.g CS4012");

                                command = in.nextLine();
                                    for(Transcript transcript : thisYearsTranscripts){
                                        Set<Module> keys = transcript.getGrades().keySet();
                                            for(Module module : keys){
                                                if(module.getModuleCode().equals(command)){
                                                    transcript.format();
                                                }
                                            }
                                    }
                                thirdMenu = false;

                            }
                            else if(command.equals("3")){
                                System.out.println("Programme Code e.g Lm121");
                                command = in.nextLine();

                                for(Transcript transcript : thisYearsTranscripts){
                                       if (transcript.getStudent().getProgramme().getProgrammeCode().equals(command)){
                                            transcript.format();
                                       }
                                    }
                                thirdMenu = false;
                        
                        
                            }
                        }
                    } else if (command.equals("2")) {
                        System.out.println(
                                "Student ID, Semester, Academic Year, Semester QCA, Cumulative QCA, Module, Grade, Module, Grade,...");
                        for (Transcript transcript : thisYearsTranscripts) {
                            System.out.println(transcript.toString() + "");
                        }
                        // Closing the menu down
                        secondMenu = false;

                    } else if (command.equals("3")) {
                        secondMenu = false;
                        System.out.println("Add Grades");

                    } else if (command.equals("4")) {
                        this.running = false;
                        secondMenu = false;
                        System.out.println("Quiting");

                    } else {
                        System.out.println("Invalid input");
                        command = in.nextLine();

                    }
                }
            } else if (command.equals("test1")) {
                recordSystem.setGrades("Grades/1-CS4012.csv");
                recordSystem.setGrades("Grades/1-CS4141.csv");
                recordSystem.setGrades("Grades/1-CS4221.csv");
                recordSystem.setGrades("Grades/1-ET4011.csv");
                recordSystem.setGrades("Grades/1-MA4111.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test2")) {
                recordSystem.setGrades("Grades/2-CS4043.csv");
                recordSystem.setGrades("Grades/2-CS4182.csv");
                recordSystem.setGrades("Grades/2-CS4222.csv");
                recordSystem.setGrades("Grades/2-ET4162.csv");
                recordSystem.setGrades("Grades/2-MA4402.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }

                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test3")) {
                recordSystem.setGrades("Grades/3-CS4004.csv");
                recordSystem.setGrades("Grades/3-CS4013.csv");
                recordSystem.setGrades("Grades/3-CS4023.csv");
                recordSystem.setGrades("Grades/3-CS4178.csv");
                recordSystem.setGrades("Grades/3-CS4416.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }

                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test4")) {
                recordSystem.setGrades("Grades/4-CS4006.csv");
                recordSystem.setGrades("Grades/4-CS4076.csv");
                recordSystem.setGrades("Grades/4-CS4115.csv");
                recordSystem.setGrades("Grades/4-CS4815.csv");
                recordSystem.setGrades("Grades/4-MA4413.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test5")) {
                recordSystem.setGrades("Grades/5-COOP.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test6")) {
                recordSystem.setGrades("Grades/6-CS4084.csv");
                recordSystem.setGrades("Grades/6-CS4106.csv");
                recordSystem.setGrades("Grades/6-CS4116.csv");
                recordSystem.setGrades("Grades/6-CS4187.csv");
                recordSystem.setGrades("Grades/6-CS4457.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test7")) {
                recordSystem.setGrades("Grades/7-CS4011.csv");
                recordSystem.setGrades("Grades/7-CS4125.csv");
                recordSystem.setGrades("Grades/7-CS4287.csv");
                recordSystem.setGrades("Grades/7-CS4337.csv");
                recordSystem.setGrades("Grades/7-CS4617.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("test8")) {
                recordSystem.setGrades("Grades/8-CS4158.csv");
                recordSystem.setGrades("Grades/8-CS4168.csv");
                recordSystem.setGrades("Grades/8-CS4227.csv");
                recordSystem.setGrades("Grades/8-CS4618.csv");

                ArrayList<Transcript> test = recordSystem.holdReview();

                for (Transcript transcript : test) {
                    transcript.format();
                }
                recordSystem.exportTranscripts("Records/Transcripts.csv");

            } else if (command.equals("5")) {
                System.out.println("Quiting");
                this.running = false;

            }
            else {
                System.out.println("Invalid Input");
                command = in.nextLine();
            }
        }
    }
} 