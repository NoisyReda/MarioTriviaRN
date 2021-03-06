/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mariotrivia;

import java.awt.Font;
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
public class Sascarfor extends javax.swing.JFrame {

    /**
     * Creates new form Sascarfor
     */
    private Image[] imgs;
    private int pos;
    private TimerG t;
    private int count;
    private boolean lost;
    private char choose;
    private int res;

    public Sascarfor() {
        initComponents();
        Repaint r = new Repaint(this);
        imgs = new Image[3];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = new ImageIcon("src\\image\\RPS\\" + (i + 1) + ".png").getImage().getScaledInstance(256, 217, Image.SCALE_DEFAULT);
        }
        pos = 0;
        lost = false;
        r.start();
        Condivisa.getInstance().setTime(10);
        t = new TimerG();
        t.start();
        choose = ' ';
        count = 0;
        res = 0;
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        if (count == 1) {
            Condivisa.getInstance().setTime(10);
            t = new TimerG();
            t.start();
            count++;
        }
        if (Condivisa.getInstance().getTimer() == 0 || count > 0 || res >= 1) {
            count++;
            offgc.setFont(new Font("Sanserif", Font.BOLD, 150));
            offgc.drawString("→", 90, 320);
            offgc.drawString("←", 480, 320);
            offgc.drawImage(imgs[pos], 225, 150, null);
            offgc.setFont(new Font("Sanserif", Font.BOLD, 60));
            switch (pos) {
                case 0 ->
                    offgc.drawString("CARTA", 215, 480);
                case 1 ->
                    offgc.drawString("SASSO", 215, 480);
                case 2 ->
                    offgc.drawString("FORBICE", 200, 480);
            }
            offgc.setFont(new Font("Sanserif", Font.ITALIC, 40));
            offgc.drawString("INVIO PER SCEGLIERE", 120, 600);
            if (count > 0) {
                offgc.setFont(new Font("Sanserif", Font.BOLD, 150));
                offgc.drawString(String.valueOf(Condivisa.getInstance().getTimer()), 320, 110);
            }
        } else {
            offgc.setFont(new Font("Sanserif", Font.BOLD, 150));
            offgc.drawString(String.valueOf(Condivisa.getInstance().getTimer()), 335, 340);
        }
        if (count > 1 && Condivisa.getInstance().getTimer() == 0) {
            lost = true;
        }
        g.drawImage(offscreen, 0, 50, null);
        if (!"".equals(Condivisa.getInstance().getMess()) && Condivisa.getInstance().getMess().charAt(0) == 'S' && choose != ' ') {
            if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 's' && choose == 'c') {
                this.hide();
                Condivisa.getInstance().getGio().aggiungiPunti(10);
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 'c' && choose == 's') {
                this.hide();
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 'f' && choose == 'c') {
                this.hide();
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 'c' && choose == 'f') {
                this.hide();
                Condivisa.getInstance().getGio().aggiungiPunti(10);
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 's' && choose == 'f') {
                this.hide();
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == 'f' && choose == 's') {
                this.hide();
                Condivisa.getInstance().getGio().aggiungiPunti(10);
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            } else if (Condivisa.getInstance().getMess().split(";")[1].charAt(0) == choose && res < 3) {
                pos = 0;
                lost = false;
                choose = ' ';
                res++;
            } else if (res > 2) {
                this.hide();
                Condivisa.getInstance().getGio().aggiungiPunti(5);
                Mappa m = new Mappa(Condivisa.getInstance().getSc());
                m.show();
            }
        }
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
        setBackground(new java.awt.Color(255, 238, 40));
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 720, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 668, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        if (evt.getKeyCode() == 39) {
            if (pos < 2) {
                pos++;
            } else {
                pos = 0;
            }
        } else if (evt.getKeyCode() == 37) {
            if (pos > 0) {
                pos--;
            } else {
                pos = 2;
            }
        }
        if (evt.getKeyCode() == 10 && !lost) {
            switch (pos) {
                case 0 -> {
                    try {
                        Condivisa.getInstance().getSc().Scrivi("S;c");
                        choose = 'c';
                    } catch (IOException ex) {
                        Logger.getLogger(Sascarfor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 1 -> {
                    try {
                        Condivisa.getInstance().getSc().Scrivi("S;s");
                        choose = 's';
                    } catch (IOException ex) {
                        Logger.getLogger(Sascarfor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                case 2 -> {
                    try {
                        Condivisa.getInstance().getSc().Scrivi("S;f");
                        choose = 'f';
                    } catch (IOException ex) {
                        Logger.getLogger(Sascarfor.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Sascarfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Sascarfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Sascarfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Sascarfor.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Sascarfor().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
