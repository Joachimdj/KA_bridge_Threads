/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

/**
 *
 * @author joachimdittman
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Thread creator = new Thread(new Creator());
        creator.start();
        
        Thread bridge = new Thread(new Bridge());
        bridge.start();
                
        
    }
    
}
