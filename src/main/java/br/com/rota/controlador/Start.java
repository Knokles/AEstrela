package br.com.rota.controlador;

import br.com.rota.gui.FrameConfig;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 17/05/2018
 *
 */
public class Start {

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                FrameConfig start = new FrameConfig();
                start.setLocationRelativeTo(null);
                start.setVisible(true);
            }
        });
    }
}
