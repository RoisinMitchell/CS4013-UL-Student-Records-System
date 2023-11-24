import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class CsvReader {

    private FileReader file;

    public CsvReader(String fileName) throws FileNotFoundException {
        this.file = new FileReader(fileName);
    }

    public ArrayList<String> toArrayList() throws IOException {
        // Try read the file in
        try (BufferedReader buffer = new BufferedReader(file)) {
            String line;
            ArrayList<String> lines = new ArrayList<String>();

            // Iterating over each line in the file until there is no lines left
            while ((line = buffer.readLine()) != null) {
                // Adding the line to an array list
                lines.add(line);
            }
            return lines;
        }
    }
}