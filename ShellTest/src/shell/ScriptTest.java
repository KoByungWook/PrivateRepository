package shell;

import java.io.BufferedReader;
import java.io.FileReader;

public class ScriptTest {
	public static void main(String[] args) {

		Thread recordThread = new Thread() {
			@Override
			public void run() {
				while (true) {
					try {
						Process ps = Runtime.getRuntime().exec("/home/pi/./record.sh");
						System.out.println("rec....");
						ps.waitFor();
						//System.out.println(ps.exitValue());
						ps.destroy();
						
						recogSpeech();
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}
		};

		recordThread.start();
	}

	private static void recogSpeech() {
		String[] dataArr;
		String data;
		
		try {
			Process ps = Runtime.getRuntime().exec("/home/pi/./recog.sh");
			ps.waitFor();
			//System.out.println(ps.exitValue());
			ps.destroy();

			FileReader fr = new FileReader("/home/pi/NetBeansProjects/ShellTest/stt.txt");
			BufferedReader br = new BufferedReader(fr);
			br.readLine();
			data = br.readLine();

			if(data == null) {
				System.out.println("no speech");
			} else {
				dataArr = data.split("transcript\":\"");
				data = dataArr[dataArr.length - 1];
				//마지막 transcript 뒤 쪽 파싱
				dataArr = data.split("\"");
				data = dataArr[0];
				System.out.println(data);

				data = data.replaceAll(" ", "");
				System.out.println(data);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
