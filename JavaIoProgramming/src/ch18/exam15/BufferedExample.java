package ch18.exam15;

import java.io.BufferedOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class BufferedExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        OutputStream os = new FileOutputStream("src/ch18/exam15/test.txt");
        BufferedOutputStream bos = new BufferedOutputStream(os);
        
        byte[] data = "가나다".getBytes();
        
        //os 사용
        long startTime = System.nanoTime();
        for(int i=0; i<1000; i++) {
            os.write(data);
        }
        os.flush();
        long endTime = System.nanoTime();
        
        System.out.println("os 걸린 시간: " + (endTime-startTime));
        
        //bos 사용
        long startTime2 = System.nanoTime();
        for(int i=0; i<1000; i++) {
            bos.write(data);
        }
        bos.flush();
        long endTime2 = System.nanoTime();
        
        System.out.println("bos 걸린 시간: " + (endTime2-startTime2));
        
        os.close();
    }
}
