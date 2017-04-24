package ch18.homework;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class FileWriterExample {
    public static void main(String[] args) throws IOException {
        File file = new File("C:/Temp/file.txt");       //file.txt를 객체로 생성
        FileWriter fw = new FileWriter(file, true);     //기존에 file이 존재할 시, 기존 파일 내용 끝에 데이터를 추가
        fw.write("FileWriter는 한글로 된 " + "\r\n");
        fw.write("문자열을 바로 출력할 수 있다." + "\r\n");
        fw.flush();
        fw.close();
        System.out.println("파일에 저장되었습니다.");
    }
}
