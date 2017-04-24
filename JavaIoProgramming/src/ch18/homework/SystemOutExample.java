package ch18.homework;

import java.io.IOException;
import java.io.OutputStream;

public class SystemOutExample {
    public static void main(String[] args) throws IOException {
        OutputStream os = System.out;           //System.out -> return 타입 printStream
        
        for(byte b=48; b<58; b++) {
            os.write(b);
        }
        os.write(10);                       //라인 피드
        
        for(byte b=97; b<123; b++) {
            os.write(b);
        }
        os.write(10);
        
        String hangul = "가나다라마바사아자차카타파하";
        byte[] hangulBytes = hangul.getBytes();             //hangul스트링을 받아 바이트 배열로 변환
        os.write(hangulBytes);  
        
        os.flush();
        
    }
}
