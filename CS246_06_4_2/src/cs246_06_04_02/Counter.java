/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs246_06_04_02;

/**
 *
 * @author bradb
 */
public class Counter implements Runnable {
    // Constants & Settings
    private static final int DEFAULT_START = 0;
    private static final int DEFAULT_END = 100;
    private static final int DEFAULT_STEP = 1;
    // Local Variables
    private int startingNumber;
    private int endingNumber;
    private int step;
    
    // Constructors
    public Counter() {
        this(DEFAULT_START, DEFAULT_END, DEFAULT_STEP);
    }
    
    public Counter(int start) {
        this(start, DEFAULT_END, DEFAULT_STEP);
    }
    
    public Counter(int start, int end) {
        this(start, end, DEFAULT_STEP);
    }
    
    public Counter(int startingNumber, int endingNumber, int step) {
        this.startingNumber = startingNumber;
        this.endingNumber = endingNumber;
        this.step = step;
        
        if (step == 0) {
            step = DEFAULT_STEP;
        }
        
        // Change counting direction, if necessary
        if (endingNumber < startingNumber ) {
            if (step > 0) {
                step *= -1;
            }
        }
    }
    
    @Override
    public void run() {
        int i=startingNumber;
        if (step > 0) {
            while (i <= endingNumber) {
                System.out.println(i);
                i += step;
                try {
                    Thread.sleep(100);                
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }                 
            }
        } else {
            while (i >= endingNumber) {
                System.out.println();
                i += step;
                try {
                    Thread.sleep(100);
                } catch (InterruptedException ex) {
                    ex.printStackTrace();
                }
            }
        }        
    }    
}
