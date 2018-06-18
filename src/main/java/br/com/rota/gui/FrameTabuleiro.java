package br.com.rota.gui;

import br.com.rota.componente.BlocoTabuleiro;
import br.com.rota.model.Tabuleiro;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JOptionPane;

/**
 *
 * @author Dionathan Luan de Vargas
 * @since 17/05/2018
 *
 */
public class FrameTabuleiro extends javax.swing.JFrame {

    private Tabuleiro tabuleiro;
    private BlocoTabuleiro blTabuleiro[][];
    private int estado = 0; //0 - prepara 1 - calcula 2 - move 3 - finaliza

    public FrameTabuleiro(Tabuleiro tabuleiro) {
        initComponents();

        jtaLog.setText(" ====================");

        this.tabuleiro = tabuleiro;

        txfCordPlayerX.setText(Integer.toString(tabuleiro.getPl().getCordX()));
        txfCordPlayerY.setText(Integer.toString(tabuleiro.getPl().getCordY()));
        this.tabuleiro.getTb()[tabuleiro.getPl().getCordX()][tabuleiro.getPl().getCordY()].setPlayer(true);

        txfCordStartX.setText(Integer.toString(tabuleiro.getPl().getCordX()));
        txfCordStartY.setText(Integer.toString(tabuleiro.getPl().getCordY()));
        this.tabuleiro.getTb()[tabuleiro.getPl().getCordX()][tabuleiro.getPl().getCordY()].setStart(true);

        txfCordObjetivoX.setText(Integer.toString(tabuleiro.getObj().getCordX()));
        txfCordObjetivoY.setText(Integer.toString(tabuleiro.getObj().getCordY()));
        this.tabuleiro.getTb()[tabuleiro.getObj().getCordX()][tabuleiro.getObj().getCordY()].setObjetivo(true);

        blTabuleiro = new BlocoTabuleiro[tabuleiro.getDimensao()][tabuleiro.getDimensao()];
        jpTabuleiro.setLayout(new GridLayout(tabuleiro.getDimensao(), tabuleiro.getDimensao()));
        jpTabuleiro.setSize(new Dimension(517, 517));

        addLog("Tabuleiro: " + tabuleiro.getDimensao() + "x" + tabuleiro.getDimensao());

        for (int j = 0; j < tabuleiro.getDimensao(); j++) {
            for (int i = 0; i < tabuleiro.getDimensao(); i++) {
                blTabuleiro[i][j] = new BlocoTabuleiro(tabuleiro.getTb()[i][j]);
                if (tabuleiro.getTb()[i][j].isPlayer()) {
                    addLog("Personagem [" + i + "," + j + "]");
                    blTabuleiro[i][j].setPlayer();
                }
                if (tabuleiro.getTb()[i][j].isObjetivo()) {
                    addLog("Objetivo [" + i + "," + j + "]");
                    blTabuleiro[i][j].setObjetivo();
                }
                jpTabuleiro.add(blTabuleiro[i][j]);
            }
        }

        addLog("====================");
    }

    public void atualizaFrameTabuleiro() {

        txfCordPlayerX.setText(Integer.toString(tabuleiro.getPl().getCordX()));
        txfCordPlayerY.setText(Integer.toString(tabuleiro.getPl().getCordY()));
        tabuleiro.getTb()[tabuleiro.getPl().getCordX()][tabuleiro.getPl().getCordY()].setPlayer(true);

        jpTabuleiro.removeAll();

        for (int j = 0; j < tabuleiro.getDimensao(); j++) {
            for (int i = 0; i < tabuleiro.getDimensao(); i++) {
                blTabuleiro[i][j] = new BlocoTabuleiro(tabuleiro.getTb()[i][j]);
                if (tabuleiro.getTb()[i][j].isPassou()) {
                    blTabuleiro[i][j].setPassou(i - tabuleiro.getTb()[i][j].getPaiX(), j - tabuleiro.getTb()[i][j].getPaiY());
                }
                if (tabuleiro.getTb()[i][j].isStart()) {
                    blTabuleiro[i][j].setStart();
                }
                if (tabuleiro.getTb()[i][j].isPlayer()) {
                    blTabuleiro[i][j].setPlayer();
                }
                if (tabuleiro.getTb()[i][j].isObjetivo()) {
                    blTabuleiro[i][j].setObjetivo();
                }
                if (tabuleiro.getTb()[i][j].isBarreira()) {
                    blTabuleiro[i][j].setBarreira();
                }
                if (tabuleiro.getTb()[i][j].isPlayer() && tabuleiro.getTb()[i][j].isObjetivo()) {
                    blTabuleiro[i][j].setPlayerBanana();
                }
                jpTabuleiro.add(blTabuleiro[i][j]);
            }
        }
        jspTabuleiro.validate();
        jspTabuleiro.repaint();
    }

    private void addLog(String log) {
        jtaLog.setText(jtaLog.getText() + "\n " + log);
    }

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txfCordPlayerX = new javax.swing.JTextField();
        txfCordPlayerY = new javax.swing.JTextField();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txfCordObjetivoX = new javax.swing.JTextField();
        txfCordObjetivoY = new javax.swing.JTextField();
        jspTabuleiro = new javax.swing.JScrollPane();
        jpTabuleiro = new javax.swing.JPanel();
        btnStart = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtaLog = new javax.swing.JTextArea();
        jPanel3 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txfNBarreiraX = new javax.swing.JTextField();
        txfNBarreiraY = new javax.swing.JTextField();
        btnSetBarreira = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txfCordStartX = new javax.swing.JTextField();
        txfCordStartY = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Player"));

        jLabel1.setText("X");

        jLabel2.setText("Y");

        txfCordPlayerX.setEditable(false);

        txfCordPlayerY.setEditable(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordPlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordPlayerY, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1)
                .addComponent(txfCordPlayerX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txfCordPlayerY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(jLabel2))
        );

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder("Objetivo"));

        jLabel3.setText("X");

        jLabel4.setText("Y");

        txfCordObjetivoX.setEditable(false);

        txfCordObjetivoY.setEditable(false);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordObjetivoX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordObjetivoY, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel3)
                .addComponent(jLabel4)
                .addComponent(txfCordObjetivoX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txfCordObjetivoY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout jpTabuleiroLayout = new javax.swing.GroupLayout(jpTabuleiro);
        jpTabuleiro.setLayout(jpTabuleiroLayout);
        jpTabuleiroLayout.setHorizontalGroup(
            jpTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 592, Short.MAX_VALUE)
        );
        jpTabuleiroLayout.setVerticalGroup(
            jpTabuleiroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 633, Short.MAX_VALUE)
        );

        jspTabuleiro.setViewportView(jpTabuleiro);

        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        jtaLog.setEditable(false);
        jtaLog.setBackground(new java.awt.Color(0, 0, 0));
        jtaLog.setColumns(20);
        jtaLog.setFont(new java.awt.Font("MS Gothic", 1, 13)); // NOI18N
        jtaLog.setForeground(new java.awt.Color(0, 204, 0));
        jtaLog.setRows(5);
        jScrollPane1.setViewportView(jtaLog);

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder("Nova Barreira"));

        jLabel5.setText("X");

        jLabel6.setText("Y");

        btnSetBarreira.setText("Setar Barreiras");
        btnSetBarreira.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSetBarreiraActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(txfNBarreiraX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfNBarreiraY, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(btnSetBarreira))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel5)
                .addComponent(jLabel6)
                .addComponent(txfNBarreiraX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txfNBarreiraY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(btnSetBarreira))
        );

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder("Start"));

        jLabel7.setText("X");

        jLabel8.setText("Y");

        txfCordStartX.setEditable(false);

        txfCordStartY.setEditable(false);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordStartX, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel8)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txfCordStartY, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel7)
                .addComponent(jLabel8)
                .addComponent(txfCordStartX, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addComponent(txfCordStartY, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jspTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart))
                    .addComponent(jspTabuleiro, javax.swing.GroupLayout.DEFAULT_SIZE, 652, Short.MAX_VALUE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSetBarreiraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSetBarreiraActionPerformed
        if (txfNBarreiraX.getText().isEmpty() || txfNBarreiraY.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha todos os campos de barreira");
        } else {

            int cordX = Integer.parseInt(txfNBarreiraX.getText());
            int cordY = Integer.parseInt(txfNBarreiraY.getText());

            if (cordX >= tabuleiro.getDimensao() || cordY >= tabuleiro.getDimensao()) {
                JOptionPane.showMessageDialog(this, "Dimenssões fora do tamanho do tabuleiro");
            } else {

                txfNBarreiraX.setText("");
                txfNBarreiraY.setText("");

                tabuleiro.getTb()[cordX][cordY].setBarreira(true);
                addLog("Barreira [" + cordX + "," + cordY + "]");
                atualizaFrameTabuleiro();
            }
        }
    }//GEN-LAST:event_btnSetBarreiraActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        int x = tabuleiro.getPl().getCordX();
        int y = tabuleiro.getPl().getCordY();

        switch (estado) {
            case 0:
                btnSetBarreira.setEnabled(false);
                txfNBarreiraX.setEnabled(false);
                txfNBarreiraY.setEnabled(false);

                addLog("====================");
            case 1:
                tabuleiro.calculaProximos();
                addLog("Calculando próximo passo...");
                btnStart.setText("Move");
                estado = 2;
                break;
            case 2:
                addLog("Caminhando...");
                tabuleiro.caminha();
                if (x == tabuleiro.getPl().getCordX() && y == tabuleiro.getPl().getCordY()) {
                    estado = 3;
                    addLog("O macaco não cosnseguiu");
                    addLog("encontrar a banana");
                    btnStart.setText("Finalizar");
                } else if (tabuleiro.getPl().getCordX() == tabuleiro.getObj().getCordX()
                        && tabuleiro.getPl().getCordY() == tabuleiro.getObj().getCordY()) {
                    estado = 3;
                    addLog("O macaco encontrou a banana");
                    btnStart.setText("Finalizar");
                    //Atualiza lista de casas até o objetivo
                    int cordX = tabuleiro.getObj().getCordX();
                    int cordY = tabuleiro.getObj().getCordY();
                    tabuleiro.getTb()[cordX][cordY].setRota(true);
                    
                    do{
                        
                        int tmpX = tabuleiro.getTb()[cordX][cordY].getPaiX();
                        int tmpY = tabuleiro.getTb()[cordX][cordY].getPaiY();
                        
                        cordX = tmpX;
                        cordY = tmpY;
                        
                        tabuleiro.getTb()[cordX][cordY].setRota(true);
                        
                    }while(!tabuleiro.getTb()[cordX][cordY].isStart());
                    
                    
                } else {
                    btnStart.setText("Calcula");
                    addLog("O macaco se moveu para");
                    addLog("[" + tabuleiro.getPl().getCordX() + "," + tabuleiro.getPl().getCordY() + "]");
                    estado = 1;
                }
                addLog("====================");
                break;
            case 3:
                FrameConfig fConfig = new FrameConfig();
                fConfig.setLocationRelativeTo(null);
                fConfig.setVisible(true);
                setVisible(false);
        }
        atualizaFrameTabuleiro();
    }//GEN-LAST:event_btnStartActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnSetBarreira;
    private javax.swing.JButton btnStart;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JPanel jpTabuleiro;
    private javax.swing.JScrollPane jspTabuleiro;
    private javax.swing.JTextArea jtaLog;
    private javax.swing.JTextField txfCordObjetivoX;
    private javax.swing.JTextField txfCordObjetivoY;
    private javax.swing.JTextField txfCordPlayerX;
    private javax.swing.JTextField txfCordPlayerY;
    private javax.swing.JTextField txfCordStartX;
    private javax.swing.JTextField txfCordStartY;
    private javax.swing.JTextField txfNBarreiraX;
    private javax.swing.JTextField txfNBarreiraY;
    // End of variables declaration//GEN-END:variables
}
