package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate the sports car. Each SportsCar has a preset speed and strength. The SportsCar 
 * is allowed to have a speed between 45-20 and a strength level between 1-3. A generic SportsCar 
 * (if you pass in no parameters to the constructor) gets a default speed of 30 and a strength of 2.
 *
 */
public class SportsCar extends Car{
	
	public SportsCar(int speed, int strength) {
		super(speed, strength);
        if (speed > 45)
            this.speed = 45;
        else if (speed < 20)
            this.speed = 20;
        if (strength > 3)
            this.strength = 3;
        else if (strength < 1)
            this.strength = 1;
        type = "SportsCar";
	}

	public SportsCar() {
		super(30, 2);
		type = "SportsCar";
	}
	
}
