/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.io.IOException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;

/**
 *
 * @author Mattia
 */
public class SchermataDomande extends javax.swing.JFrame {

    /**
     * Creates new form SchermataDomande
     */
    ScambioMessaggi scambio;
    GestioneDomande g = new GestioneDomande();

    public SchermataDomande() {
        initComponents();
        
    }
    static int int_random;

    public SchermataDomande(ScambioMessaggi s) {
        initComponents();
        ButtonGroup b = new ButtonGroup();
        b.add(Risposta1);
        b.add(Risposta2);
        b.add(Risposta3);
        b.add(Risposta4);
        scambio = s;

        if (scambio.playerlocale.isHost()) {
            Random rand = new Random(); //instance of random class
            int_random = rand.nextInt(11);
            int_random += 1;
            Integer.toString(int_random);
            String str = "D;" + int_random;
            try {
                scambio.InviaPacchetto(str);
            } catch (IOException ex) {
                Logger.getLogger(SchermataGiocoLato.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        new Thread(() -> {
            while (true) {
                if (scambio.g.scelta != 0) {
                    int_random = scambio.g.scelta;
                    break;
                }
            }
        }).start();
        try {
            g.leggi();
        } catch (IOException ex) {
            Logger.getLogger(SchermataDomande.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("random:"+int_random);
        Domanda.setText(g.domande.d.get(int_random).getD());
        Risposta1.setText(g.domande.d.get(int_random).getR1());
        Risposta2.setText(g.domande.d.get(int_random).getR2());
        Risposta3.setText(g.domande.d.get(int_random).getR3());
        Risposta4.setText(g.domande.d.get(int_random).getR4());

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Domanda = new javax.swing.JLabel();
        Risposta1 = new javax.swing.JRadioButton();
        Risposta2 = new javax.swing.JRadioButton();
        Risposta3 = new javax.swing.JRadioButton();
        Risposta4 = new javax.swing.JRadioButton();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Domanda.setText("Domanda:");

        jButton1.setText("Invia Risposta");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Risposta4)
                            .addComponent(Risposta3)
                            .addComponent(Risposta2)
                            .addComponent(Risposta1)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(49, 49, 49)
                        .addComponent(Domanda, javax.swing.GroupLayout.PREFERRED_SIZE, 692, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(48, 48, 48)
                .addComponent(Domanda, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Risposta1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Risposta2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Risposta3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Risposta4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(31, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        int r = Integer.parseInt(g.domande.d.get(int_random).getC());
        boolean corretto = false;
        if (Risposta1.isSelected() && r == 1) {
            corretto = true;
        } else if (Risposta2.isSelected() && r == 2) {
            corretto = true;
        } else if (Risposta3.isSelected() && r == 3) {
            corretto = true;
        } else if (Risposta4.isSelected() && r == 4) {
            corretto = true;
        }

        if (corretto) {
            String str = "R;v";
            try {
                scambio.InviaPacchetto(str);
                scambio.playerlocale.aggiungiPunti(10);
            } catch (IOException ex) {
                Logger.getLogger(SchermataDomande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else{
            try {
                scambio.InviaPacchetto("R;f");
            } catch (IOException ex) {
                Logger.getLogger(SchermataDomande.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(SchermataDomande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SchermataDomande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SchermataDomande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SchermataDomande.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SchermataDomande().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Domanda;
    private javax.swing.JRadioButton Risposta1;
    private javax.swing.JRadioButton Risposta2;
    private javax.swing.JRadioButton Risposta3;
    private javax.swing.JRadioButton Risposta4;
    private javax.swing.JButton jButton1;
    // End of variables declaration//GEN-END:variables
}
