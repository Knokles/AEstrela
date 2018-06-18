package br.com.rota.componente;

import br.com.rota.model.Casa;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 17/05/2018
 *
 */
public class BlocoTabuleiro extends JPanel {

    private JLabel g;
    private JLabel h;
    private JLabel f;
    private JLabel pai;
    private BufferedImage img;

    public BlocoTabuleiro(Casa casa) {
        super();

        img = null;
        this.setPreferredSize(new Dimension(90, 90));
        if (casa.isRota()) {
            this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.white, 1), "[" + casa.imprimeCord() + "]"));
        } else {
            this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1), "[" + casa.imprimeCord() + "]"));
        }
        this.setBackground(new Color(0, 200, 0));

        g = new JLabel("");
        if (casa.getG() != -1) {
            g.setText("G = " + Double.toString(casa.getG()));
        }
        g.setFont(new java.awt.Font("Tahoma", 0, 9));
        add(g);

        h = new JLabel("");
        if (casa.getH() != -1) {
            h.setText("H = " + Double.toString(casa.getH()));
        }
        h.setFont(new java.awt.Font("Tahoma", 0, 9));
        add(h);

        f = new JLabel("");
        if (casa.getF() != -1) {
            f.setText("F = " + Double.toString(casa.getF()));
        }
        f.setFont(new java.awt.Font("Tahoma", 0, 9));
        add(f);

        pai = new JLabel("");
        if (casa.getPaiX() != -1 && casa.getPaiY() != -1) {
            this.setBackground(new Color(0, 255, 0));
            pai.setText("Pai [" + casa.imprimePai() + "]");
        }
        pai.setFont(new java.awt.Font("Tahoma", 0, 9));
        add(pai);

    }

    public void setCor(Color cor) {
        this.setBackground(cor);
    }

    public void setPlayer() {
        this.setBackground(new Color(0, 255, 0));
        ocultaVariaveis();
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/player.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBarreira() {
        ocultaVariaveis();
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/barreira.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setObjetivo() {
        ocultaVariaveis();
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/banana.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPassou(int paiX, int paiY) {
        this.setBackground(new Color(0, 255, 0));
        ocultaVariaveis();
        try {
            if (paiX == -1 && paiY == -1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouNoroeste.png"));
            }
            if (paiX == 0 && paiY == -1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouNorte.png"));
            }
            if (paiX == 1 && paiY == -1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouNordeste.png"));
            }
            if (paiX == 1 && paiY == 0) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouLeste.png"));
            }
            if (paiX == -1 && paiY == 0) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouOeste.png"));
            }
            if (paiX == -1 && paiY == 1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouSudoeste.png"));
            }
            if (paiX == 0 && paiY == 1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouSul.png"));
            }
            if (paiX == 1 && paiY == 1) {
                this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passouSudeste.png"));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setStart() {
        this.setBackground(new Color(0, 255, 0));
        ocultaVariaveis();
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/arvore.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPlayerBanana() {
        this.setBackground(new Color(0, 255, 0));
        ocultaVariaveis();
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/macacoBanana.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void ocultaVariaveis() {
        pai.setText("");
        f.setText("");
        g.setText("");
        h.setText("");
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics gr = (Graphics2D) g.create();
        gr.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        gr.dispose();
    }
}
