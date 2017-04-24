package ch18.homework2;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class BufferedInputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        long start = 0;
        long end = 0;
        
        FileInputStream fis1 = new FileInputStream("src/ch18/homework2/manbo.png");
        start = System.currentTimeMillis();
        while(fis1.read() != -1) {
        
        }
        end = System.currentTimeMillis();
        System.out.println("fis 걸린 시간: " + (end - start));
        fis1.close();
        
        FileInputStream fis2 = new FileInputStream("src/ch18/homework2/manbo.png");
        BufferedInputStream bis = new BufferedInputStream(fis2);
        start = System.currentTimeMillis();
        while(bis.read() != -1) {
        
        }
        end = System.currentTimeMillis();
        System.out.println("fis 걸린 시간: " + (end - start));
        
        bis.close();
        fis2.close();
    }
}
