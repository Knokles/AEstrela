package br.com.rota.model;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 17/05/2018
 *
 */
public class Tabuleiro {

    private final int dimensao;
    private Casa tb[][];
    private double custoHorizontal = 10;
    private double custoVertical = 10;
    private double custoDiagonal = 14;
    private Player pl;
    private Objetivo obj;

    public Tabuleiro(int dimensao) {
        this.dimensao = dimensao;

        tb = new Casa[dimensao][dimensao];;
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                Casa tmp = new Casa(i, j);
                tb[i][j] = tmp;
            }
        }
    }

    public int getDimensao() {
        return dimensao;
    }

    public Player getPl() {
        return pl;
    }

    public void setPl(Player pl) {
        this.pl = pl;
    }

    public Objetivo getObj() {
        return obj;
    }

    public void setObj(Objetivo obj) {
        this.obj = obj;
    }

    public Casa[][] getTb() {
        return tb;
    }

    public void setTb(Casa[][] tb) {
        this.tb = tb;
    }

    public void imprime() {
        for (int i = 0; i < dimensao; i++) {
            for (int j = 0; j < dimensao; j++) {
                System.out.print("[");
                System.out.print(tb[i][j].imprimeCord());
                System.out.print("]");
            }
            System.out.println();
        }
    }

    private boolean testaCasa(int x, int y) {
        if ((pl.getCordX() + x) >= dimensao
                || (pl.getCordY() + y) >= dimensao
                || (pl.getCordX() + x) < 0
                || (pl.getCordY() + y) < 0
                || tb[pl.getCordX() + x][pl.getCordY() + y].isBarreira()
                || tb[pl.getCordX() + x][pl.getCordY() + y].isPassou()) {
            return false;
        }
        return true;
    }

    public void calculaProximos() {
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (testaCasa(i, j)) {
                    if ((i == j && i != 0) || (i + 2 == j) || (i - 2 == j)) {
                        tb[pl.getCordX() + i][pl.getCordY() + j].setG(custoDiagonal);

                    } else {
                        tb[pl.getCordX() + i][pl.getCordY() + j].setG(custoHorizontal);
                    }
                    tb[pl.getCordX() + i][pl.getCordY() + j].setH((Math.abs((pl.getCordX() + i) - obj.getCordX()) + Math.abs((pl.getCordY() + j) - obj.getCordY())) * custoVertical);
                    if ((i == j && i == 0)
                            || tb[pl.getCordX() + i][pl.getCordY() + j].isPassou()) {
                        tb[pl.getCordX() + i][pl.getCordY() + j].setG(-1);
                        tb[pl.getCordX() + i][pl.getCordY() + j].setH(-1);
                    }
                    tb[pl.getCordX() + i][pl.getCordY() + j].calcF();
                }
            }
        }
    }

    public void caminha() {
        int x = 0;
        int y = 0;
        double f = 0;
        for (int i = -1; i <= 1; i++) {
            for (int j = -1; j <= 1; j++) {
                if (testaCasa(i, j)) {
                    if (tb[pl.getCordX() + i][pl.getCordY() + j].getF() != -1
                            && (f == 0 || tb[pl.getCordX() + i][pl.getCordY() + j].getF() < f)) {
                        x = pl.getCordX() + i;
                        y = pl.getCordY() + j;
                        f = tb[pl.getCordX() + i][pl.getCordY() + j].getF();
                    }
                }
            }
        }
        if (f != 0) {
            tb[pl.getCordX()][pl.getCordY()].setPassou(true);
            tb[pl.getCordX()][pl.getCordY()].setPlayer(false);
            tb[x][y].setPlayer(true);
            pl.setCordX(x);
            pl.setCordY(y);
        }
    }
}
