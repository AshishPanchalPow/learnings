package org.concepts.oops;

public class MathEquation {
    int leftVal;
    int rightVal;
    char opCode;

     String pilot;
    static int countOfObjects=0;
    public int getCountOfObjects(){
        return countOfObjects;
    }
    public static void reset(){
        countOfObjects=0;
    }
    private MathEquation(){
        System.out.println("Default constructor");
        leftVal=10;
        rightVal=20;
        opCode='*';
        pilot="Ashish";
        countOfObjects++;
    }
    MathEquation(char opCode){
        this();
        System.out.println("Second Constructor");
        this.opCode=opCode;
        pilot="Sunny";
    }
}
