/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Mattia
 */
public class GestioneDomande {

    Domande domande = new Domande();
    int scelta=0;

    public void leggi() throws FileNotFoundException, IOException {
        String percorso = "src/Domande.txt";
        FileReader fr = new FileReader(percorso);
        BufferedReader br = new BufferedReader(fr);

        String linea;
        while ((linea = br.readLine()) != null) {
            Domanda domanda = new Domanda();
            domanda.fromCSV(linea);
            domande.aggiungiDomanda(domanda);
        }
    }
}
