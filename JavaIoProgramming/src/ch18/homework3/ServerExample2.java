package ch18.homework3;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample2 {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket();
        serverSocket.bind(new InetSocketAddress("localhost", 50003));
        
        System.out.println("[서버 시작]");
        
        while(true) {
            try {
                Socket socket = serverSocket.accept();
                
                InputStream is = socket.getInputStream();
                
                byte[] bytes = new byte[100];
                int readBytes = -1;
                        
                is.read(bytes, 0, 100);
                String fileName = new String(bytes, 0, 100, "UTF-8");
                fileName = fileName.trim();
                
                System.out.println("[파일 받기 시작]" + fileName);
                FileOutputStream fos = new FileOutputStream("C:/Temp/" + fileName);
                
                while(true) {
                    readBytes = is.read(bytes);
                    if(readBytes == -1) break;
                    fos.write(bytes, 0, readBytes);
                }
                
                fos.flush();
                System.out.println("[파일 받기 완료]");
                
                fos.close();
                is.close();
                socket.close();
            } catch(Exception e) {
                break;
            }
        }
        
        serverSocket.close();
        System.out.println("[서버 종료]");
    }
}
