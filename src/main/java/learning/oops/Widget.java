package learning.oops;

public interface Widget {
    String name = "";
    static int areaCal(){
        return 100;
    }
    int area();
    default void printWidget(){
        int x=areaCal();
        System.out.println("This is a default implementation "+x);
    }

}
