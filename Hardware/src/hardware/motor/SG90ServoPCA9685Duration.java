package hardware.motor;

import com.pi4j.io.gpio.Pin;

public class SG90ServoPCA9685Duration {
    //Field
    private PCA9685 pca9685;
    private Pin pin;
    private int angle;
    private int minduration;
    private int maxduration;
    //Constructor
    public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin) {
        //1단계(단위 펄스 시간) = 20ms/4096 = 0.004884ms
        //0도(0.8ms = 800ms)
        //180(2.7ms = 2700ms)
        this(pca9685, pin, 800, 2700);
    }
    public SG90ServoPCA9685Duration(PCA9685 pca9685, Pin pin, int minduration, int maxduration) {
        this.pca9685 = pca9685;
        this.pin = pin;
        this.minduration = minduration;
        this.maxduration = maxduration;
    }
    //method
    public int getAngle() {
        return angle;
    }

    public void setAngle(int angle) {
        if(angle < 0) {
            angle = 0;
        } else if(angle > 180) {
            angle = 180;
        } 
        this.angle = angle;
        int duration = minduration + (int)(angle * (maxduration - minduration) / 180.0);
        this.pca9685.setDuration(pin, duration);
    }
    
    public static void main(String[] args) throws Exception {
        PCA9685 pca9685 = PCA9685.getInstance();
        SG90ServoPCA9685Duration servoUS = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_11);
        SG90ServoPCA9685Duration servoLR = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_14);
        SG90ServoPCA9685Duration servoUD = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_15);
        SG90ServoPCA9685Duration servoFW = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_00);
		SG90ServoPCA9685Duration servoTest = new SG90ServoPCA9685Duration(pca9685, PCA9685.PWM_03);
//
        
		while (true) {
//			for (int i = 10; i < 150; i += 10) {
//				servoUS.setAngle(i);
//				servoLR.setAngle(i);
//				servoUD.setAngle(i);
//				servoFW.setAngle(i);
//				Thread.sleep(500);
//			}
//
//			for (int i = 150; i > 0; i -= 10) {
//				servoUS.setAngle(i);
//				servoLR.setAngle(i);
//				servoUD.setAngle(i);
//				servoFW.setAngle(i);
//				Thread.sleep(500);
//			}
		servoUS.setAngle(30);
        servoLR.setAngle(30);
        servoUD.setAngle(30);
        servoFW.setAngle(30);

        Thread.sleep(2000);
		
		servoUS.setAngle(90);
        servoLR.setAngle(90);
		servoUD.setAngle(90);
		servoFW.setAngle(90);
		
		Thread.sleep(2000);
		}
        

    }

}
