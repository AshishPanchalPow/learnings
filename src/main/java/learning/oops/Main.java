package learning.oops;

import org.amadeus.oops.polymorphism.C;

import java.awt.*;

public class Main {
    public static void main(String[] args) {
        Vehicle vehicle=new Car();
        vehicle.turnOn();
        test((vehicle));
        Color color=new Color(255, 0, 0);
        color.brighter();

    }
    public static void test(Vehicle vehicle){
        System.out.println("A special case");
        vehicle.turnOn();
    }
}
