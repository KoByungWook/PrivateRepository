package ch18.exam21;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class ObjectInputExample {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream("src/ch18/exam21/object.dat");
        ObjectInputStream ois = new ObjectInputStream(fis);
        
        Member member = (Member)ois.readObject();
        
        System.out.println(member.getName());
        System.out.println(member.getAge());
        System.out.println(Member.nation);
        
        ois.close();
        fis.close();
    }
}
