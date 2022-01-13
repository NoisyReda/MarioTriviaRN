/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class SchermataGiocoPesci extends javax.swing.JFrame {

    ScambioMessaggi scambio;
    GiocoPesci p;

    /**
     * Creates new form SchermataGiocoPesci
     */
    public SchermataGiocoPesci() {
        initComponents();
    }

    public SchermataGiocoPesci(ScambioMessaggi s) throws IOException {
        initComponents();
        scambio = s;
        p = s.p;
        
        if (scambio.playerlocale.isHost()) {
            //generare stringa casuale di 6 caratteri separati da ";" da inviare all'utente
            p.random();
            String str = "P;";
            for (int i = 0; i < p.v.size(); i++) {
                str += p.v.get(i) + ";";
            }
            scambio.InviaPacchetto(str);
        }
        try {
            Thread.sleep(5000);
        } catch (InterruptedException ex) {
            Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
        }
        new Thread(() -> {
            while (true) {
                System.out.println(scambio.p.finito);
                if (p.scelta == 1) {
                    Pulsante1.setVisible(false);
                } else if (p.scelta == 2) {
                    Pulsante2.setVisible(false);
                } else if (p.scelta == 3) {
                    Pulsante3.setVisible(false);
                } else if (p.scelta == 4) {
                    Pulsante4.setVisible(false);
                } else if (p.scelta == 5) {
                    Pulsante5.setVisible(false);
                } else if (p.scelta == 6) {
                    Pulsante6.setVisible(false);
                } else if (scambio.p.finito) {
                    Mappa m = new Mappa();
                    m.show();
                    this.hide();
                    break;
                }
            }
        }).start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Pulsante3 = new javax.swing.JButton();
        Pulsante1 = new javax.swing.JButton();
        Pulsante5 = new javax.swing.JButton();
        Pulsante2 = new javax.swing.JButton();
        Pulsante4 = new javax.swing.JButton();
        Pulsante6 = new javax.swing.JButton();
        Output = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Pulsante3.setText("jButton1");
        Pulsante3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante3ActionPerformed(evt);
            }
        });

        Pulsante1.setText("jButton1");
        Pulsante1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante1ActionPerformed(evt);
            }
        });

        Pulsante5.setText("jButton1");
        Pulsante5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante5ActionPerformed(evt);
            }
        });

        Pulsante2.setText("jButton1");
        Pulsante2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante2ActionPerformed(evt);
            }
        });

        Pulsante4.setText("jButton1");
        Pulsante4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante4ActionPerformed(evt);
            }
        });

        Pulsante6.setText("jButton1");
        Pulsante6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Pulsante6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Pulsante1)
                    .addComponent(Pulsante3)
                    .addComponent(Pulsante5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 586, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(Pulsante4)
                    .addComponent(Pulsante2)
                    .addComponent(Pulsante6))
                .addGap(107, 107, 107))
            .addGroup(layout.createSequentialGroup()
                .addGap(402, 402, 402)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pulsante1)
                    .addComponent(Pulsante2))
                .addGap(62, 62, 62)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pulsante3)
                    .addComponent(Pulsante4))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Pulsante5)
                    .addComponent(Pulsante6))
                .addGap(18, 18, 18)
                .addComponent(Output, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(155, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Pulsante1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante1ActionPerformed
        // TODO add your handling code here:

        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(0).equals("t")) {
                    Output.setText("SceltaCorretta");
                    //codice per inviare la scelta all'altro utente
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    scambio.Scrivi("E;1");
                    Pulsante1.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante1ActionPerformed

    private void Pulsante2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante2ActionPerformed
        // TODO add your handling code here:
        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(1).equals("t")) {
                    Output.setText("SceltaCorretta");
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    scambio.Scrivi("E;2");
                    Pulsante2.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante2ActionPerformed

    private void Pulsante3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante3ActionPerformed
        // TODO add your handling code here:
        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(2).equals("t")) {
                    Output.setText("SceltaCorretta");
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    scambio.Scrivi("E;3");
                    Pulsante3.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante3ActionPerformed

    private void Pulsante4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante4ActionPerformed
        // TODO add your handling code here:
        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(3).equals("t")) {
                    Output.setText("SceltaCorretta");
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                try {
                    scambio.Scrivi("E;4");
                    Pulsante4.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante4ActionPerformed

    private void Pulsante5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante5ActionPerformed
        // TODO add your handling code here:
        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(4).equals("t")) {
                    Output.setText("SceltaCorretta");
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    scambio.Scrivi("E;5");
                    Pulsante5.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante5ActionPerformed

    private void Pulsante6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Pulsante6ActionPerformed
        // TODO add your handling code here:
        if (p.isTimer()) {
            if (scambio.playerlocale.isTurno() && !scambio.p.finito) {
                if (p.v.get(5).equals("t")) {
                    Output.setText("SceltaCorretta");
                } else {
                    Output.setText("SceltaErrata");
                    scambio.p.finito = true;
                    try {
                        scambio.Scrivi("e;perso");
                    } catch (IOException ex) {
                        Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                    }

                }
                try {
                    scambio.Scrivi("E;6");
                    Pulsante6.setVisible(false);
                    scambio.playerlocale.setTurno(false);
                } catch (IOException ex) {
                    Logger.getLogger(SchermataGiocoPesci.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }//GEN-LAST:event_Pulsante6ActionPerformed

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
            java.util.logging.Logger.getLogger(SchermataGiocoPesci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoPesci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoPesci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataGiocoPesci.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataGiocoPesci().setVisible(true);

            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Output;
    private javax.swing.JButton Pulsante1;
    private javax.swing.JButton Pulsante2;
    private javax.swing.JButton Pulsante3;
    private javax.swing.JButton Pulsante4;
    private javax.swing.JButton Pulsante5;
    private javax.swing.JButton Pulsante6;
    // End of variables declaration//GEN-END:variables

}
