package learning.oops;

import java.util.ArrayList;
import java.util.List;

public class Client {
    public static void main(String[] args) {

        Man person=new Man("M");
        System.out.println(person.features());
        Person.height=200;
        System.out.println(person.features());
    }
}
