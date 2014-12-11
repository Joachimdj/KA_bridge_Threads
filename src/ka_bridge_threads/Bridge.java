/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bridge implements Runnable {

    private ArrayList<Boat> boatsInQueue;
    private long timeToPass;
    private long openTime = 2000;
    private long passTime = 100;
    private static boolean bridgeIsOpen = false;
    private static Boatqueue boatQueue;

    public Bridge() {
        boatQueue = Boatqueue.getInstance();
    }

    @Override
    public void run() {

        while (boatQueue.isBoatsArriving()) {
//             timeToPass = System.currentTimeMillis() + openTime;
//            if (System.currentTimeMillis() <= timeToPass) {
//                setBridgeIsOpen(true);
//                System.out.println("Bidge is open");
//            } else {
//                setBridgeIsOpen(false);
//                System.out.println("Bidge is closed");
//            }
            boatsInQueue = boatQueue.getBoatsWaiting();
            
            for (int i = 0; i < boatsInQueue.size(); i++) {

                if (boatsInQueue.get(i).getDirection().equalsIgnoreCase("Left")) {
                    boatQueue.removeBoat(boatsInQueue.get(i));
                    System.out.println("" + boatsInQueue.get(i).getName() + " has Passed the bridge");
                } else if (boatsInQueue.get(i).getDirection().equalsIgnoreCase("Right")) {
                    boatQueue.removeBoat(boatsInQueue.get(i));
                    System.out.println("" + boatsInQueue.get(i).getName() + " has Passed the bridge");
                } else {
                    System.out.println("Something Happend");
                }

            }

        }
    }

    public static boolean isBridgeIsOpen() {
        return bridgeIsOpen;
    }

    public static void setBridgeIsOpen(boolean bridgeIsOpen) {
        Bridge.bridgeIsOpen = bridgeIsOpen;
    }

}
