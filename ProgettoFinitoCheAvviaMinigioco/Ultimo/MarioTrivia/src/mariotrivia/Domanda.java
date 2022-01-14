/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mariotrivia;

/**
 *
 * @author Mattia
 */
public class Domanda {

    private String d, r1, r2, r3, r4, c;

    public String getC() {
        return c;
    }

    public void setC(String c) {
        this.c = c;
    }

    public String getD() {
        return d;
    }

    public void setD(String d) {
        this.d = d;
    }

    public String getR1() {
        return r1;
    }

    public void setR1(String r1) {
        this.r1 = r1;
    }

    public String getR2() {
        return r2;
    }

    public void setR2(String r2) {
        this.r2 = r2;
    }

    public String getR3() {
        return r3;
    }

    public void setR3(String r3) {
        this.r3 = r3;
    }

    public String getR4() {
        return r4;
    }

    public void setR4(String r4) {
        this.r4 = r4;
    }

    public String toCSV() {
        String stringa = d + ";" + r1 + ";" + r2 + ";" + r3 + ";" + r4 + ";" + c + ";";
        return stringa;
    }

    public void fromCSV(String stringa) {
        String[] temp = stringa.split(";");
        this.d = temp[0];
        this.r1 = temp[1];
        this.r2 = temp[2];
        this.r3 = temp[3];
        this.r4 = temp[4];
        this.c = temp[5];
    }
}
