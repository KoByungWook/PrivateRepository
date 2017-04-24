package ch18.homework;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileReaderExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader("C:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\homework\\FileReaderExample.java");
        
        int readCharNo;
        char[] cbuf = new char[100];
        while( (readCharNo = fr.read(cbuf)) != -1 ) {
            String data = new String(cbuf, 0, readCharNo);
            System.out.print(data);
        }
        
        fr.close();
    }
}
