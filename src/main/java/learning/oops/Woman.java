package learning.oops;

public class Woman extends Person{
    String sex;
    Woman(String sex){
        this.sex=sex;
    }
    String features(){
        return "Shorter+Smarter";
    }
    String describe(){
        return "Name is: "+name+"Age is: "+age+"Sex: Woman";
    }
}
