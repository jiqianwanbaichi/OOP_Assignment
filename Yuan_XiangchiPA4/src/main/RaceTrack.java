package main;
/**
 * 
 * @author Xiangchi Yuan
 * Xiangchi Yuan
 * xiangchiyuan@brandeis.edu
 * Nov 4th, 2022
 * PA4
 * This class build a race track for cars. It can set cars to start, 
 * repeat ticks until finish and finally
 * return the score. 
 *
 */
public class RaceTrack {

	/**
	 * DO NOT REMOVE THIS - you should be using this to log this track's events. For more see the assignment PDF / documentation for TrackLoggerB.java
	 */
	private TrackLoggerC logger;
	/**
	 * the number of total cars
	 */
	int len;
	int ticks = 0;
	int score = 1000;
	Car[] cars;
	FinishLine  finishLine;
	PitStop pitStop;
	
	public RaceTrack() {
		logger = new TrackLoggerC(); // DO NOT REMOVE THIS LINE
	}
	/**
	 * this method set the paticipated cars into race track.
	 * @param cars
	 */
	public void setCars(Car[] cars) {
		this.cars = cars;
		len = cars.length;
		finishLine = new FinishLine(cars);
		pitStop = new PitStop(cars);
		for(int i = 0; i < cars.length; i ++) {
			cars[i].carNo = i; 
		}
	}
	/**
	 * this method runs a single tick. in this single tick, it check the car to move, check collision, enter
	 * finish line and enter pit stop.
	 */
	public void tick() {
        ticks ++;
        System.out.println("Tick " + ticks);
        for(int i = 0; i < len; i ++){
        	if(cars[i] != null) {
        		if(cars[i].stopCounter == 2 && cars[i].damage && cars[i].location % 100 < 75
        				&& (cars[i].location % 100 + cars[i].speed) >= 75 ) {
        			pitStop.enterPitStop(cars[i]);
        		}
        		else cars[i].location += cars[i].speed; 
            	if(cars[i] != null && cars[i].location > 1000) {
            		finishLine.enterFinishLine(cars[i]);
            		cars[i] = null;
            	}
        	}  	
        }
        checkCollision();
        for(int i = 0; i < len; i ++) {
        	if(pitStop.carsInStop[i] != null) {
        		pitStop.carsInStop[i].stopCounter --;
        	}
        	if(pitStop.carsInStop[i] != null && pitStop.carsInStop[i].stopCounter == 0) {
        		pitStop.exitPitStop(pitStop.carsInStop[i]);
        	}
        }
        

	}
	/**
	 * this method check whether car collide with other cars and adjust the speed of the car.
	 */
	public void checkCollision() {
		for(int i = 0; i < len; i ++){
            for(int j = i + 1; j < len; j ++){
                if(cars[i] != null && cars[j] != null && 
                	cars[i].getLocation() % 100 == cars[j].getLocation() % 100){
                	if(cars[i].stopCounter == 2 && cars[i].damage == false) {
                		System.out.println(cars[i] + " has been damaged.");
                		cars[i].damage = true;
                		cars[i].speed -= 5 * cars[i].strength;               		
                	}
                	if(cars[j].stopCounter == 2 && cars[j].damage == false) {
                		System.out.println(cars[j] + " has been damaged.");
                		cars[j].damage = true;
                		cars[j].speed -= 5 * cars[j].strength;                		
                	}
                }
            }
        }
	}
	/**
	 * this method run ticks until the game finish, aka all cars finish 1000 units. and finally output
	 * the score.
	 */
	public void run() {
		while(!finishLine.finished()) {
			tick();
		}
		System.out.printf("You scored %d points", calculatorScore(ticks));
	}
	/**
	 * this method use the numbers of race cars, formula one cars, sports cars and ticks to get
	 * the score
	 * @param ticks
	 * @return score
	 */
	public int calculatorScore(int ticks) {
		for(int i = 0; i < len; i ++) {
			if(finishLine.finishCars[i].type == "RaceCar") score += 150;
			if(finishLine.finishCars[i].type == "FormulaOne") score += 100;
			if(finishLine.finishCars[i].type == "SportsCar") score += 200;
		}
		score -= ticks * 20;
		return score;
	}
	
	/**
	 * This method returns the logger instance used by this RaceTrack. You <b>SHOULD NOT</b> be using this method. 
	 * @return logger with this track's events 
	 */
	public TrackLoggerC getLogger() {
		return logger;
	}

}
