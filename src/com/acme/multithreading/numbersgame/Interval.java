package com.acme.multithreading.numbersgame;

public class Interval implements Comparable<Interval>{
    private int low, high;

    public int getLow() {
        return low;
    }

    public void setLow(int low) {
        this.low = low;
    }

    public int getHigh() {
        return high;
    }

    public void setHigh(int high) {
        this.high = high;
    }

    public Interval(int low, int high) {
        if (low >= high) {
            
            this.low = high;
            this.high = low;

        } else {
            
            this.low = low;
            this.high = high;

        }
    }

    public Interval() {
        this(
                (int)(Math.random()*100),
                (int)(Math.random()*100)
        );
    }
    
    public int getLength() {
        return high - low;
    }
    
    public boolean crosses(Interval i) {
        return (low < i.getLow() && i.getLow() < high
                ||
            high > i.getLow() && i.getHigh() < high);
                
    }

    @Override
    public int compareTo(Interval i) {
        int result = 0;
        if (i.getLength() > getLength()) {
            result = 1;
        } else if (i.getLength() < getLength()) {
            result = -1;
        } else {
            if (i.getLow() > low) result = -1;
            if (i.getLow() < low) result = 1;
        }
        return result;
    }
    
    public boolean inInterval(Interval i) {
        return low < i.getLow() && high > i.getHigh();
    }
    
}
