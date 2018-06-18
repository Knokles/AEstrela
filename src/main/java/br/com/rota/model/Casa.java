package br.com.rota.model;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 17/05/2018
 *
 */
public class Casa {

    private double g;
    private double h;
    private double f;
    private boolean player;
    private boolean objetivo;
    private boolean passou;
    private boolean barreira;
    private boolean start;
    private boolean rota;
    private final int cordX;
    private final int cordY;
    private int paiX;
    private int paiY;

    public Casa(int cordX, int cordY) {
        this.cordX = cordX;
        this.cordY = cordY;
        this.g = -1;
        this.h = -1;
        this.f = -1;
        this.paiX = -1;
        this.paiY = -1;
        this.rota = false;
    }

    public double getG() {
        return g;
    }

    public void setG(double g) {
        this.g = g;
    }

    public double getH() {
        return h;
    }

    public void setH(double h) {
        this.h = h;
    }

    public double getF() {
        return f;
    }

    public void calcF() {
        f = g + h;
        if (f < 0) {
            f = -1;
        }
    }

    public boolean isPlayer() {
        return player;
    }

    public void setPlayer(boolean player) {
        this.player = player;
    }

    public boolean isObjetivo() {
        return objetivo;
    }

    public void setObjetivo(boolean objetivo) {
        this.objetivo = objetivo;
    }

    public boolean isPassou() {
        return passou;
    }

    public void setPassou(boolean passou) {
        this.passou = passou;
    }

    public boolean isBarreira() {
        return barreira;
    }

    public void setBarreira(boolean barreira) {
        this.barreira = barreira;
    }

    public boolean isStart() {
        return start;
    }

    public void setStart(boolean start) {
        this.start = start;
    }

    public int getCordX() {
        return cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public int getPaiX() {
        return paiX;
    }

    public void setPaiX(int paiX) {
        this.paiX = paiX;
    }

    public int getPaiY() {
        return paiY;
    }

    public void setPaiY(int paiY) {
        this.paiY = paiY;
    }

    public boolean isRota() {
        return rota;
    }

    public void setRota(boolean rota) {
        this.rota = rota;
    }

    public String imprimeCord() {
        return cordX + "," + cordY;
    }

    public String imprimePai() {
        return paiX + "," + paiY;
    }
}
