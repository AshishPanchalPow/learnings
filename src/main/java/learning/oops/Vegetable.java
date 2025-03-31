package learning.oops;

import javax.sound.midi.Soundbank;

public abstract class Vegetable {
    abstract void cook();
    void clean(){
        System.out.println("With Water");
    }
}
