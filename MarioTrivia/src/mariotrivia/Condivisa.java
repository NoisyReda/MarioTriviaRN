package mariotrivia;

import mariotrivia.Giocatore;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Redaelli_Mattia03
 */
public class Condivisa {

    private static Condivisa instance;
    private Giocatore gio;
    private int time;

    private Condivisa() {
        gio = new Giocatore();
        time = 0;
    }

    public Giocatore getGio() {
        return gio;
    }

    public void setGio(Giocatore gio) {
        this.gio = gio;
    }

    public synchronized int tick() {
        return time--;
    }
    
     public synchronized int getTimer() {
        return time;
    }

    public synchronized void setTime(int time) {
        this.time = time;
    }
    
    public static Condivisa getInstance() {
        if (instance == null) {
            return instance = new Condivisa();
        } else {
            return instance;
        }
    }
}
