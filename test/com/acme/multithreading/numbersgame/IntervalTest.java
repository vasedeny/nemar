/**
 * 
 */
package com.acme.multithreading.numbersgame;

import junit.framework.Assert;

import org.junit.Before;
import org.junit.Test;

public class IntervalTest {
    private Interval interval1;
    private Interval interval2;
    private Interval interval3;
    private Interval interval4;
    
    @Before
    public void setUp() {
        interval1 = new Interval(10, 20);  //10      
        interval2 = new Interval( 0, 15);  //15  
        interval3 = new Interval(15, 30);  //15  
        interval4 = new Interval(50,100);  //50      
        
    }

    @Test
    public void testIntervalsWhenCrosses(){
        boolean actual = interval1.crosses(interval2);
        Assert.assertTrue(actual);
        
        actual = interval1.crosses(interval3);
        Assert.assertTrue(actual);
    }
    
    @Test
    public void testIntervalsWhenNotCrosses(){
        boolean actual = interval1.crosses(interval4);
        Assert.assertFalse(actual);
        
        actual = interval2.crosses(interval3);
        Assert.assertFalse(actual);
    }
    
    @Test
    public void testIntervalCompareTo(){
        int i = interval1.compareTo(interval2);
        Assert.assertEquals(1, i);
        
        i = interval2.compareTo(interval1);
        Assert.assertEquals(-1, i);
        
        i = interval2.compareTo(interval3);
        Assert.assertEquals(-1, i);
        
        i = interval3.compareTo(interval2);
        Assert.assertEquals(1, i);
        
    }

}
