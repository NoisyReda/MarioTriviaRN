/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.awt.Image;

/**
 *
 * @author Mattia
 */
public class Giocatore {

    private int punteggio;
    private String player;
    private int img;
    private boolean turno, host;
    
    public Giocatore() {
        punteggio=0;
        player="";
        img=0;
        turno=false;
        host=false;
    }

    public boolean isHost() {
        return host;
    }

    public void setHost(boolean host) {
        this.host = host;
    }

    public void incrementapunteggio(){
        punteggio++;
    }
    
    public boolean isTurno() {
        return turno;
    }

    public void setTurno(boolean turno) {
        this.turno = turno;
    }
        
    public int getPunteggio() {
        return punteggio;
    }

    public void setPunteggio(int punteggio) {
        this.punteggio = punteggio;
    }
    public void aggiungiPunti(int punti){
        this.punteggio+=punti;
    }

    public String getPlayer() {
        return player;
    }

    public void setPlayer(String player) {
        this.player = player;
    }

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    
    
    
}
