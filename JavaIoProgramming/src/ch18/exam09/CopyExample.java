package ch18.exam09;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class CopyExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        Reader reader = new FileReader("src/ch18/exam09/test.txt");
        Writer writer = new FileWriter("src/ch18/exam09/test2.txt");
        
        char[] c1 = new char[3];
        int readData = -1;
        while(true) {
            readData = reader.read(c1);
            if(readData == -1) break;
            writer.write(c1, 0, readData);
        }
        
        writer.flush();
        writer.close();
        reader.close();
    }
}
