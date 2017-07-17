package shell;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Test {
    public static void main(String[] args) {
        //String[] command = {"/bin/sh","-c","실행시킬 쉘 스크립트"};
        
        try {
            Process ps = Runtime.getRuntime().exec("/home/pi/./stt.sh");
            ps.waitFor();
            //System.out.println(ps.exitValue());
            ps.destroy();
            
            FileReader fr = new FileReader("/home/pi/NetBeansProjects/ShellTest/stt.txt");
            BufferedReader br = new BufferedReader(fr);
            br.readLine();
            String data = br.readLine();
            System.out.println(data); 
            
            // "[" 기준으로 첫 번째 파싱
            String[] dataArr = data.split("\\[");
            data = dataArr[2];
            // "]" 기준으로 두 번째 파싱
            dataArr = data.split("]");
            data = dataArr[0];
            System.out.println(data);
            
            //마지막 transcript 앞 쪽 파싱
            dataArr = data.split("transcript\":\"");
            data = dataArr[dataArr.length - 1];
            //마지막 transcript 뒤 쪽 파싱
            dataArr = data.split("\"");
            data = dataArr[0];
            System.out.println(data);
            
            //공백 없애기
            data = data.replaceAll(" ","");
            System.out.println(data);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
