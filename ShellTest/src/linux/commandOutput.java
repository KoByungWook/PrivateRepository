package linux;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.logging.Level;
import java.util.logging.Logger;

public class commandOutput {

	public static void main(String[] args) {
		try {
			Process p = Runtime.getRuntime().exec("./pocketsphinx.sh");
			
			p.waitFor();
			BufferedReader buf = new BufferedReader(new InputStreamReader(
					p.getInputStream()));
			String line = "";
			String output = "";
			
			while ((line = buf.readLine()) != null) {
				output += line + "\n";
			}
			
			System.out.println(output);
		} catch (Exception ex) {
			Logger.getLogger(commandOutput.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
