import java.io.*;
import java.util.ArrayList;

public class CsvWriter {
    private String fileName;

    public CsvWriter(String fileName) {
        this.fileName = fileName;
    }

    public void transcriptsToFile(ArrayList<Transcript> transcripts) {
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
}
