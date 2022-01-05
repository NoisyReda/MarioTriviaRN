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
    int porta = 12346;
    JFrame frame = new JFrame();
    int stato = 0;
    InetAddress ipdestinazione;
    Giocatore playerospite, playerlocale;

    public ScambioMessaggi() throws SocketException {
        server = new DatagramSocket(12345);
        client = new DatagramSocket();
        connesso = false;
        playerospite = new Giocatore();
        playerlocale = new Giocatore();

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
                //ControllaY(mess, p);
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
        }
    }

    public void Apertura(String m, DatagramPacket p) throws IOException {

        System.out.println("Ricevo Richiesta Di Connessione");
        String str = "";
        int name = JOptionPane.showConfirmDialog(null, "Accetti?", "", JOptionPane.YES_NO_OPTION);
        if (name == JOptionPane.YES_OPTION) {
            str = "y;" + name + ";";
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

    public void ControllaY(String m, DatagramPacket p, JFrame f) throws IOException {

        if (m.length() > 2 && stato == 0) {
            System.out.println("Ricevo Riscontro Y;NomeDestinatario");
            InviaPacchetto("y;", p.getAddress());
            stato = 1;
            ipdestinazione = p.getAddress();
        } else if (stato == 1) {
        System.out.println("Apro Ufficialmente la Comunicazione");
        connesso = true;
        SelezionePersonaggio s = new SelezionePersonaggio(this);
        s.show();
        f.hide();
       }

    }

    public void ConnessioneRifiutata() {
        stato = 0;
        connesso = false;

    }

    public void ApriConnessione(InetAddress i, JFrame f) throws IOException {
        System.out.println("Invio Messaggio Per Richiesta Connessione");
        String str = "a;";
        InviaPacchetto(str, i);
        frame = f;
    }

    public void Scrivi(String m) throws IOException {

        InviaPacchetto("m;" + m, ipdestinazione);
    }

    public void Chiudi() throws IOException {
        JOptionPane.showMessageDialog(null, "Disconnesso");
        ipdestinazione = null;
        connesso = false;
        stato = 0;
    }

    public void Disconnetti() throws IOException {
        InviaPacchetto("c", ipdestinazione);
        ipdestinazione = null;
        connesso = false;
        stato = 0;
    }

    public void InviaPacchetto(String messaggio, InetAddress indirizzo) throws IOException {
        byte[] buffer = messaggio.getBytes();
        DatagramPacket p = new DatagramPacket(buffer, buffer.length);
        p.setAddress(indirizzo);
        p.setPort(porta);
        client.send(p);
    }

    public void Fasepick(String messaggio) {
        //split del messaggio e assegnamento valori agli attributi del player ospite
        String[] vett = messaggio.split(";");
        playerospite.setPlayer(vett[1]);
        if (vett[2] == "1") {
            playerospite.setImg(1);
        } else if (vett[2] == "2") {
            playerospite.setImg(2);
        } else if (vett[2] == "3") {
            playerospite.setImg(3);
        } else if (vett[2] == "4") {
            playerospite.setImg(4);
        }

        //nel caso in cui l'ospte ha scelto per primo il personaggio sarà il primo a giocare
        if (playerlocale.getPlayer() == "") {
            playerospite.setTurno(true);
        }

    }

    public void Spostamento() {

    }

}
