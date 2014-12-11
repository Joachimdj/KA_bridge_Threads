/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

public class Main {

    public static void main(String[] args) {
        
        Thread creator = new Thread(new Creator());
        Thread bridge = new Thread(new Bridge());
        
        creator.start();
        bridge.start();
    }

}
