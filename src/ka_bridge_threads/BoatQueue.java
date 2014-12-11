/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.ArrayList;

public class Boatqueue {

    private static ArrayList<Boat> boatsWaiting;
    private static Boatqueue instance = null;
    private static boolean boatsArriving = true;
    private static Object lock;

    private Boatqueue() {
    }

    public static Boatqueue getInstance() {
        if (instance == null) {
            instance = new Boatqueue();
            boatsWaiting = new ArrayList<>();
            lock = new Object();
        }
        return instance;
    }

    public ArrayList<Boat> getBoatsWaiting() {
        return boatsWaiting;
    }

    public void addBoat(Boat b) {
        synchronized (lock) {
            boatsWaiting.add(b);
            lock.notify();
        }

    }

    public void removeBoat(int i) throws InterruptedException {
        synchronized (lock) {
            while (boatsWaiting.isEmpty()) {
                lock.wait();
            }
            boatsWaiting.remove(i);
        }

    }

    public boolean isBoatsArriving() {
        return boatsArriving;
    }

    public void setBoatsArriving(boolean boatsArriving) {
        Boatqueue.boatsArriving = boatsArriving;
    }

}
