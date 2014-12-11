/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.ArrayList;



public class Bridge implements Runnable{
    
    public static boolean bridgeIsOpen = true;

    public Bridge() {
    }

    public static boolean isBridgeIsOpen() {
        return bridgeIsOpen;
    }

    public static void setBridgeIsOpen(boolean bridgeIsOpen) {
        Bridge.bridgeIsOpen = bridgeIsOpen;
    }

    @Override
    public void run() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
