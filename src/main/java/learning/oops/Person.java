package learning.oops;

public class Person {

    public static int height=90;
    String name;
    int age;
    Person(){
        //System.out.println("Default constructor called");
    }
    String describe(){
        return "Name is: "+name+"Age is: "+age;
    }
    final String pesonalDetails(){
        return "Something";
    }

}
