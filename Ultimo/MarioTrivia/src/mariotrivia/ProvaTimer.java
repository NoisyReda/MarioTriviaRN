/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.Timer;
import java.util.TimerTask;

/**
 *
 * @author Mattia
 */
public class ProvaTimer extends Thread {

    int secondimancanti = 10;

    Timer myTimer = new Timer();
    TimerTask task = new TimerTask() {
        @Override
        public void run() {
            if (secondimancanti >= 1){
                secondimancanti--;
                //System.out.println("Secondi mancanti:" + secondimancanti);
            }
        }
    };

    public void start() {
        myTimer.scheduleAtFixedRate(task, 1000, 1000);
    }
}
