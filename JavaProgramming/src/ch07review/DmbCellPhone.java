package ch07review;

public class DmbCellPhone extends CellPhone {
	int channel;
	
	DmbCellPhone(String model, String color, int channel) {
		this.model = model;
		this.color = color;
		this.channel = channel;
	}
	
	void turnOnDml() {
		System.out.println("ä�� " + channel + "�� ��� ������ �����մϴ�");
	}
	void changeChannelDmb(int channel) {
		System.out.println("ä�� " + channel + "������ �ٲߴϴ�");
	}
	void turnOffDmb() {
		System.out.println("DMB ��� ������ ����ϴ�");
	}
}
