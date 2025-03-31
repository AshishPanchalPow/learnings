package org.amadeus.oops.polymorphism;

public class Client {
    public static  void doPayment(User u){

    }
    public static void main(String[] args) {
        User u=new User();
        User s=new Student();
        doPayment(u);
        doPayment(s);

    }
}
