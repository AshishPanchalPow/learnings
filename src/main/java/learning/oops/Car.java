package learning.oops;

public class Car extends Vehicle{
    boolean hasSunroof;
    @Override
    void turnOn(){
        super.turnOn();
        System.out.println("Now car has started");
    }
}
