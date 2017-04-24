package ch18.homework3;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class AddLineNumberExample {
    public static void main(String[] args) throws FileNotFoundException, IOException {
        String Path = "D:\\IotCourse\\NetBeansWorkspace\\JavaIoProgramming\\src\\ch18\\homework3\\AddLineNumberExample.java";
        
        FileReader fr = new FileReader(Path);
        BufferedReader br = new BufferedReader(fr);
        
        int countNumber = 1;
        String data = null;
        
        while(true) {
            data = br.readLine();
            if(data == null) break;
            System.out.println(countNumber + " : " + data);
            countNumber++;
        }
        
        br.close();
        fr.close();
    }
}
