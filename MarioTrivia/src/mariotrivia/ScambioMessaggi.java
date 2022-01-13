/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Mattia
 */
public class ScambioMessaggi extends Thread {

    DatagramSocket server, client;
    boolean connesso;
    int porta = 12345;
    JFrame frame = new JFrame();
    int stato = 0;
    InetAddress ipdestinazione;
    Giocatore playerospite, playerlocale;
    int spostamento = 0;
    GiocoPesci p;
    GiocoLato l;

    public ScambioMessaggi(JFrame f) throws SocketException {
        server = new DatagramSocket(12346);
        client = new DatagramSocket();
        connesso = false;
        playerospite = new Giocatore();
        playerlocale = new Giocatore();
        frame = f;
        p = new GiocoPesci();
        l = new GiocoLato();
    }

    @Override
    public void run() {
        while (true) {
            byte[] buffer = new byte[1500];
            DatagramPacket Packet = new DatagramPacket(buffer, buffer.length);
            try {
                server.receive(Packet);
            } catch (IOException ex) {
                Logger.getLogger(ScambioMessaggi.class.getName()).log(Level.SEVERE, null, ex);
            }
            String messaggio = new String(Packet.getData()).trim();
            System.out.println(messaggio);
            try {
                Elabora(messaggio, Packet);
            } catch (IOException ex) {
                Logger.getLogger(ScambioMessaggi.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Elabora(String mess, DatagramPacket p) throws IOException {
        switch (mess.substring(0, 1)) {
            case "a":
                Apertura(mess, p);
                break;
            case "y":
                ControllaY(mess, p);
                break;
            case "n":
                ConnessioneRifiutata();
                break;
            case "c":
                Chiudi();
                break;
            //fase di pick
            case "p":
                Fasepick(mess);
                break;
            case "s":
                Spostamento();
                break;
            case "M":
                GiocoMelanzane(mess);
                break;
            case "P":
                GiocoPesci(mess);
                break;
            case "E":
                SceltaPesce(mess);
                break;
            case "e":
                PersoPesce(mess);
                break;
            case "L":
                ElencoLato(mess);
                break;
            case "l":
                AggiornaPuntiAvversario(mess);
                break;
        }
    }

    public void Apertura(String m, DatagramPacket p) throws IOException {

        String str = "";
        int name = JOptionPane.showConfirmDialog(null, "Accetti?", "", JOptionPane.YES_NO_OPTION);
        if (name == JOptionPane.YES_OPTION) {
            str = "y;.";
            byte[] buffer = str.getBytes();
            DatagramPacket Packet = new DatagramPacket(buffer, buffer.length);
            InetAddress indirizzo;
            indirizzo = p.getAddress();
            Packet.setAddress(indirizzo);
            Packet.setPort(porta);
            client.send(Packet);
            stato = 1;
            ipdestinazione = p.getAddress();
        } else {
            str = "n";
            byte[] buffer = str.getBytes();
            DatagramPacket Packet = new DatagramPacket(buffer, buffer.length);
            InetAddress indirizzo;
            indirizzo = p.getAddress();
            Packet.setAddress(indirizzo);
            Packet.setPort(porta);
            client.send(Packet);
        }
    }

    public void ControllaY(String m, DatagramPacket p) throws IOException {
        SelezionePersonaggio s = new SelezionePersonaggio(this);
        if (m.length() > 2 && stato == 0) {
            InviaPacchetto("y;");
            stato = 1;
            ipdestinazione = p.getAddress();
            s.show();
            frame.hide();
        } else if (stato == 1) {
            connesso = true;
            s.show();
            frame.hide();
        }

    }

    public void ConnessioneRifiutata() {
        stato = 0;
        connesso = false;

    }

    public void ApriConnessione(InetAddress i) throws IOException {
        String str = "a;";
        ipdestinazione = i;
        InviaPacchetto(str);
    }

    public void Scrivi(String m) throws IOException {
        InviaPacchetto(m);
    }

    public void Chiudi() throws IOException {
        JOptionPane.showMessageDialog(null, "Disconnesso");
        ipdestinazione = null;
        connesso = false;
        stato = 0;
    }

    public void Disconnetti() throws IOException {
        InviaPacchetto("c");
        ipdestinazione = null;
        connesso = false;
        stato = 0;
    }

    public void InviaPacchetto(String messaggio) throws IOException {
        byte[] buffer = messaggio.getBytes();
        DatagramPacket p = new DatagramPacket(buffer, buffer.length);
        p.setAddress(ipdestinazione);
        p.setPort(porta);
        client.send(p);
    }

    public void Fasepick(String messaggio) {
        //split del messaggio e assegnamento valori agli attributi del player ospite
        String[] vett = messaggio.split(";");
        playerospite.setPlayer(vett[1]);
        if (vett[2].equals("1")) {
            playerospite.setImg(1);
        } else if (vett[2].equals("2")) {
            playerospite.setImg(2);
        } else if (vett[2].equals("3")) {
            playerospite.setImg(3);
        } else if (vett[2].equals("4")) {
            playerospite.setImg(4);
        }

        //nel caso in cui l'ospte ha scelto per primo il personaggio sarà il primo a giocare
        if (playerlocale.getPlayer().equals("")) {
            playerospite.setTurno(true);
            playerospite.setHost(true);
        }

    }

    public void Spostamento() {

    }

    public void GiocoMelanzane(String m) {
        String s = m.substring(2);
        if (s.equals("avanti")) {
            spostamento += 10;
        }
    }

    public void GiocoPesci(String m) {
        String vett = m.substring(2);
        ArrayList<String> l = new ArrayList<String>(Arrays.asList(vett.split(";")));
        p.v = l;
    }

    public void SceltaPesce(String m) {
        String[] vett = m.split(";");
        p.scelta = Integer.parseInt(vett[1]);
        playerlocale.setTurno(true);
    }

    private void PersoPesce(String mess) {
        String[] vett = mess.split(";");
        if (vett[1].equals("perso")) {
            p.finito = true;
        }
    }

    private void ElencoLato(String mess) {
        String vett = mess.substring(2);
        ArrayList<String> v = new ArrayList<String>(Arrays.asList(vett.split(";")));
        l.v = v;
    }

    private void AggiornaPuntiAvversario(String mess) {
        String[] vett = mess.split(";");
        playerospite.setPunteggio(Integer.parseInt(vett[1]));
    }
}
