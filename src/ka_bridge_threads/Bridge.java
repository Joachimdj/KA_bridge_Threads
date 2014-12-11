/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Bridge implements Runnable {

    private ArrayList<Boat> boatsInQueue;
    private final long openTime = 2000;
    private final long passTime = 100;
    private static boolean bridgeIsOpen = false;
    private static Boatqueue boatQueue;

    public Bridge() {
        boatQueue = Boatqueue.getInstance();
    }

    @Override
    public void run() {

        while (boatQueue.isBoatsArriving()) {

            boatsInQueue = boatQueue.getBoatsWaiting();

            if (boatsInQueue.isEmpty()) {
                System.out.println("test");
                setBridgeIsOpen(false);
            } else {
                setBridgeIsOpen(true);

                for (int i = 0; i < boatsInQueue.size(); i++) {

                    if (boatsInQueue.get(i).getDirection().equalsIgnoreCase("right")) {
                        boatQueue.removeBoat(boatsInQueue.get(i));
                        System.out.println(boatsInQueue.get(i).getName() + " has Passed the bridge from the right");

                        boatIsPassing();
                    }
                }

                for (int i = 0; i < boatsInQueue.size(); i++) {

                    if (boatsInQueue.get(i).getDirection().equalsIgnoreCase("left")) {
                        System.out.println(boatsInQueue.get(i).getName() + " has Passed the bridge from the left");
                        boatQueue.removeBoat(boatsInQueue.get(i));

                        boatIsPassing();
                    }
                }
                BridgeIsWaitingToOpen();
            }

        }
    }

    public boolean isBridgeIsOpen() {
        return bridgeIsOpen;
    }

    public void setBridgeIsOpen(boolean bridgeIsOpen) {
        Bridge.bridgeIsOpen = bridgeIsOpen;
    }

    public void boatIsPassing() {
        try {
            System.out.println("Boat is passing");
            Thread.sleep(passTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Creator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void BridgeIsWaitingToOpen() {
        try {
            System.out.println("Bridge is now closed - opening in 2 seconds");
            Thread.sleep(openTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Creator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
