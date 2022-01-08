/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.ArrayList;
import java.util.Arrays;

/**
 *
 * @author Mattia
 */
public class GiocoPesci extends Thread {

    ArrayList<String> v;
    int scelta=0;
    ScambioMessaggi s;

    public GiocoPesci() {
        v = new ArrayList<String>(Arrays.asList(new String[]{"f", "f", "t", "t", "t", "t"}));
    }

    public void random() {
        java.util.Collections.shuffle(v);
    }

    @Override
    public void run() {
        
    }
    
    
}
