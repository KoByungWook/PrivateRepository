package ch18.homework;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String originalFileName = "C:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\homework\\manbo.png";
        String targetFileName = "C:/Temp/house.jpg";
        
        FileInputStream fis = new FileInputStream(originalFileName);
        FileOutputStream fos = new FileOutputStream(targetFileName);
        
        int readByteNo;
        byte[] readBytes = new byte[100];               //100바이트씩 끊어서 읽어오겠다.
        while( (readByteNo = fis.read(readBytes)) != -1) {
            fos.write(readBytes, 0, readByteNo);                //복사 & 붙여넣기
        }
        
        fos.flush();
        fos.close();
        fis.close();
        
        System.out.println("복사가 잘 되었습니다");
    }
}
