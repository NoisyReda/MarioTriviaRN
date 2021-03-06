/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Mattia
 */
public class SchermataGiocoSpam extends javax.swing.JFrame {

    /**
     * Creates new form SchermataGiocoSpam
     */
    GiocoSpam g;
    ScambioMessaggi s;
    ProvaTimer p;
    int counterlocale = 0;
    int counterospite = 0;
    int secondimancanti = 10, arrivo = 1000, immagine = 0;
    boolean vittoriasconfitta = false;

    public SchermataGiocoSpam() {
        initComponents();
        g = new GiocoSpam(this);
        p = new ProvaTimer();
        g.start();
        p.start();

    }

    public SchermataGiocoSpam(ScambioMessaggi scambio) {
        initComponents();
        g = new GiocoSpam(this);
        p = new ProvaTimer();
        p.start();
        g.start();
        s = scambio;

    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        Graphics offgc2 = offscreen.getGraphics();
        immagine = s.playerlocale.getImg();

        String str = "src\\image\\" + immagine + ".png";
        System.out.println("locale" + str);

        if (!vittoriasconfitta) {
            offgc.drawImage(new ImageIcon(str).getImage(), counterlocale, 50, null);
        }

        immagine = s.playerospite.getImg();
        str = "src\\image\\" + immagine + ".png";
        System.out.println("ospite" + str);

        if (!vittoriasconfitta) {
            offgc.drawImage(new ImageIcon(str).getImage(), s.spostamento, 250, null);
        }

        if (s.spostamento == arrivo) {
            offgc.drawImage(new ImageIcon("src\\image\\perso.png").getImage(), 50, 50, null);
        }
        if (vittoriasconfitta) {
            offgc.drawImage(new ImageIcon("src\\image\\vittoria.png").getImage(), 50, 50, null);
            //offgc.drawLine(0, 0, 150, 150);

        }
        g.drawImage(offscreen, 100, 100, null);
        //aggiungere linea traguardo e magari uno sfondo carino, ridimensionare immagini vittoria e sconfittas
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 558, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_formKeyPressed

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        if (g.isTimer() && vittoriasconfitta == false) {
            if (evt.getKeyCode() == 32 && s.spostamento < arrivo) {
                counterlocale += 10;
                try {
                    s.Scrivi("M;.");
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoSpam.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (counterlocale == arrivo) {
                    vittoriasconfitta = true;
                    s.playerlocale.aggiungiPunti(10);
                    Mappa m = new Mappa(Condivisa.getInstance().getSc());
                    m.show();
                }
            }
        }
    }//GEN-LAST:event_formKeyReleased

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoSpam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoSpam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoSpam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoSpam.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataGiocoSpam().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
