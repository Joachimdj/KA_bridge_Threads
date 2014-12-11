/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;

public class Shared {

    private boolean boatWaiting = true;

    synchronized void setBoatWaiting() {
        while (!boatWaiting) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        boatWaiting = true;
        notify();
    }

    synchronized boolean isBoatWaiting() {
        while (boatWaiting) {
            try {
                wait();
            } catch (InterruptedException e) {
            }
        }

        boatWaiting = false;
        notify();

        return boatWaiting;
    }

}
