package org.concepts.oops;

public class Flight {
    int flightNum;
    Flight(){

    }
    Flight(int flightNum){
        this.flightNum=flightNum;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof Flight)){
           return false;
        }
        Flight incomingObject=(Flight) obj;
        return flightNum==incomingObject.flightNum;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
