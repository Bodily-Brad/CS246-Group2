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
public class CS246_06_04_02 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // Create a 0 to 100 by 2 counter
        Counter evenJob = new Counter(0, 100, 2);
        // Create a 1 to 100 by 1 counter
        Counter oddJob = new Counter(1, 100, 2);
        // Create a display running job
        ShowRunning runningJob = new ShowRunning();
        
        Thread evenThread = new Thread(evenJob);
        Thread oddThread = new Thread(oddJob);
        Thread runningThread = new Thread(runningJob);
        
        runningThread.start();
        evenThread.start();
        oddThread.start();
        
        try {
            evenThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        }
        
        try {
            oddThread.join();
        } catch (InterruptedException ex) {
            ex.printStackTrace();
        } 
        
        runningJob.Stop();
        System.out.println("All finished");
    }
    
}
