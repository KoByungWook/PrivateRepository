package ch07.examreview;

public class DmbCellPhoneExample {

	public static void main(String[] args) {
		DmbCellPhone dmbCellPhone = new DmbCellPhone("�ڹ���", "����", 10);
		
		System.out.println("�� : " + dmbCellPhone.model);
		System.out.println("���� : " + dmbCellPhone.color);
		
		System.out.println("ä�� : " + dmbCellPhone.channel);
		
		dmbCellPhone.powerOn();
		dmbCellPhone.bell();
		dmbCellPhone.sendVoice("��������");
		dmbCellPhone.recieveVoice("�ȳ��ϼ���! ���� ȫ�ڹ� �Դϴ�");
		dmbCellPhone.sendVoice("�ݰ����ϴ�");
		dmbCellPhone.hangUp();
		
		dmbCellPhone.turnOnDmb();
		dmbCellPhone.changeChannelDmb(11);
		dmbCellPhone.turnOffDmb();
	}

}
