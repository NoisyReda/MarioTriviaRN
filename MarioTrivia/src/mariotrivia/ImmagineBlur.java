/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mariotrivia;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mattia
 */
public class ImmagineBlur extends javax.swing.JFrame {

    /**
     * Creates new form ImmagineBlur
     */
    private Image imgs[];
    private TimerG t;
    private int count;
    private boolean lost;
    private boolean check;
    private int rand;
    private int pos[];

    public ImmagineBlur() {
        initComponents();
        Repaint r = new Repaint(this);
        imgs = new Image[6];
        for (int i = 0; i < imgs.length; i++) {
            imgs[i] = new ImageIcon("src\\image\\BlurGame\\" + (i + 1) + ".png").getImage().getScaledInstance(280, 200, Image.SCALE_DEFAULT);
        }
        r.start();
        Condivisa.getInstance().setTime(10);
        t = new TimerG();
        t.start();
        count = 0;
        rand = 0;
        check = false;
        lost = false;
        pos = new int[3];
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
        if (Condivisa.getInstance().getTimer() >= 0 || count > 0) {
            count++;
            if (!check) {
                Random ran = new Random();
                do {
                    rand = ran.nextInt(5 - 0 + 1) + 0;
                    if (rand % 2 != 0) {
                        offgc.drawImage(imgs[rand], 360, 130, null);
                        check = true;
                    }
                } while (!check);
            } else {
                offgc.drawImage(imgs[rand], 390, 130, null);
                for (int i = 0, c = 0; i < imgs.length; i++) {
                    if (i % 2 == 0 && i != rand) {
                        pos[c] = i;
                        c++;
                    }
                }
                offgc.drawImage(imgs[pos[0]], 390, 360, null);
                offgc.drawImage(imgs[pos[1]], 50, 360, null);
                offgc.drawImage(imgs[pos[2]], 730, 360, null);
            }
            if (count > 0) {
                offgc.setFont(new Font("Sanserif", Font.BOLD, 150));
                offgc.drawString(String.valueOf(Condivisa.getInstance().getTimer()), 500, 110);
            }
        } else {
            offgc.setFont(new Font("Sanserif", Font.BOLD, 150));
            offgc.drawString(String.valueOf(Condivisa.getInstance().getTimer()), 500, 340);
        }
        if (count > 1 && Condivisa.getInstance().getTimer() == 0) {
            lost = true;
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
        setResizable(false);
        addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                formMousePressed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1107, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 638, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            int x = evt.getX();
            int y = evt.getY();
            if (lost == false) {
                if (x > 50 && x < 330 && y > 410 && y < 610) {
                    check = false;
                    count = 1;
                }
                if (x > 390 && x < 668 && y > 410 && y < 610) {
                    check = false;
                    count = 1;                    
                }
                if (x > 729 && x < 1008 && y > 410 && y < 610) {
                    check = false;
                    count = 1;
                }
            }
        }
    }//GEN-LAST:event_formMousePressed

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
            java.util.logging.Logger.getLogger(ImmagineBlur.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ImmagineBlur.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ImmagineBlur.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ImmagineBlur.class
                    .getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ImmagineBlur().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
