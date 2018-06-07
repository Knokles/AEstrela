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
    private BufferedImage img;

    public BlocoTabuleiro(Casa casa) {
        super();

        img = null;
        this.setPreferredSize(new Dimension(75, 75));
        this.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(Color.black, 1), "[" + casa.imprimeCord() + "]"));
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
            this.setBackground(new Color(0, 255, 0));
            f.setText("F = " + Double.toString(casa.getF()));
        }
        f.setFont(new java.awt.Font("Tahoma", 0, 9));
        add(f);

    }

    public void setCor(Color cor) {
        this.setBackground(cor);
    }

    public void setPlayer() {
        this.setBackground(new Color(0, 255, 0));
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/player.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setBarreira() {
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/barreira.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setObjetivo() {
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/banana.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPassou() {
        this.setBackground(new Color(0, 255, 0));
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/passou.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public void setPlayerBanana() {
        this.setBackground(new Color(0, 255, 0));
        try {
            this.img = ImageIO.read(new File("src/main/java/br/com/rota/componente/macacoBanana.png"));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics gr = (Graphics2D) g.create();
        gr.drawImage(img, 0, 0, this.getWidth(), this.getHeight(), this);
        gr.dispose();
    }
}
