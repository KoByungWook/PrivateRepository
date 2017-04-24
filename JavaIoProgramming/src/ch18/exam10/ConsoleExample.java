package ch18.exam10;

import java.io.Console;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Scanner;

public class ConsoleExample {
    public static void main(String[] args) throws IOException {
        //int keyCode = System.in.read();
        
        InputStream is = System.in;
        //int keyCode = is.read();
        byte[] keyCodes = new byte[10];
        int readBytes = -1;
        String str = "";
        readBytes = is.read(keyCodes);
        //how1
        while(true) {
            
         
            if(readBytes == -1) break;
            System.out.println(Arrays.toString(keyCodes));
            
            
            if(readBytes == 10)
                str += new String(keyCodes, 0, readBytes);
            else
                str += new String(keyCodes, 0, readBytes-2);
            
            System.out.println(str);
        }
        
        
//        //how2
//        Scanner scanner = new Scanner(System.in);
//        String str2 = scanner.nextLine();
//        System.out.println(str2);
//        
//        //how3
//        Console console = System.console();
//        String str3 = console.readLine();
//        System.out.println(str3);
    }
}
