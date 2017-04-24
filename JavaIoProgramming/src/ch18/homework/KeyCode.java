package ch18.homework;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class KeyCode {
    public static void main(String[] args) throws IOException {
        InputStream is = System.in;
        
        byte[] keyCodes = new byte[10];
        int readBytes = -1;
        
        while(true) {
            readBytes =  is.read(keyCodes);
            System.out.println(Arrays.toString(keyCodes));
            System.out.println(readBytes);
            System.out.println( new String(keyCodes, 0, readBytes));
        }
    }
}
