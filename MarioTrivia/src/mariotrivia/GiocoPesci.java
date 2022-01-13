/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class GiocoPesci extends Thread {

    ArrayList<String> v;
    int scelta = 0;
    ScambioMessaggi s;
    boolean finito = false, timer = false;


    public GiocoPesci() {
        v = new ArrayList<String>(Arrays.asList(new String[]{"f", "f", "t", "t", "t", "t"}));
    }

    public void random() {
        Collections.shuffle(v);
    }

    public boolean isTimer() {
        return timer;
    }

    @Override
    public void run() {
        AvviaTimer();
        timer = true;
    }

    public void AvviaTimer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GiocoSpam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
