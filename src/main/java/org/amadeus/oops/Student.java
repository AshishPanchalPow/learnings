package org.amadeus.oops;

public class Student {
    // write the code of student class here
    int age;
    static double PI=3.14;
    String name;

     Student(){
        this(0,null);
    }

    Student(int age){
        this(age,null);
    }

    Student(String name){
        this(0,name);
    }

    Student(int age, String name){
        System.out.println("here");
        this.age=age;
        this.name=name;
    }
}
