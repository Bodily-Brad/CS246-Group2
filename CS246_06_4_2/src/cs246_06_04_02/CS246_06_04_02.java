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
        CountByEvens evenJob = new CountByEvens();
        CountByOdds oddJob = new CountByOdds();
        
        Thread evenThread = new Thread(evenJob);
        Thread oddThread = new Thread(oddJob);
        
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
        
        System.out.println("All finished");
    }
    
}
