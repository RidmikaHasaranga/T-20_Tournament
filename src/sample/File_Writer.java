package sample;
import java.io.FileWriter;
import java.io.IOException;

public class File_Writer {
    public File_Writer(String fName, String fContent) {
        try {
            FileWriter fw = new FileWriter(fName, true);
            fw.write(fContent);
            fw.close();
            System.out.println("Content: " + fContent + " append to the " + fName);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
