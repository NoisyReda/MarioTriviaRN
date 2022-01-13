/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mariotrivia;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class TimerG extends Thread {

    @Override
    public void run() {
        while (Condivisa.getInstance().tick() > 1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(TimerG.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
