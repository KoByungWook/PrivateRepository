package ch18.exam25.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class ServerExample1 {
    public static void main(String[] args) {
        ServerSocket serverSocket = null;
        try {
            //ServerSocket 생성
            serverSocket = new ServerSocket();                  //네트워크 카드 오류 시 예외
            //포트와 바인딩
            serverSocket.bind(new InetSocketAddress(50001));        //이미 50001번을 누가 사용하고 있을 때 예외
            //연결 기다리기
            Socket socket = serverSocket.accept();  //클라이언트의 연결이 오기 전까지 계속 대기상태, accpet()는 socket을 리턴
            //클라이언트의 정보 얻기
            InetSocketAddress isa = (InetSocketAddress)socket.getRemoteSocketAddress();
            System.out.println(isa.toString());
            System.out.println(isa.getHostName());      //같은 지역네트워크 아니라면 아이피주소 출력
            //통신하기
            
            //연결 끊기
            socket.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        //ServerSocket 닫기//ServerSocket이 50001번을 사용하고 있느냐
        if(serverSocket != null && !serverSocket.isClosed()){
            //50001번을 해제하겠다
            try { serverSocket.close(); } catch (IOException ex1) {}
        }
    }
}
