package ch08.review;

public class DriverExample {

	public static void main(String[] args) {
		Driver driver = new Driver();
		
		Bus bus = new Bus();
		Taxi taxi = new Taxi();
		
		driver.drive(bus);
		driver.drive(taxi);

		Vehicle vehicle = new Bus();
		
		vehicle.run();
		Bus bus1 = (Bus)vehicle;
		bus1.run();
		bus1.checkFare();
	}

}
