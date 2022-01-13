/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mattia
 */
public class Mappa extends javax.swing.JFrame {

    private int ran;
    private boolean st;

    /**
     * Creates new form Mappa
     */
    public Mappa() {
        initComponents();
        Repaint r = new Repaint(this);
        r.start();
        ran = 0;
        st = false;
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        offgc.drawImage(new ImageIcon("src\\image\\Mappa.jpeg").getImage(), 0, 0, 1000, 1000, this);
        offgc.drawImage(new ImageIcon("src\\image\\dice.png").getImage(), 450, 130, 130, 130, this);
        offgc.drawImage(new ImageIcon("src\\image\\1.png").getImage().getScaledInstance(256, 217, Image.SCALE_DEFAULT), 30, 15, this);
        if (ran == 0) {
            offgc.setFont(new Font(Font.SANS_SERIF, Font.ROMAN_BASELINE, 30));
            offgc.drawString("TIRA", 477, 182);
            offgc.drawString("IL", 503, 207);
            offgc.drawString("DADO", 473, 232);
        }
        if (ran != 0) {
            for (int i = 0; i < 30 && !st; i++) {
                Random e = new Random();
                switch (e.nextInt(7 - 1 + 0) + 1) {
                    case 1 -> {
                        offgc.fillOval(504, 183, 20, 20);
                    }
                    case 2 -> {
                        offgc.fillOval(465, 145, 20, 20);
                        offgc.fillOval(543, 220, 20, 20);
                    }
                    case 3 -> {
                        offgc.fillOval(465, 145, 20, 20);
                        offgc.fillOval(504, 183, 20, 20);
                        offgc.fillOval(543, 220, 20, 20);
                    }
                    case 4 -> {
                        offgc.fillOval(465, 145, 20, 20);
                        offgc.fillOval(465, 220, 20, 20);
                        offgc.fillOval(543, 145, 20, 20);
                        offgc.fillOval(543, 220, 20, 20);
                    }
                    case 5 -> {
                        offgc.fillOval(465, 145, 20, 20);
                        offgc.fillOval(465, 220, 20, 20);
                        offgc.fillOval(504, 183, 20, 20);
                        offgc.fillOval(543, 145, 20, 20);
                        offgc.fillOval(543, 220, 20, 20);
                    }
                    case 6 -> {
                        offgc.fillOval(465, 145, 20, 20);
                        offgc.fillOval(465, 183, 20, 20);
                        offgc.fillOval(465, 220, 20, 20);
                        offgc.fillOval(543, 145, 20, 20);
                        offgc.fillOval(543, 183, 20, 20);
                        offgc.fillOval(543, 220, 20, 20);
                    }
                }
                g.drawImage(offscreen, 0, 50, null);
                offgc.drawImage(new ImageIcon("src\\image\\Mappa.jpeg").getImage(), 0, 0, 1000, 1000, this);
                offgc.drawImage(new ImageIcon("src\\image\\dice.png").getImage(), 450, 130, 130, 130, this);
                try {
                    Thread.sleep(70);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Mappa.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            st = true;
            switch (ran) {
                case 1 -> {
                    offgc.fillOval(504, 183, 20, 20);
                }
                case 2 -> {
                    offgc.fillOval(465, 145, 20, 20);
                    offgc.fillOval(543, 220, 20, 20);
                }
                case 3 -> {
                    offgc.fillOval(465, 145, 20, 20);
                    offgc.fillOval(504, 183, 20, 20);
                    offgc.fillOval(543, 220, 20, 20);
                }
                case 4 -> {
                    offgc.fillOval(465, 145, 20, 20);
                    offgc.fillOval(465, 220, 20, 20);
                    offgc.fillOval(543, 145, 20, 20);
                    offgc.fillOval(543, 220, 20, 20);
                }
                case 5 -> {
                    offgc.fillOval(465, 145, 20, 20);
                    offgc.fillOval(465, 220, 20, 20);
                    offgc.fillOval(504, 183, 20, 20);
                    offgc.fillOval(543, 145, 20, 20);
                    offgc.fillOval(543, 220, 20, 20);
                }
                case 6 -> {
                    offgc.fillOval(465, 145, 20, 20);
                    offgc.fillOval(465, 183, 20, 20);
                    offgc.fillOval(465, 220, 20, 20);
                    offgc.fillOval(543, 145, 20, 20);
                    offgc.fillOval(543, 183, 20, 20);
                    offgc.fillOval(543, 220, 20, 20);
                }
            }
        }
        g.drawImage(offscreen, 0, 50, null);
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
        setPreferredSize(new java.awt.Dimension(1000, 1050));
        setResizable(false);
        setSize(new java.awt.Dimension(1000, 1000));
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                formMouseClicked(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMouseClicked
        if (SwingUtilities.isLeftMouseButton(evt)) {
            int x = evt.getX();
            int y = evt.getY();
            if (x > 450 && x < 580 && y > 182 && y < 310) {
                Random i = new Random();
                ran = i.nextInt(7 - 1 + 1) + 1;
            }
        }
    }//GEN-LAST:event_formMouseClicked

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
            java.util.logging.Logger.getLogger(Mappa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Mappa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Mappa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Mappa.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Mappa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
