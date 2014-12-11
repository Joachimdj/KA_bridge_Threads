/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

import java.util.ArrayList;

public class BoatQueue {

    private static ArrayList<Boat> boatsWaiting;
    private static BoatQueue instance = null;
    private static boolean boatsArriving = true;

    private BoatQueue() {
    }

    public static BoatQueue getInstance() {
        if (instance == null) {
            instance = new BoatQueue();
            boatsWaiting = new ArrayList<>();
        }

        return instance;
    }

    public static ArrayList<Boat> getBoatsWaiting() {
        return boatsWaiting;
    }

    public static void addBoat(Boat b) {
        boatsWaiting.add(b);
    }

    public static void removeBoat(Boat b) {
        boatsWaiting.remove(b);
    }

    public static boolean isBoatsArriving() {
        return boatsArriving;
    }

    public static void setBoatsArriving(boolean boatsArriving) {
        BoatQueue.boatsArriving = boatsArriving;
    }
 
}
