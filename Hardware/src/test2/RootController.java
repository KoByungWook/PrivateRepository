package test2;

import com.pi4j.io.gpio.RaspiPin;
import hardware.led.RgbLedPWM;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Slider;

public class RootController implements Initializable {

	@FXML
	private Slider sliderR;
	@FXML
	private Slider sliderG;
	@FXML
	private Slider sliderB;

	@Override
	public void initialize(URL url, ResourceBundle rb) {
		RgbLedPWM rgb = new RgbLedPWM(RaspiPin.GPIO_00, RaspiPin.GPIO_02, RaspiPin.GPIO_03);
		
		sliderR.valueProperty().addListener(new ChangeListener<Number> () {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int r = (int)(newValue.doubleValue() * 2.550);
				System.out.println(r);
				int[] rgbArr = rgb.getCurrColorSet();
				rgb.ledColorSet(r, rgbArr[1], rgbArr[2]);
			}
		});
		
		sliderG.valueProperty().addListener(new ChangeListener<Number> () {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int g = (int)(newValue.doubleValue() * 2.550);
				System.out.println(g);
				int[] rgbArr = rgb.getCurrColorSet();
				rgb.ledColorSet(rgbArr[0], g, rgbArr[2]);
			}
		});
		
		sliderB.valueProperty().addListener(new ChangeListener<Number> () {
			@Override
			public void changed(ObservableValue<? extends Number> observable, Number oldValue, Number newValue) {
				int b = (int)(newValue.doubleValue() * 2.550);
				System.out.println(b);
				int[] rgbArr = rgb.getCurrColorSet();
				rgb.ledColorSet(rgbArr[0], rgbArr[1], b);
			}
		});
	}	
	
}
