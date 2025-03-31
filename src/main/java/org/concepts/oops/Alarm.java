package org.concepts.oops;

import java.time.LocalDateTime;

public class Alarm {
    String message;
    protected boolean active=true;
    LocalDateTime snoozeUntil;
    final String companyName="Ash_Company";

    Alarm(String message){
        this.message=message;
    }
    void turnOn(){
        active=true;
    }
    void turnOff(){
        active=false;
    }
    void snooze(){
        snoozeUntil=LocalDateTime.now().plusMinutes(5);
    }
    String getReport(){
        return getReport(false);
    }
    String getReport(boolean uppercase){
        if(active){
            if(uppercase){
                return message.toUpperCase();
            }
            else return message;
        }
        return "";
    }
    void sendReport(){
        System.out.println(getReport(true));
    }
}
