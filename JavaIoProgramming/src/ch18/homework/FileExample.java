package ch18.homework;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FileExample {
    public static void main(String[] args) throws URISyntaxException, IOException {
        File dir = new File("C:/Temp/Dir");
        File file1 = new File("C:/Temp/file1.txt");
        File file2 = new File("C:/Temp/file2.txt");
        File file3 = new File(new URI("file:///C:/Temp/file3.txt"));        //File의 경로를 탐색
        
        if(dir.exists() == false) { dir.mkdirs(); }
        if(file1.exists() == false) { file1.createNewFile(); }
        if(file2.exists() == false) { file2.createNewFile(); }
        if(file3.exists() == false) { file3.createNewFile(); }      //해당 경로에 파일이 없을 시, dir은 디렉토리, file1~3은 새로운 파일을 생성
        
        File temp = new File("C:/Temp");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd   a   HH:mm");      //SimpleDataFormat에서 지정해 준 형태로 시간 정보를 표시
        File[] contents = temp.listFiles();                                         //contents 참조변수에 파일의 크기,내용 등 정보를 리턴
        System.out.println("날짜          시간    형태      크기    이름");
        System.out.println("-------------------------------------------");
        for(File file : contents) {
            System.out.print(sdf.format(new Date(file.lastModified())));            //마지막 수정 날짜 및 시간 리턴
            if(file.isDirectory()) {
                System.out.print("\t<DIR>\t\t\t" + file.getName());
            } else {
                System.out.print("\t\t\t" + file.length() + "\t" + file.getName());
            }
            System.out.println();
        }
    }
}
