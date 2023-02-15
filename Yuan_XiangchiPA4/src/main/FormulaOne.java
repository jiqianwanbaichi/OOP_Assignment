package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate the formula one car.  Each FormulaOne has a preset speed and strength. The FormulaOne is allowed to have a speed
 * between 70-30 and a strength level between 3-5. A generic FormulaOne (if you pass in no parameters
 * to the constructor) get a default speed of 50 and a strength of 4. 
 *
 */
public class FormulaOne extends Car {

	public FormulaOne(int speed, int strength) {
        super(speed, strength);
        if (speed > 70)
            this.speed = 70;
        else if (speed < 30)
            this.speed = 30;
        if (strength > 5)
            this.strength = 5;
        else if (strength < 3)
            this.strength = 3;
        type = "FormulaOne";
	}
	
	public FormulaOne() {
		super(50, 4);
		type = "FormulaOne";
	}
	
}
