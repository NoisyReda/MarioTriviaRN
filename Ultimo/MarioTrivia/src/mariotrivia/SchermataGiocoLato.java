/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.awt.Image;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Mattia
 */
public class SchermataGiocoLato extends javax.swing.JFrame {

    /**
     * Creates new form SchermataGiocoLato
     */
    ScambioMessaggi scambio;
    GiocoLato g;
    String correttamomentanea = "";
    Integer punti = 0;

    public SchermataGiocoLato() {
        initComponents();
    }

    public SchermataGiocoLato(ScambioMessaggi s) {
        initComponents();
        scambio = s;
        g = s.l;

        if (scambio.playerlocale.isHost()) {
            g.random();
            String str = "P;";
            for (int i = 0; i < g.v.size(); i++) {
                str += g.v.get(i) + ";";
            }
            try {
                scambio.InviaPacchetto(str);
            } catch (IOException ex) {
                Logger.getLogger(SchermataGiocoLato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        try {
            Thread.sleep(5000);
            g.timer = true;
        } catch (InterruptedException ex) {
            Logger.getLogger(SchermataGiocoLato.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(() -> {
            while (true) {
                for (int i = 0; i < g.v.size(); i++) {
                    System.out.println(i);
                    proietta(g.v.get(i));
                    correttamomentanea = g.v.get(i);
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(SchermataGiocoLato.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    s.InviaPacchetto("l;" + punti);
                    s.playerlocale.aggiungiPunti(punti);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoLato.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            }
        }).start();
    }

    public void proietta(String giusta) {
        //proiezioni immagini errate con controllo
        System.out.println("Entrato");
        if (giusta.equals("1")) {
            Errata3.setIcon(new ImageIcon(getClass().getResource("/image/freccia2.png")));
            Errata2.setIcon(new ImageIcon(getClass().getResource("/image/freccia3.png")));
            Errata1.setIcon(new ImageIcon(getClass().getResource("/image/freccia4.png")));
        } else if (giusta.equals("2")) {
            Errata3.setIcon(new ImageIcon(getClass().getResource("/image/freccia1.png")));
            Errata1.setIcon(new ImageIcon(getClass().getResource("/image/freccia3.png")));
            Errata2.setIcon(new ImageIcon(getClass().getResource("/image/freccia4.png")));
        } else if (giusta.equals("3")) {
            Errata1.setIcon(new ImageIcon(getClass().getResource("/image/freccia1.png")));
            Errata2.setIcon(new ImageIcon(getClass().getResource("/image/freccia2.png")));
            Errata3.setIcon(new ImageIcon(getClass().getResource("/image/freccia4.png")));
        } else if (giusta.equals("4")) {
            Errata3.setIcon(new ImageIcon(getClass().getResource("/image/freccia1.png")));
            Errata1.setIcon(new ImageIcon(getClass().getResource("/image/freccia2.png")));
            Errata2.setIcon(new ImageIcon(getClass().getResource("/image/freccia3.png")));
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

        Errata3 = new javax.swing.JLabel();
        Errata1 = new javax.swing.JLabel();
        Errata2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                formKeyReleased(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(137, 137, 137)
                .addComponent(Errata1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Errata2, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(Errata3, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(89, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(51, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Errata3, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Errata1, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Errata2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(301, 301, 301))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyReleased
        // TODO add your handling code here:
        //37 freccia sinistra
        //38 freccia in alto
        //39 freccia destra
        //40 freccia in basso
        //proietto tutte le frecce tranne quella corretta e devo schiacciarla
        if (g.isTimer()) {
            System.out.println(evt.getExtendedKeyCode());
            if (correttamomentanea.equals("1")) {
                if (Integer.toString(evt.getExtendedKeyCode()).equals("38")) {
                    punti += 2;
                } else {
                    punti -= 1;
                }
            } else if (correttamomentanea.equals("2")) {
                if (Integer.toString(evt.getExtendedKeyCode()).equals("40")) {
                    punti += 2;
                } else {
                    punti -= 1;
                }
            } else if (correttamomentanea.equals("3")) {
                if (Integer.toString(evt.getExtendedKeyCode()).equals("37")) {
                    punti += 2;
                } else {
                    punti -= 1;
                }
            } else if (correttamomentanea.equals("4")) {
                if (Integer.toString(evt.getExtendedKeyCode()).equals("39")) {
                    punti += 2;
                } else {
                    punti -= 1;
                }
            }
            System.out.println(punti);
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
            java.util.logging.Logger.getLogger(SchermataGiocoLato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoLato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoLato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoLato.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataGiocoLato().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Errata1;
    private javax.swing.JLabel Errata2;
    private javax.swing.JLabel Errata3;
    // End of variables declaration//GEN-END:variables
}
