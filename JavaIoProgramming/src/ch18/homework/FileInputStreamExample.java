package ch18.homework;

import java.io.FileInputStream;

public class FileInputStreamExample {
    public static void main(String[] args) {
        try {
            FileInputStream fis = new FileInputStream("C:\\IoTCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\homework\\FileInputStreamExample.java");
            int data;
            while( (data = fis.read() ) != -1) {        //불러온 파일을 1바이트 단위로 읽어들임
                System.out.write(data);                 //읽어들인 파일을 다시 출력(1바이트씩)
            }
            fis.close();
        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
