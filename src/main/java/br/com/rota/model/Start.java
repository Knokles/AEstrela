package br.com.rota.model;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 14/06/2018
 *
 */
public class Start {

    private int cordX;
    private int cordY;

    public int getCordX() {
        return cordX;
    }

    public void setCordX(int cordX) {
        this.cordX = cordX;
    }

    public int getCordY() {
        return cordY;
    }

    public void setCordY(int cordY) {
        this.cordY = cordY;
    }

    public void imprime() {
        System.out.println("cordX: " + cordX);
        System.out.println("cordY: " + cordY);
    }
}
