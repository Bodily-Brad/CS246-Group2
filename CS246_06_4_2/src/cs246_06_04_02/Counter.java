/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs246_06_04_02;

/**
 * Counter class that counts (egads!)
 * A starting point, ending point, and step value can be specified
 * @author Brad Bodily
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
    /**
     * Creates a new instance of Counter with the default settings
     */
    public Counter() {
        this(DEFAULT_START, DEFAULT_END, DEFAULT_STEP);
    }
    
    /**
     * Creates a new instance of Counter with the specified staring number
     * @param start the number to begin counting at
     */
    public Counter(int start) {
        this(start, DEFAULT_END, DEFAULT_STEP);
    }
    
    /**
     * Creates a new instance of Counter with the specified starting and ending
     * numbers
     * @param start the number to begin counting at
     * @param end the number to end counting at
     */
    public Counter(int start, int end) {
        this(start, end, DEFAULT_STEP);
    }
    
    /**
     * Creates a new instance of Counter with the specified starting, ending,
     * and step numbers
     * @param startingNumber the number to begin counting at
     * @param endingNumber the number to end counting at
     * @param step the number to count by
     */
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
    
    /**
     * Main loop
     */
    @Override
    public void run() {
        // Start at the start
        int i=startingNumber;
        
        // Are we counting up?
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
        // Or are we counting down?
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
