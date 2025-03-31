package org.concepts.oops;

public enum BatPosition {

    OPENERS(2),
    MIDDLEORDER(6),
    TAILENDER(10);

    int num;

    public int getNum() {
        return num;
    }
    private BatPosition(int num){
        this.num=num;
    }
}
