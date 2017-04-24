package ch18.exam14;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class OuputStreamWriterExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam14/test.txt");
        
//        byte[] data = "가".getBytes();
//        os.write(data);

        OutputStreamWriter osw = new OutputStreamWriter(os);
        osw.write("가");
        
        osw.flush();
        osw.close();
    }
}
