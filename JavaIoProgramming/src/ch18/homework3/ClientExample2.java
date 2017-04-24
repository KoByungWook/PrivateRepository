package ch18.homework3;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Arrays;

public class ClientExample2 {
    public static void main(String[] args) throws IOException {
        Socket socket = new Socket("localhost", 50003);
        OutputStream os = socket.getOutputStream();
        
        String filePath = "D:\\IotCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\homework3\\Chrysanthemum.jpg";
        File file = new File(filePath);
        
        String fileName = file.getName();
        byte[] fileNameBytes = fileName.getBytes("UTF-8");
        fileNameBytes = Arrays.copyOf(fileNameBytes, 100);
        os.write(fileNameBytes);
        
        System.out.println("[파일 보내기 시작]" + fileName);
        FileInputStream fis = new FileInputStream(file);
        byte[] bytes = new byte[100];
        int readBytes = -1;
        
        while(true) {
            readBytes = fis.read(bytes);
            if(readBytes == -1) break;
            os.write(bytes, 0, readBytes);
        }
        
        fis.close();
        os.close();
        socket.close();
    }
}
