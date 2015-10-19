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
public class CountByOdds implements Runnable {

    @Override
    public void run() {
        int i=1;
        while (i <= 100) {
            System.out.println(i);
            i += 2;
            try {
                Thread.sleep(100);                
            } catch (InterruptedException ex) {
                ex.printStackTrace();
            }            
        }
    }
    
}
