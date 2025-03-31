package learning.oops;

public class Man extends Person{
     final String sex;

     Man(String sex){
         this.sex=sex;
     }
    String features(){
         Person.height=100;
        return "Taller+Smarter"+Person.height;
    }
    String describe(){
        return "Name is: "+name+"Age is: "+age+"Sex: Man";
    }

}
