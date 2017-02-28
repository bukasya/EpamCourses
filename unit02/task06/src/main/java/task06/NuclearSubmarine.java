package task06;

public class NuclearSubmarine {
    private Engine engine;
    private int speed;

    public NuclearSubmarine(){
        this.speed = 0;
        engine = new Engine();
    }

    public void makeSubmarineMoving(int speed){
        engine.setSpeed(speed);
    }

    public boolean isSubmarineMoving(){
        if(this.speed > 0)
            return true;
        else
            return false;

    }

    public class Engine{
        public Engine setSpeed(int speed){
            if(speed < 0){
                throw new IllegalArgumentException("Speed can't be negative!");
            }
            NuclearSubmarine.this.speed = speed;
            return this;
        }
    }
}
