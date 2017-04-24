package ch18.exam23;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class VVIP extends Person implements Serializable {
    private int memberShipNo;
    private String grade;
    
    public VVIP() {}
    
    public VVIP(int memberShipNo, String grade, String name, int age) {
        super(name, age);
        this.memberShipNo = memberShipNo;
        this.grade = grade;
    }

    public int getMemberShipNo() {
        return memberShipNo;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
    
    public void setMemberShipNo(int memberShipNo) {
        this.memberShipNo = memberShipNo;
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {           //writeObject 실행되면 호출
        out.writeUTF(getName());            //이름을 써줌
        out.writeInt(getAge());
        out.defaultWriteObject();           //자신의 필드를 직렬화
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        setName(in.readUTF());              //이름을 읽으옴
        setAge(in.readInt());
        in.defaultReadObject();             //자신의 필드를 역직렬화
    }
}
