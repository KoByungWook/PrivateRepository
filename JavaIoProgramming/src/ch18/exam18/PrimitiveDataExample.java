package ch18.exam18;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class PrimitiveDataExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        int value = 10;
        double value2 = 2.5;
        boolean value3 = false;
        String value4 = "자바";
        
        OutputStream os = new FileOutputStream("src/ch18/exam18/test.dat");     //int값 저장 할 때 binary data. txt는 보통 문자만 저장하는 형식
        DataOutputStream dos = new DataOutputStream(os);
        InputStream is = new FileInputStream("src/ch18/exam18/test.dat");
        DataInputStream dis = new DataInputStream(is);
        
        dos.writeInt(value);
        dos.writeDouble(value2);
        dos.writeBoolean(value3);
        dos.writeUTF(value4);
        
        int readValue = dis.readInt();
        double readValue2 = dis.readDouble();
        boolean readValue3 = dis.readBoolean();                                 //읽은 순서대로 출력할 것!
        String readValue4 = dis.readUTF();
        System.out.println(readValue + " " + readValue2 + " " + readValue3 + " " + readValue4);
        
        dos.flush();
        os.flush();
        dos.close();
        os.close();
        
        dis.close();
        is.close();
        
    }
}
