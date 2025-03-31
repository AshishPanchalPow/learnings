package org.concepts.oops;

public class PrioritizedAlarm extends Alarm{
    private final int priority;
    public PrioritizedAlarm(String message, int priority){
        super(message);
        this.priority=priority;
    }
    public int getPriority(){
        return priority;
    }
    public String getReport(boolean uppercase){
        if(active){
            if(uppercase){
                return message.toUpperCase() +"!";
            }
            else return message +"!";
        }
        return "";
    }

    public static void main(String[] args) {
        PrioritizedAlarm alarm=new PrioritizedAlarm("Prio ALarm",10);
        alarm.sendReport();
    }
}
