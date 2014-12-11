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

    private long openTime = 2000;
    private long passTime = 100;
    private int boatArrivalSeed = 5000;
    private Random boatArrivalTime;
    private BoatQueue boatQueue;

    public Creator() {
        boatArrivalTime = new Random();
        boatQueue = BoatQueue.getInstance();
        boatQueue
    }

    @Override
    public void run() {


        
        while(){
                    int spawnTime = boatArrivalTime.nextInt(boatArrivalSeed);

        try {
            Thread.sleep(spawnTime);
        } catch (InterruptedException ex) {
            Logger.getLogger(Creator.class.getName()).log(Level.SEVERE, null, ex);
        }
        }
    }

}
