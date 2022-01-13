/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/**
 *
 * @author Mattia
 */
public class GiocoSpam extends Thread {

    Giocatore giocatore = new Giocatore();
    private JFrame jf;
    private boolean timer = false;
    private int secondimancanti = 10;

    public GiocoSpam(JFrame jf) {

        this.jf = jf;

    }

    public void IncrementoPunteggio() {
        giocatore.incrementapunteggio();
    }

    public boolean isTimer() {
        return timer;
    }

    public void setTimer(boolean timer) {
        this.timer = timer;
    }

    @Override
    public void run() {
        //avvio timer di 5 secondi come fase preparatoria del gioco
        AvviaTimer();
        timer = true;
        while (true) {
            jf.repaint();
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                Logger.getLogger(GiocoSpam.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void AvviaTimer() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(GiocoSpam.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

}
