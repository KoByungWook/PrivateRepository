package ch18.exam27.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ServerExample {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        ExecutorService executorService = Executors.newFixedThreadPool(100);    //100개의 스레드를 가지는 스레드풀 생성
        try {
            //ServerSocket 생성
            serverSocket = new ServerSocket();                  //네트워크 카드 오류 시 예외
            //포트와 바인딩
            serverSocket.bind(new InetSocketAddress("192.168.3.21", 50001));
            
            System.out.println("클라이언트 연결 대기중");//이미 50001번을 누가 사용하고 있을 때 예외
            //연결 기다리기
            while(true) {
                Socket socket = serverSocket.accept();  //클라이언트의 연결이 오기 전까지 계속 대기상태, accpet()는 socket을 리턴
                Runnable task = () -> {
                    try { 
                        //통신하기
                        InputStream is = socket.getInputStream();       //클라이언트가 데이터를 보내면 인풋 스트림을 통해 들어온다
                        byte[] data = new byte[100];
                        int readBytes = is.read(data);
                        if(readBytes == -1) {
                            throw new IOException("클라이언트가 정상 종료됨");
                        }
                        String strData = new String(data, 0, readBytes, "UTF-8"); //디코딩은 여기서
                        System.out.println("받은 데이터: " + strData);

                        OutputStream os = socket.getOutputStream();     //클라이언트에게 아웃풋스트림을 통해 보낸다        
                        data = strData.getBytes();
                        os.write(data);
                        os.flush();
                        System.out.println("데이터 다시 보내기 성공");
                        //연결 끊기
                        socket.close();
                    } catch (Exception e) {}
                };
                executorService.submit(task);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }    
        //ServerSocket 닫기//ServerSocket이 50001번을 사용하고 있느냐
        if(serverSocket != null && !serverSocket.isClosed()){
            //50001번을 해제하겠다
            try { serverSocket.close(); } catch (IOException ex1) {}
        }
    }
}      
    
 
