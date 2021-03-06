/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package mariotrivia;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.SwingUtilities;

/**
 *
 * @author Mattia
 */
public class Tris extends javax.swing.JFrame {

    private boolean tr1;
    private boolean pos[];
    private int cx[];
    private int cy[];
    private char situa[];

    /**
     * Creates new form Tris
     */
    public Tris() {
        initComponents();
        pos = new boolean[18];
        cx = new int[18];
        cy = new int[18];
        tr1 = false;
        situa = new char[36];
        for (int i = 0; i < situa.length; i++) {
            situa[i] = (char) i;
        }
        Repaint r = new Repaint(this);
        r.start();
    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        for (int i = 0, l = 200; i < 5; i++, l++) {
            offgc.drawLine(l, 150, l, 650);
        }
        for (int i = 0, l = 400; i < 5; i++, l++) {
            offgc.drawLine(l, 150, l, 650);
        }
        for (int i = 0, l = 320; i < 5; i++, l++) {
            offgc.drawLine(50, l, 550, l);
        }
        for (int i = 0, l = 480; i < 5; i++, l++) {
            offgc.drawLine(50, l, 550, l);
        }
        boolean start = false;
        for (int i = 0; i < pos.length; i++) {
            if (pos[i] == true) {
                offgc.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 130));
                offgc.drawString("X", cx[i], cy[i]);
                situa[i] = 'X';
                //offgc.drawString("O", cx[i], cy[i]);
            }
        }
        if (checkWin() != null) {
            offgc.setFont(new Font(Font.SANS_SERIF, Font.PLAIN, 130));
            offgc.setColor(Color.RED);
            offgc.drawString(String.valueOf(situa[checkWin()[0]]), cx[checkWin()[0]], cy[checkWin()[0]]);
            offgc.drawString(String.valueOf(situa[checkWin()[1]]), cx[checkWin()[1]], cy[checkWin()[1]]);
            offgc.drawString(String.valueOf(situa[checkWin()[2]]), cx[checkWin()[2]], cy[checkWin()[2]]);
        }
        g.drawImage(offscreen, 0, 50, null);
    }

    private int[] checkWin() {
        int[] win = new int[3];
        if (situa[0] == situa[3] && situa[3] == situa[6]) {
            win[0] = 0;
            win[1] = 3;
            win[2] = 6;
            tr1 = true;
            return win;
        } else if (situa[1] == situa[4] && situa[4] == situa[7]) {
            win[0] = 1;
            win[1] = 4;
            win[2] = 7;
            tr1 = true;
            return win;
        } else if (situa[2] == situa[5] && situa[5] == situa[8]) {
            win[0] = 2;
            win[1] = 5;
            win[2] = 8;
            tr1 = true;
            return win;
        } else if (situa[0] == situa[1] && situa[1] == situa[2]) {
            win[0] = 0;
            win[1] = 1;
            win[2] = 2;
            tr1 = true;
            return win;
        } else if (situa[3] == situa[4] && situa[4] == situa[5]) {
            win[0] = 3;
            win[1] = 4;
            win[2] = 5;
            tr1 = true;
            return win;
        } else if (situa[6] == situa[7] && situa[7] == situa[8]) {
            win[0] = 6;
            win[1] = 7;
            win[2] = 8;
            tr1 = true;
            return win;
        } else if (situa[0] == situa[4] && situa[4] == situa[8]) {
            win[0] = 0;
            win[1] = 4;
            win[2] = 8;
            tr1 = true;
            return win;
        } else if (situa[2] == situa[4] && situa[4] == situa[6]) {
            win[0] = 2;
            win[1] = 4;
            win[2] = 6;
            tr1 = true;
            return win;
        }
        return null;
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
            .addGap(0, 710, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 788, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_formMousePressed
        if (SwingUtilities.isLeftMouseButton(evt)) {
            int x = evt.getX();
            int y = evt.getY();
            if (!tr1) {
                if (x > 49 && x < 198 && y > 199 && y < 370) {
                    cx[0] = Math.round((198 - 49) / 2);
                    cy[0] = Math.round((370 - 199) / 2) + 190;
                    pos[0] = true;
                }
                if (x > 49 && x < 198 && y > 373 && y < 530) {
                    cx[1] = Math.round((198 - 49) / 2);
                    cy[1] = Math.round((530 - 20) / 2) + 190;
                    pos[1] = true;
                }
                if (x > 49 && x < 198 && y > 534 && y < 699) {
                    cx[2] = Math.round((198 - 49) / 2);
                    cy[2] = Math.round((699 + 140) / 2) + 190;
                    pos[2] = true;
                }
                if (x > 203 && x < 400 && y > 199 && y < 369) {
                    cx[3] = Math.round((400 - 203) + 60);
                    cy[3] = Math.round((370 - 199) / 2) + 190;
                    pos[3] = true;
                }
                if (x > 203 && x < 400 && y > 373 && y < 530) {
                    cx[4] = Math.round((400 - 203) + 60);
                    cy[4] = Math.round((530 - 20) / 2) + 190;
                    pos[4] = true;
                }
                if (x > 203 && x < 400 && y > 534 && y < 699) {
                    cx[5] = Math.round((400 - 145));
                    cy[5] = Math.round((699 + 140) / 2) + 190;
                    pos[5] = true;
                }
                if (x > 403 && x < 551 && y > 199 && y < 370) {
                    cx[6] = Math.round((550 - 120));
                    cy[6] = Math.round((370 - 199) / 2) + 190;
                    pos[6] = true;
                }
                if (x > 403 && x < 551 && y > 373 && y < 530) {
                    cx[7] = Math.round((550 - 120));
                    cy[7] = Math.round((530 - 20) / 2) + 190;
                    pos[7] = true;
                }
                if (x > 403 && x < 551 && y > 534 && y < 699) {
                    cx[8] = Math.round((550 - 120));
                    cy[8] = Math.round((699 + 140) / 2) + 190;
                    pos[8] = true;
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
            java.util.logging.Logger.getLogger(Tris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tris.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tris().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
