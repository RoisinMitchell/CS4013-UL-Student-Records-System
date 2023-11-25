import java.io.*;

public class CsvWriter {
    private String fileName;

    public CsvWriter(String fileName){
        this.fileName = fileName;
    }

    public void writeToCsv(Object object){
        try {

            FileWriter out = new FileWriter(fileName);

            out.write(object.toString());

            out.close();
        }
        catch(IOException e){
            throw new RecordSystemException("File output issue!");
        }
    }
}
