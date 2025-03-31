package org.concepts.oops;

import java.util.Arrays;

public class Client {
    public static void main(String[] args) {
//       //MathEquation mathEquation=new MathEquation();
//       MathEquation mathEquation1=new MathEquation('^');
//        System.out.println(mathEquation1.getCountOfObjects());
//        MathEquation mathEquation12=new MathEquation('^');
//        System.out.println(mathEquation1.getCountOfObjects());
//        MathEquation.reset();
//        System.out.println(mathEquation1.getCountOfObjects());

//        Flight flightBLRDEL=new Flight(110);
//        Flight flightKOLBOM=new Flight(220);
//        swapFlights(flightBLRDEL,flightKOLBOM);
          String playerType="Openers";
        BatPosition e=BatPosition.valueOf(playerType.toUpperCase());
        System.out.println(order(e));
        BatPosition position1=BatPosition.OPENERS;
        BatPosition position2=BatPosition.TAILENDER;
        System.out.println(position1.compareTo(position2));
        System.out.println(position2.getNum());
        Employee emp1=new Employee("abc","def",31);
        Employee emp2=new Employee("abc","def",32);
        System.out.println(emp1.hashCode());
        System.out.println(emp2.hashCode());

    }
    private static int order(BatPosition enumeration){
        switch (enumeration){
            case OPENERS -> {
                return 2;
            }
            case MIDDLEORDER ->{
                return 6;
            }
            case TAILENDER -> {
                return 10;
            }

        }
        return -1;
    }
    private static void swapFlights(Flight f1, Flight f2){
        Flight temp=f1;
        f1=f2;
        f2=temp;
        f1.flightNum=330;
    }
}
