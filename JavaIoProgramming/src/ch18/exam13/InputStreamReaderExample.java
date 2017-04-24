package ch18.exam13;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class InputStreamReaderExample {
    public static void main(String[] args) throws IOException {
//        InputStream is = System.in;
//        InputStreamReader isr = new InputStreamReader(is);
//        
////        int data = is.read();
////        System.out.println((char)data);       1바이트씩 읽으면 영어 이외에 읽을 수 없음
//
//        int data = isr.read();
//        System.out.println((char)data);

        InputStream is = new FileInputStream("src/ch18/exam13/test.txt");
        InputStreamReader isr = new InputStreamReader(is, "UTF-8");
        int data = isr.read();
        System.out.println((char)data);
    }
}
