package ch07.exam08;

public class CarExample {

	public static void main(String[] args) {
		Car car = new Car(new SnowTire());
		//Tire tire = new NormalTire();
		//Car car = new Car(tire);
		car.run();
		
		car.setTire(new NormalTire());
		car.run();
		
		car.setTire(new SpeedTire());
		car.run();
		
		car.setTire(new SuperTire());
		car.run();
	}

}
