public class Car {
    int speed;
    int strength;
    double location;
    String type = "Car";
    boolean damage;
    boolean finish = false;
    boolean inPitStop = false;
    int stopCount; 
    public Car(int speed, int strength){
        this.speed = speed;
        this.strength = strength;
        this.damage = false;
        this.stopCount = 2;
        location = 0;
    }
    public double getLocation(){
        return location;
    }
    public String toString(){
        return "("+ type + ", "+ speed +", "+ strength +")";
    }
}
