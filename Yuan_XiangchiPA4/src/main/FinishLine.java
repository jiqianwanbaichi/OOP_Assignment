package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate a finish line for race track. when car reach the finish line,
 * the car is then removed from race track.
 *
 */
public class FinishLine {
	Car[] finishCars;
	int place;
	public FinishLine(Car[] cars) {
		finishCars = new Car[cars.length];
		place = 0;
	}
	/**
	 *  when car reach the finish line, it will be removed from race track and move to finishCars[].
	 * @param car
	 */
	public void enterFinishLine(Car car) { 
		place ++;
		finishCars[place - 1] = car; 
		System.out.println(car + " has finished the race in place" + place + ".");
	}
	/**
	 * when all cars finish the race, the finish line will return boolean true
	 * @return boolean, represent all cars finished or not.
	 */
	public boolean finished() {
		if(finishCars[finishCars.length - 1] != null) return true;
		else return false;
	}
}

