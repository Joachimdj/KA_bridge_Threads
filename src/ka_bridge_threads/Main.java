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

        Shared s = new Shared();
        
        Thread creator = new Thread(new Creator(s));
        Thread bridge = new Thread(new Bridge(s));
        creator.start();
        bridge.start();

    }

}
