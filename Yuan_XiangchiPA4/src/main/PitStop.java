package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate a pit stop. it can let the damaged cars enter the pit stop and stop for 2 ticks
 * then let the repaired car recover the original speed and back to the race track from the pit stop.
 *
 */
public class PitStop {
	

	Car[] carsInStop;
	Car[] cars;
	public PitStop(Car[] cars) {
		this.cars = cars;
		carsInStop = new Car[cars.length];
	}
	/**
	 * let the damaged cars enter the pit stop and stop for 2 ticks
	 * @param car
	 */
	public void enterPitStop(Car car) { 
		System.out.println(car + " has entered the pit stop.");
		car.location = car.location - car.location % 100 + 75;
		carsInStop[car.carNo] = car;
		cars[car.carNo] = null;
	}
	/**
	 * pit stop let the repaired car recover the original speed and back to the race track 
	 * from the pit stop.
	 * @param car
	 */
	public void exitPitStop(Car car) {
		car.speed += car.strength * 5;
		car.damage = false;
		car.stopCounter = 2;
		System.out.println(car + " has exited the pit stop.");
		cars[car.carNo] = car;
		carsInStop[car.carNo] = null;
	}
}
