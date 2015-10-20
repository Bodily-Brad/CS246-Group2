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
public class ShowRunning implements Runnable {
    private boolean shouldRun = true;
    @Override
    public void run() {
        while (shouldRun) {
            System.out.println("running...");
            try {
                Thread.sleep(1000);                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }            
        }
    }
    
    public void Stop() {
        shouldRun = false;
    }
}
