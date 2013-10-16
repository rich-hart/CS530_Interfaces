/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myactor;

/**
 *
 * @author richardhart
 */
import java.util.*;

interface HelloListener {
    public void someoneSaidHello();
}


class Initiater {
    List<HelloListener> listeners = new ArrayList<HelloListener>();

    public void addListener(HelloListener toAdd) {
        listeners.add(toAdd);
    }

    public void sayHello() {
        System.out.println("Hello!!");

        // Notify everybody that may be interested.
        for (HelloListener hl : listeners){
            hl.someoneSaidHello();
        }
    }
}

class Responder implements HelloListener {
    @Override
    public void someoneSaidHello() {
        System.out.println("Hello there...");
    }
}