package ch07review;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dcp = new DmbCellPhone("�ڹ���", "����", 10);
		
		System.out.println("�� : " + dcp.model);
		System.out.println("���� : " + dcp.color);
		
		System.out.println("ä�� : " + dcp.channel);
		
		dcp.powerOn();
		dcp.bell();
		dcp.sendVoice("��������");
		dcp.receiveVoice("�ȳ��ϼ���");
		dcp.sendVoice("�ȳ��ϰ輼��");
		dcp.hangUp();
		
		dcp.turnOnDml();
		dcp.changeChannelDmb(12);
		dcp.turnOffDmb();

	}

}
