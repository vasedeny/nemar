package com.acme.multithreading.numbersgame;

public class Bet extends Interval {
    String name;
    
    public Bet(Interval i, String name) {
        super(i.getLow(), i.getHigh());
        this.name = name;
    }

    @Override
    public String toString() {
        return "Bet [name=" + name + ", getLow()=" + getLow() + ", getHigh()=" + getHigh() + "]";
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
}
