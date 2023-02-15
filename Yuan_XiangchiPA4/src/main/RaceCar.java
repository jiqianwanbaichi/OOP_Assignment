package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate the race car. Each RaceCar has a preset speed and strength. 
 * The RaceCar is allowed to have a speed between 55-30 
 * and a strength level between 2-4. A generic RaceCar (if you pass in no parameters to the constructor) 
 * gets a default speed of 40 and a strength of 3
 *
 */
public class RaceCar extends Car {

	public RaceCar(int speed, int strength) {
        super(speed, strength);
        if (speed > 55)
            this.speed = 55;
        else if (speed < 30)
            this.speed = 30;
        if (strength > 4)
            this.strength = 4;
        else if (strength < 2)
            this.strength = 2;
        type = "RaceCar";
	}
	
	public RaceCar() {
		super(40, 3);
		type = "RaceCar";
	}
}
