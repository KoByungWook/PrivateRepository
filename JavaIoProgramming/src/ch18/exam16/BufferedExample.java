package ch18.exam16;

import java.io.BufferedOutputStream;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;

public class BufferedExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam16/test.txt");
        OutputStreamWriter osw = new OutputStreamWriter(os);
        
        BufferedWriter bw = new BufferedWriter(osw);
        
        //os 사용
        long startTime = System.nanoTime();
        for(int i=0; i<10000; i++) {
            bw.write("가나다");
        }
        bw.flush();
        long endTime = System.nanoTime();
        
        System.out.println("bw 걸린 시간: " + (endTime-startTime));
        
        osw.flush();
        os.flush();
        
        bw.close();
        osw.close();
        os.close();

    }
}
