package org.amadeus.oops.inheritance;

public class Father {

    int age;
    boolean hasWisdom;

    Father(){
        System.out.println("Father's default constructor");
        this.hasWisdom=true;
    }

    Father(int age){
        System.out.println("Father's parameter constructor");
        this.age=age;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public boolean isHasWisdom() {
        return hasWisdom;
    }

    public void setHasWisdom(boolean hasWisdom) {
        this.hasWisdom = hasWisdom;
    }

}
