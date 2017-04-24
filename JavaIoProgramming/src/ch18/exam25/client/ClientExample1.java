package ch18.exam25.client;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class ClientExample1 {
    public static void main(String[] args) {
        Socket socket = null;
        try {
//            socket = new Socket("192.168.3.21", 50001);       //재사용 불가.

            socket = new Socket();
            socket.connect(new InetSocketAddress("192.168.3.21", 50001));  //장점 : 언제든지 연결끊고 잇고 할 수 있음
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        
        if(!socket.isClosed()) {
            try { socket.close(); } catch (IOException ex) {}
        }
    }
}
