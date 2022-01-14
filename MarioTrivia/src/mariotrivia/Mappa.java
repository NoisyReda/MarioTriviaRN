/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.io.IOException;
import java.net.SocketException;
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

    private int ran, xpersonaggiolocale, ypersonaggiolocale, xpersonaggioospite, ypersonaggioospite;
    private boolean st, beg, discesa, done;
    ScambioMessaggi scambio;

    /**
     * Creates new form Mappa
     */
    public Mappa() {
        initComponents();
        Repaint r = new Repaint(this);
        r.start();
        ran = 0;
        st = false;
        beg = false;
        done = false;
        xpersonaggiolocale = 70;
        ypersonaggiolocale = 50;
        xpersonaggioospite = 70;
        ypersonaggioospite = 90;
        try {
            scambio = new ScambioMessaggi(this);
        } catch (SocketException ex) {
            Logger.getLogger(Mappa.class.getName()).log(Level.SEVERE, null, ex);
        }
        discesa = false;
    }

    public Mappa(ScambioMessaggi s) {
        initComponents();
        Repaint r = new Repaint(this);
        r.start();
        ran = 0;
        st = false;
        scambio = s;
        xpersonaggiolocale = s.playerlocale.getX();
        ypersonaggiolocale = s.playerlocale.getY();
        xpersonaggioospite = s.playerospite.getX();
        ypersonaggioospite = s.playerospite.getY();

    }

    @Override
    public void paint(Graphics g) {
        Image offscreen = createImage(this.getWidth(), this.getHeight());
        Graphics offgc = offscreen.getGraphics();
        offgc.drawImage(new ImageIcon("src\\image\\Mappa.jpeg").getImage(), 0, 0, 1000, 1000, this);
        offgc.drawImage(new ImageIcon("src\\image\\dice.png").getImage(), 450, 130, 130, 130, this);
        if (!beg) {
            if (ypersonaggiolocale > 400 || ypersonaggioospite > 400) {
                ypersonaggiolocale = 400;
                ypersonaggioospite = 430;
            }
            offgc.drawImage(new ImageIcon("src\\image\\" + scambio.playerlocale.getImg() + ".png").getImage(), xpersonaggiolocale, ypersonaggiolocale, 30, 30, this);
            offgc.drawImage(new ImageIcon("src\\image\\" + scambio.playerospite.getImg() + ".png").getImage(), xpersonaggioospite, ypersonaggioospite, 30, 30, this);
        }
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
            beg = false;
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
            pos();
        }
        if (!"".equals(Condivisa.getInstance().getMess())) {
            int man = 0, mosse = 0, disI = 0;
            if (Condivisa.getInstance().getMess().equals("1")) {
                xpersonaggiolocale += 50;
                xpersonaggioospite += 50;
                man = xpersonaggioospite;
            } else if (Condivisa.getInstance().getMess().equals("2")) {
                xpersonaggiolocale += 100;
                xpersonaggioospite += 100;
                man = xpersonaggioospite;
            } else if (Condivisa.getInstance().getMess().equals("3")) {
                xpersonaggiolocale += 150;
                xpersonaggioospite += 150;
                man = xpersonaggioospite;
            } else if (Condivisa.getInstance().getMess().equals("4")) {
                xpersonaggiolocale += 200;
                xpersonaggioospite += 200;
                man = xpersonaggioospite;
            } else if (Condivisa.getInstance().getMess().equals("5")) {
                xpersonaggiolocale += 250;
                xpersonaggioospite += 250;
                man = xpersonaggioospite;
            } else if (Condivisa.getInstance().getMess().equals("6")) {
                xpersonaggiolocale += 300;
                xpersonaggioospite += 300;
                man = xpersonaggioospite;
            }
            if (!done) {
                if (xpersonaggiolocale > 870 && ypersonaggioospite == 50) {
                    disI = 870 - man;
                    mosse = ran - disI / 50;
                    xpersonaggiolocale = 870;
                    ypersonaggiolocale += 50 * mosse;
                    xpersonaggioospite = 870;
                    ypersonaggioospite += 50 * mosse;
                    discesa = true;
                } else if (xpersonaggiolocale >= 870 && ypersonaggioospite > 50) {
                    xpersonaggiolocale = 870;
                    ypersonaggiolocale += 50 * mosse;
                    xpersonaggioospite = 870;
                    ypersonaggioospite += 50 * mosse;
                }
            }
            if (ypersonaggioospite >= 400) {
                done = true;
                switch (ran) {
                    case 1 -> {
                        xpersonaggiolocale -= 50;
                        xpersonaggioospite -= 50;
                    }
                    case 2 -> {
                        xpersonaggiolocale -= 100;
                        xpersonaggioospite -= 100;
                    }
                    case 3 -> {
                        xpersonaggiolocale -= 150;
                        xpersonaggioospite -= 150;
                    }
                    case 4 -> {
                        xpersonaggiolocale -= 200;
                        xpersonaggioospite -= 200;
                    }
                    case 5 -> {
                        xpersonaggiolocale -= 250;
                        xpersonaggioospite -= 250;
                    }
                    case 6 -> {
                        xpersonaggiolocale -= 300;
                        xpersonaggioospite -= 300;
                    }
                }
                if (xpersonaggioospite == 70 && ypersonaggioospite == 400) {
                    this.hide();
                }
            }
            scambio.playerlocale.setTurno(true);
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
        if (SwingUtilities.isLeftMouseButton(evt) && scambio.playerlocale.isTurno()) {
            int x = evt.getX();
            int y = evt.getY();
            int man = 0, mosse = 0, disI = 0;
            if (x > 450 && x < 580 && y > 182 && y < 310) {
                Random i = new Random();
                ran = i.nextInt(7 - 1 + 1) + 1;
                beg = true;
                mosse = ran;
                scambio.playerlocale.setTurno(false);
                if (!discesa) {
                    if (ran == 1) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 50;
                        xpersonaggioospite += 50;
                    } else if (ran == 2) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 100;
                        xpersonaggioospite += 100;
                    } else if (ran == 3) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 150;
                        xpersonaggioospite += 150;
                    } else if (ran == 4) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 200;
                        xpersonaggioospite += 200;
                    } else if (ran == 5) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 250;
                        xpersonaggioospite += 250;
                    } else if (ran == 6) {
                        man = xpersonaggiolocale;
                        xpersonaggiolocale += 300;
                        xpersonaggioospite += 300;
                    }
                }
                if (!done) {
                    if (xpersonaggiolocale > 870 && ypersonaggiolocale == 50) {
                        disI = 870 - man;
                        mosse = ran - disI / 50;
                        xpersonaggiolocale = 870;
                        ypersonaggiolocale += 50 * mosse;
                        xpersonaggioospite = 870;
                        ypersonaggioospite += 50 * mosse;
                        discesa = true;
                    } else if (xpersonaggiolocale >= 870 && ypersonaggiolocale > 50) {
                        xpersonaggiolocale = 870;
                        ypersonaggiolocale += 50 * mosse;
                        xpersonaggioospite = 870;
                        ypersonaggioospite += 50 * mosse;
                    }
                }
                if (ypersonaggiolocale >= 400) {
                    done = true;
                    switch (ran) {
                        case 1 -> {
                            xpersonaggiolocale -= 50;
                            xpersonaggioospite -= 50;
                        }
                        case 2 -> {
                            xpersonaggiolocale -= 100;
                            xpersonaggioospite -= 100;
                        }
                        case 3 -> {
                            xpersonaggiolocale -= 150;
                            xpersonaggioospite -= 150;
                        }
                        case 4 -> {
                            xpersonaggiolocale -= 200;
                            xpersonaggioospite -= 200;
                        }
                        case 5 -> {
                            xpersonaggiolocale -= 250;
                            xpersonaggioospite -= 250;
                        }
                        case 6 -> {
                            xpersonaggiolocale -= 300;
                            xpersonaggioospite -= 300;
                        }
                    }
                }
                if (xpersonaggiolocale == 70 && ypersonaggiolocale == 400) {
                    this.hide();
                }
            }
        }
    }//GEN-LAST:event_formMouseClicked

    private void pos() {
        if (xpersonaggiolocale == 120 && ypersonaggiolocale == 50 || xpersonaggiolocale == 370 && ypersonaggiolocale == 50 || xpersonaggiolocale == 670 && ypersonaggiolocale == 50 || xpersonaggiolocale == 870 && ypersonaggiolocale == 50
                || xpersonaggiolocale == 870 && ypersonaggiolocale == 300 || xpersonaggiolocale == 570 && ypersonaggiolocale == 400 || xpersonaggiolocale == 70 && ypersonaggiolocale == 400) {
            this.hide();
            SchermataDomande sd = new SchermataDomande();
            sd.show();
        }
        if (xpersonaggiolocale == 470 && ypersonaggiolocale == 50 || xpersonaggiolocale == 720 && ypersonaggiolocale == 50 || xpersonaggiolocale == 370 && ypersonaggiolocale == 400 || xpersonaggiolocale == 520 && ypersonaggiolocale == 400
                || xpersonaggiolocale == 720 && ypersonaggiolocale == 400) {
            Random l = new Random();
            switch (l.nextInt(7 - 0 + 1) + 0) {
                case 1 -> {
                    this.hide();
                    SchermataGiocoSpam sc = new SchermataGiocoSpam(Condivisa.getInstance().getSc());
                    sc.show();
                }
                case 2 -> {
                    SchermataGiocoPesci sc;
                    try {
                        sc = new SchermataGiocoPesci(Condivisa.getInstance().getSc());
                        sc.show();
                        this.hide();
                    } catch (IOException ex) {
                        Logger.getLogger(Mappa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case 3 -> {
                    SchermataGiocoLato sc = new SchermataGiocoLato(Condivisa.getInstance().getSc());
                    sc.show();
                    this.hide();
                }
                case 4 -> {
                    Sascarfor scf = new Sascarfor();
                    scf.show();
                    this.hide();
                }
                case 5 -> {
                    ImmagineBlur imb = new ImmagineBlur();
                    imb.show();
                    this.hide();
                }
                case 6 -> {
                    Tris tr = new Tris();
                    tr.show();
                    this.hide();
                }
            }
        }
        if (xpersonaggiolocale == 270 && ypersonaggiolocale == 50 || xpersonaggiolocale == 520 && ypersonaggiolocale == 50 || xpersonaggiolocale == 820 && ypersonaggiolocale == 50 || xpersonaggiolocale == 870 && ypersonaggiolocale == 150
                || xpersonaggiolocale == 820 && ypersonaggiolocale == 400 || xpersonaggiolocale == 170 && ypersonaggiolocale == 400 || xpersonaggiolocale == 420 && ypersonaggiolocale == 400) {
            scambio.playerlocale.aggiungiPunti(10);
        }
        if (xpersonaggiolocale == 170 && ypersonaggiolocale == 50 || xpersonaggiolocale == 420 && ypersonaggiolocale == 50 || xpersonaggiolocale == 820 && ypersonaggiolocale == 50 || xpersonaggiolocale == 870 && ypersonaggiolocale == 100
                || xpersonaggiolocale == 870 && ypersonaggiolocale == 350 || xpersonaggiolocale == 320 && ypersonaggiolocale == 400 || xpersonaggiolocale == 770 && ypersonaggiolocale == 400) {
            scambio.playerlocale.setPunteggio(scambio.playerlocale.getPunteggio() - 10);
        }
        if (xpersonaggiolocale == 370 && ypersonaggiolocale == 50 || xpersonaggiolocale == 770 && ypersonaggiolocale == 50 || xpersonaggiolocale == 870 && ypersonaggiolocale == 400
                || xpersonaggiolocale == 320 && ypersonaggiolocale == 400 || xpersonaggiolocale == 670 && ypersonaggiolocale == 400) {
            scambio.playerlocale.setTurno(false);
        }
        if (xpersonaggioospite == 120 && ypersonaggioospite == 50 || xpersonaggioospite == 370 && ypersonaggioospite == 50 || xpersonaggioospite == 670 && ypersonaggioospite == 50 || xpersonaggioospite == 870 && ypersonaggioospite == 50
                || xpersonaggioospite == 870 && ypersonaggioospite == 300 || xpersonaggioospite == 570 && ypersonaggioospite == 400 || xpersonaggioospite == 70 && ypersonaggioospite == 400) {
            this.hide();
            SchermataDomande sd = new SchermataDomande();
            sd.show();
        }
        if (xpersonaggioospite == 470 && ypersonaggioospite == 50 || xpersonaggioospite == 720 && ypersonaggioospite == 50 || xpersonaggioospite == 370 && ypersonaggioospite == 400 || xpersonaggioospite == 520 && ypersonaggioospite == 400
                || xpersonaggioospite == 720 && ypersonaggioospite == 400) {
            Random l = new Random();
            switch (l.nextInt(7 - 0 + 1) + 0) {
                case 1 -> {
                    this.hide();
                    SchermataGiocoSpam sc = new SchermataGiocoSpam(Condivisa.getInstance().getSc());
                    sc.show();
                }
                case 2 -> {
                    SchermataGiocoPesci sc;
                    try {
                        sc = new SchermataGiocoPesci(Condivisa.getInstance().getSc());
                        sc.show();
                        this.hide();
                    } catch (IOException ex) {
                        Logger.getLogger(Mappa.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

                case 3 -> {
                    SchermataGiocoLato sc = new SchermataGiocoLato(Condivisa.getInstance().getSc());
                    sc.show();
                    this.hide();
                }
                case 4 -> {
                    Sascarfor scf = new Sascarfor();
                    scf.show();
                    this.hide();
                }
                case 5 -> {
                    ImmagineBlur imb = new ImmagineBlur();
                    imb.show();
                    this.hide();
                }
                case 6 -> {
                    Tris tr = new Tris();
                    tr.show();
                    this.hide();
                }
            }
        }
        if (xpersonaggioospite == 270 && ypersonaggioospite == 50 || xpersonaggioospite == 520 && ypersonaggioospite == 50 || xpersonaggioospite == 820 && ypersonaggioospite == 50 || xpersonaggioospite == 870 && ypersonaggioospite == 150
                || xpersonaggioospite == 820 && ypersonaggioospite == 400 || xpersonaggioospite == 170 && ypersonaggioospite == 400 || xpersonaggioospite == 420 && ypersonaggioospite == 400) {
            scambio.playerlocale.aggiungiPunti(10);
        }
        if (xpersonaggioospite == 120 && ypersonaggioospite == 50 || xpersonaggioospite == 420 && ypersonaggioospite == 50 || xpersonaggioospite == 820 && ypersonaggioospite == 50 || xpersonaggioospite == 870 && ypersonaggioospite == 100
                || xpersonaggioospite == 870 && ypersonaggioospite == 350 || xpersonaggioospite == 320 && ypersonaggioospite == 400 || xpersonaggioospite == 770 && ypersonaggioospite == 400) {
            scambio.playerlocale.setPunteggio(scambio.playerlocale.getPunteggio() - 10);
        }
        if (xpersonaggioospite == 370 && ypersonaggioospite == 50 || xpersonaggioospite == 770 && ypersonaggioospite == 50 || xpersonaggioospite == 870 && ypersonaggioospite == 400
                || xpersonaggioospite == 320 && ypersonaggioospite == 400 || xpersonaggioospite == 670 && ypersonaggioospite == 400) {
            scambio.playerlocale.setTurno(true);
        }
    }

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
