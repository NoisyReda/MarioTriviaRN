/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class GiocoLato extends Thread {

   ArrayList<String> v = new ArrayList<String>();
    int contatore = 0;
    boolean timer = false;

    public GiocoLato() {
        String s = "";
        Random rand = new Random(); //instance of random class
        for (int i = 0; i < 6; i++) {
            int max = 4;
            int int_random = rand.nextInt(max);
            int_random+=1;
            v.add(Integer.toString(int_random));
        }

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
