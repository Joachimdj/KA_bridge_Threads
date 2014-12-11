/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ka_bridge_threads;


public class Boat {
    
    private String name;
    private String direction;

    public Boat(String name, String direction) {
        this.name = name;
        this.direction = direction;   
    }

    public String getName() {
        return name;
    }

    public String getDirection() {
        return direction;
    }
    
}
