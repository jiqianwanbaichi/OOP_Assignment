package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * this class simulate the car. The Car class is an abstract class representing a general race contestant. 
 *
 */
public class Car {
    int speed;
    int strength;
    int carNo;
    double location = 0;
    String type = "Car";
    boolean damage = false;
    boolean finish = false;
    int stopCounter = 2;

	public Car(int speed, int strength) {
        this.speed = speed;
        this.strength = strength;
	}
	
	public Car() {
		speed = 40;
		strength = 2;
	}

	public double getLocation() {
		return location;
	}
	
	public String toString() {
		return type + speed + "/" + strength;
	}
	
}
