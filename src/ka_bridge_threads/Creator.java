/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Creator implements Runnable {

    private int boatArrivalSeed = 5000;
    private int boatNumber = 1;
    private Random boatArrivalTime;
    private Random boatDirection;
    private Boatqueue boatQueue;

    public Creator() {
        boatArrivalTime = new Random();
        boatDirection = new Random();
        boatQueue = Boatqueue.getInstance();
    }

    @Override
    public void run() {

        while (boatQueue.isBoatsArriving()) {
            
            int spawnTime = boatArrivalTime.nextInt(boatArrivalSeed);

            try {
                Thread.sleep(spawnTime);
            } catch (InterruptedException ex) {
                Logger.getLogger(Creator.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            int heading = boatDirection.nextInt(2);
            String direction = (heading == 0) ? "left" : "right";

            Boat boat = new Boat("Boat " + boatNumber, direction);
            System.out.println(boat.getName() + " is arriving on the " + boat.getDirection());
            boatQueue.addBoat(boat);

            boatNumber++;
        }
    }

}
