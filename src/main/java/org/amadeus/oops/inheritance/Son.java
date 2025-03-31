package org.amadeus.oops.inheritance;

public class Son extends Father{
    boolean isStupid;
    int age;

    Son(){
        System.out.println("Son's default constructor");
    }
    Son(int age){
        //super(age*2);
        System.out.println("Son's parameter constructor");
        this.age=age;
        System.out.println(this.age+"   "+super.age);
    }
    public void printSon(){
        System.out.println("The son is: "+isStupid+" whereas Father is: "+hasWisdom +" Father's age is: "+age);
    }
}
