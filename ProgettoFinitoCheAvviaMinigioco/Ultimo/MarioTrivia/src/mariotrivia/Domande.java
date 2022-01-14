/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.util.ArrayList;

/**
 *
 * @author Mattia
 */
public class Domande {

    public ArrayList<Domanda> d;

    public Domande() {
        d = new ArrayList<Domanda>();
    }

    public void aggiungiDomanda(Domanda p) {
        d.add(p);
    }
}
