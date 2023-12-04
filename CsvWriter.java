import java.io.*;
import java.util.ArrayList;

/**
 * The CsvWriter class is responsible for writing data to CSV files.
 */
public class CsvWriter {
    private String fileName;

    /**
     * Constructs a CsvWriter with the specified file name.
     */
    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes a list of transcripts to the CSV file.
     */
    public void writeTranscriptsToFile(ArrayList<Transcript> transcripts){
        try {
            FileWriter out = new FileWriter(this.fileName);

            for (Transcript transcript : transcripts) {
                out.write(transcript.toString() + "\n");
            }
            out.close();
        } catch (IOException e) {
            throw new RecordSystemException("File output issue!");
        }
    }

    /**
     * Writes a list of repeat students to the CSV file.
     */
    public void writeRepeatStudentsToFile(ArrayList<String> repeatStudents){
        try {
            FileWriter out = new FileWriter(this.fileName);

            for (String repeatStudent : repeatStudents) {
                out.write(repeatStudent + "\n");
            }
            out.close();
        } catch (IOException e) {
            throw new RecordSystemException("File output issue!");
        }
    }
}
