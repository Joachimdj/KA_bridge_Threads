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
    private final long openTime = 2000;
    //private final long passTime = 100;
    private static boolean bridgeIsOpen = false;
    private static Boatqueue boatQueue;

    public Bridge() {
        boatQueue = Boatqueue.getInstance();
    }

    @Override
    public void run() {

        while (boatQueue.isBoatsArriving()) {

            System.out.print("");

            if (!boatQueue.getBoatsWaiting().isEmpty()) {

                int numberOfBoatsFromRight = 0;
                int numberOfBoatsFromLeft = 0;
                int passTime = 0;

                for (int i = 0; i < boatQueue.getBoatsWaiting().size(); i++) {

                    if (boatQueue.getBoatsWaiting().get(i).getDirection().equalsIgnoreCase("right")) {
                        System.out.println(boatQueue.getBoatsWaiting().get(i).getName() + " has Passed the bridge from the right");
                        try {
                            boatQueue.removeBoat(i);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        passTime += 100;
                        numberOfBoatsFromRight++;
                    }
                }

                try {
                    Thread.sleep(passTime);
                    System.out.println("Total number of boats passed from right: " + numberOfBoatsFromRight);
                    System.out.println("All boats from right has pass. Time spent: " + passTime);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
                }

                passTime = 0;

                for (int i = 0; i < boatQueue.getBoatsWaiting().size(); i++) {

                    if (boatQueue.getBoatsWaiting().get(i).getDirection().equalsIgnoreCase("left")) {
                        System.out.println(boatQueue.getBoatsWaiting().get(i).getName() + " has Passed the bridge from the left");
                        try {
                            boatQueue.removeBoat(i);
                        } catch (InterruptedException ex) {
                            Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
                        }

                        passTime += 100;
                        numberOfBoatsFromLeft++;
                    }
                }

                try {
                    Thread.sleep(passTime);
                    System.out.println("Total number of boats passed from right: " + numberOfBoatsFromLeft);
                    System.out.println("All boats from left has pass. Time spent: " + passTime);

                } catch (InterruptedException ex) {
                    Logger.getLogger(Bridge.class.getName()).log(Level.SEVERE, null, ex);
                }

                BridgeIsWaitingToOpen();
            }

        }

    }

    public boolean isBridgeIsOpen() {
        return bridgeIsOpen;
    }

    public void BridgeIsWaitingToOpen() {
        try {
            System.out.println("Bridge is now closed");
            Thread.sleep(openTime);
            System.out.println("Bridge is now open");
        } catch (InterruptedException ex) {
            Logger.getLogger(Creator.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
