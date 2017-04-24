package ch18.homework2;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class BufferedOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        FileInputStream fis = null;
        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null;
        
        int data = -1;
        long start = 0;
        long end = 0;
        
        fis = new FileInputStream("src/ch18/homework2/manbo.png");
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream("src/ch18/homework2/manbo2.png");
        start = System.nanoTime();
        while( (data = bis.read()) != -1) {
            fos.write(data);
        }
        end = System.nanoTime();
        fos.flush();
        fos.close();
        bis.close();
        fis.close();
        System.out.println("사용하지 않았을 떄: " + (end-start));
        
        fis = new FileInputStream("src/ch18/homework2/manbo.png");
        bis = new BufferedInputStream(fis);
        fos = new FileOutputStream("src/ch18/homework2/manbo2_2.png");
        bos = new BufferedOutputStream(fos);
        start = System.nanoTime();
        while( (data = bis.read()) != -1) {
            bos.write(data);
        }
        end = System.nanoTime();
        bos.flush();
        bos.close();
        fos.close();
        bis.close();
        fis.close();
        System.out.println("사용했을 떄: " + (end-start));
    }
}
