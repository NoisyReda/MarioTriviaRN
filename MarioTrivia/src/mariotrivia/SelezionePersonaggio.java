/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.io.IOException;
import java.net.SocketException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Mattia
 */
public class SelezionePersonaggio extends javax.swing.JFrame {

    /**
     * Creates new form SelezionePersonaggio
     */
    ScambioMessaggi s;
    GiocoPesci p;

    public SelezionePersonaggio() throws SocketException {
        initComponents();
    }

    public SelezionePersonaggio(ScambioMessaggi scambio) {
        initComponents();
        s = scambio;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Personaggio4 = new javax.swing.JLabel();
        Personaggio1 = new javax.swing.JLabel();
        Personaggio2 = new javax.swing.JLabel();
        Personaggio3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        nome = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Personaggio4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/4.png"))); // NOI18N
        Personaggio4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personaggio4MouseClicked(evt);
            }
        });

        Personaggio1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/1.png"))); // NOI18N
        Personaggio1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personaggio1MouseClicked(evt);
            }
        });

        Personaggio2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/2.png"))); // NOI18N
        Personaggio2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personaggio2MouseClicked(evt);
            }
        });

        Personaggio3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/3.png"))); // NOI18N
        Personaggio3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                Personaggio3MouseClicked(evt);
            }
        });

        jLabel1.setText("Scegli il tuo personaggio:");

        jLabel2.setText("Inserisci nome:");

        jScrollPane1.setViewportView(nome);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(216, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(208, 208, 208))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(92, 92, 92)
                        .addComponent(Personaggio1)
                        .addGap(53, 53, 53)
                        .addComponent(Personaggio2)
                        .addGap(74, 74, 74)
                        .addComponent(Personaggio3)
                        .addGap(83, 83, 83)
                        .addComponent(Personaggio4))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(191, 191, 191)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 238, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Personaggio3, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Personaggio4, javax.swing.GroupLayout.Alignment.TRAILING)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Personaggio2)
                            .addComponent(Personaggio1))))
                .addGap(73, 73, 73)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(221, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void Personaggio4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personaggio4MouseClicked
        // TODO add your handling code here:
        s.playerlocale.setPlayer(nome.getText());
        s.playerlocale.setImg(4);
        if (s.playerospite.getPlayer().equals("")) {
            s.playerlocale.setTurno(true);
            s.playerlocale.setHost(true);
            Condivisa.getInstance().setGio(s.playerlocale);
        }
        try {
            //invio all'altro giocatore quale personaggio ho scelto
            s.InviaPacchetto("p;" + nome.getText() + ";4");
        } catch (IOException ex) {
            Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (true) {
            /*    SchermataGiocoPesci sc;
            try {
            sc = new SchermataGiocoPesci(s);
            sc.show();
            this.hide();
            } catch (IOException ex) {
            Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
            }*/
            Tris s = new Tris();
            s.show();
            this.hide();
        }

    }//GEN-LAST:event_Personaggio4MouseClicked

    private void Personaggio1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personaggio1MouseClicked
        // TODO add your handling code here:
        s.playerlocale.setPlayer(nome.getText());
        s.playerlocale.setImg(1);
        if (s.playerospite.getPlayer().equals("")) {
            s.playerlocale.setTurno(true);
            s.playerlocale.setHost(true);
            Condivisa.getInstance().setGio(s.playerlocale);
        }
        try {
            //invio all'altro giocatore quale personaggio ho scelto
            s.InviaPacchetto("p;" + nome.getText() + ";1");
        } catch (IOException ex) {
            Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (true) {
            SchermataGiocoPesci sc;
            try {
                sc = new SchermataGiocoPesci(s);
                sc.show();
                this.hide();
            } catch (IOException ex) {
                Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_Personaggio1MouseClicked

    private void Personaggio2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personaggio2MouseClicked
        // TODO add your handling code here:
        s.playerlocale.setPlayer(nome.getText());
        s.playerlocale.setImg(2);
        if (s.playerospite.getPlayer().equals("")) {
            s.playerlocale.setTurno(true);
            s.playerlocale.setHost(true);
            Condivisa.getInstance().setGio(s.playerlocale);
        }
        try {
            //invio all'altro giocatore quale personaggio ho scelto
            s.InviaPacchetto("p;" + nome.getText() + ";2");
        } catch (IOException ex) {
            Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (true) {
            SchermataGiocoPesci sc;
            try {
                sc = new SchermataGiocoPesci(s);
                sc.show();
                this.hide();
            } catch (IOException ex) {
                Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_Personaggio2MouseClicked

    private void Personaggio3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_Personaggio3MouseClicked
        // TODO add your handling code here:
        s.playerlocale.setPlayer(nome.getText());
        s.playerlocale.setImg(3);
        if (s.playerospite.getPlayer().equals("")) {
            s.playerlocale.setTurno(true);
            s.playerlocale.setHost(true);
            Condivisa.getInstance().setGio(s.playerlocale);
        }
        try {
            //invio all'altro giocatore quale personaggio ho scelto
            s.InviaPacchetto("p;" + nome.getText() + ";3");
        } catch (IOException ex) {
            Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (true) {
            SchermataGiocoPesci sc;
            try {
                sc = new SchermataGiocoPesci(s);
                sc.show();
                this.hide();
            } catch (IOException ex) {
                Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
            }

        }
    }//GEN-LAST:event_Personaggio3MouseClicked

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
            java.util.logging.Logger.getLogger(SelezionePersonaggio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SelezionePersonaggio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SelezionePersonaggio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SelezionePersonaggio.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new SelezionePersonaggio().setVisible(true);
                } catch (SocketException ex) {
                    Logger.getLogger(SelezionePersonaggio.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Personaggio1;
    private javax.swing.JLabel Personaggio2;
    private javax.swing.JLabel Personaggio3;
    private javax.swing.JLabel Personaggio4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane nome;
    // End of variables declaration//GEN-END:variables
}
