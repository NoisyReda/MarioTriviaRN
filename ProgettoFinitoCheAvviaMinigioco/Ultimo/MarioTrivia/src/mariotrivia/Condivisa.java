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
    private ScambioMessaggi sc;
    private String mess;

    private Condivisa() {
        gio = new Giocatore();
        time = 0;
        mess = "";
    }

    public synchronized String getMess() {
        return mess;
    }

    public synchronized void setMess(String mess) {
        this.mess = mess;
    }

    public ScambioMessaggi getSc() {
        return sc;
    }

    public void setSc(ScambioMessaggi sc) {
        this.sc = sc;
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
