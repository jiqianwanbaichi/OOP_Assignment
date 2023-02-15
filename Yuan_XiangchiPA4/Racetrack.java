public class Racetrack {
    Car[] cars;
    int ticks;
    int len;
    FinishLine finishLine;
    PitStop pitStop;
    public Racetrack(){

    }
    public void setCars(Car[] cars){
        len = cars.length;
        this.cars = cars;
        finishLine= new FinishLine(len);
    }
    public void tick(){
        ticks ++;
        System.out.println("Tick " + ticks);
        for(int i = 0; i < len; i ++){
            if(cars[i].inPitStop == true){
                cars[i].stopCount --;
                if(cars[i].stopCount == 0)
                cars[i].inPitStop = false;
            }               
            else if(!cars[i].finish){
                cars[i].location += cars[i].speed;
                if( cars[i].location % 100 > 75 && (cars[i].location - cars[i].speed) % 100 < 75 && cars[i].damage == true){
                    pitStop.enterPitStop(cars[i]);
                }
            }           
        }
        checkCollision();
    }
    public void checkCollision() {
        for(int i = 0; i < len; i ++){
            for(int j = i + 1; j < len; j ++){
                if(cars[i].getLocation() % 100 == cars[j].getLocation() % 100 &&
                 !cars[i].finish && !cars[j].finish && !cars[i].inPitStop && !cars[j].inPitStop){
                    cars[i].damage = true;
                    cars[j].damage = true;
                    cars[i].speed -= 5 * cars[i].strength;
                    cars[j].speed -= 5 * cars[j].strength;
                    System.out.println(cars[i] + "has been damaged");
                    System.out.println(cars[j] + "has been damaged");
                }
            }
        }
    }
    public void run() {
        
        while(!finishLine.finished()){
            tick();
        }
    }
    public int calculateScore(int ticks){
        int raceCarNum = 0;
        int formulaOneNum = 0;
        int sportsCarNum = 0;
        return 1000 - 20 * ticks + 150 * raceCarNum + 100 * formulaOneNum + 200 * sportsCarNum;
    }
}
