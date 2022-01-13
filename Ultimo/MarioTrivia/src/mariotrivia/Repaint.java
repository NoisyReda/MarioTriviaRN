package mariotrivia;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Redaelli_Mattia03
 */
public class Repaint extends Thread {

    private JFrame jf;

    public Repaint(JFrame jf) {
        this.jf = jf;
    }

    @Override
    public void run() {
        while (true) {
            jf.repaint();
            try {
                Thread.sleep(10);
            } catch (InterruptedException ex) {
                Logger.getLogger(Repaint.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
