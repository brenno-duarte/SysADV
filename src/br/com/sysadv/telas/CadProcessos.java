/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.sysadv.telas;

import br.com.sysadv.dal.Conexao;
import java.sql.*;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author brenno
 */
public class CadProcessos extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form CadProcessos
     */
    public CadProcessos() {
        initComponents();
        conexao = Conexao.Conectar();
        this.mudarCbCli();
        pesqPro();
    }

    public void tabelaProcessos() {
        int setar = tbPro.getSelectedRow();
        txtIdCli.setText(tbPro.getModel().getValueAt(setar, 0).toString());
        cbNomeCli.setSelectedItem(tbPro.getModel().getValueAt(setar, 1).toString());
        txtNumPro.setText(tbPro.getModel().getValueAt(setar, 2).toString());
        cbSituacaoCli.setSelectedItem(tbPro.getModel().getValueAt(setar, 3).toString());
        cbTipoAcaoPro.setSelectedItem(tbPro.getModel().getValueAt(setar, 4).toString());
        cbNatAcaoPro.setSelectedItem(tbPro.getModel().getValueAt(setar, 5).toString());
        cbSituacaoPro.setSelectedItem(tbPro.getModel().getValueAt(setar, 6).toString());
        txtHonorarios.setText(tbPro.getModel().getValueAt(setar, 7).toString());
        btnCadPro.setEnabled(false);

    }

    public void limparCampos() {
        txtIdCli.setText(null);
        txtNumPro.setText(null);
        txtHonorarios.setText(null);
        btnCadPro.setEnabled(true);
    }

    public void mudarCbCli() {
        String sql = "select nomeCli from tb_clientes";
        try {
            pst = conexao.prepareStatement(sql);
            rs = pst.executeQuery();
            while (rs.next()) {
                cbNomeCli.addItem(rs.getString("nomeCli"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void pesqPro() {
        String sql = "select a.idpro as ID, b.nomeCli,a.numPro as N_do_Pro, a.situacaoCli as Situacao, a.tipoAcao as Tipo_Acao, a.naturezaAcao as Natureza_Acao, a.situacaoPro as Situacao_Pro, a.honorarios as Honorarios from tb_processos a inner join tb_clientes b on a.idcli = b.idcli where nomeCli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesqPro.getText() + "%");
            rs = pst.executeQuery();
            tbPro.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cadastrarPro() {
        String sql = "insert into tb_processos (numPro,situacaoCli,tipoAcao,naturezaAcao,situacaoPro,honorarios,idcli) values (?,?,?,?,?,?,?);";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNumPro.getText());
            pst.setString(2, cbSituacaoCli.getSelectedItem().toString());
            pst.setString(3, cbTipoAcaoPro.getSelectedItem().toString());
            pst.setString(4, cbNatAcaoPro.getSelectedItem().toString());
            pst.setString(5, cbSituacaoPro.getSelectedItem().toString());
            pst.setString(6, txtHonorarios.getText());
            pst.setString(7, txtIdCli.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Processo cadastrado com sucesso!");
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarPro() {
        String sql = "update tb_processos set numPro=?,situacaoCli=?,tipoAcao=?,naturezaAcao=?,situacaoPro=?,honorarios=? where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNumPro.getText());
            pst.setString(2, cbSituacaoCli.getSelectedItem().toString());
            pst.setString(3, cbTipoAcaoPro.getSelectedItem().toString());
            pst.setString(4, cbNatAcaoPro.getSelectedItem().toString());
            pst.setString(5, cbSituacaoPro.getSelectedItem().toString());
            pst.setString(6, txtHonorarios.getText());
            pst.setString(7, txtIdCli.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Processo alterado com sucesso!");
            txtIdCli.setText(null);
            cbNomeCli.setSelectedItem("Selecione o cliente");
            cbSituacaoCli.setSelectedItem("Selecione a situação do cliente");
            cbTipoAcaoPro.setSelectedItem("Selecione o tipo de ação");
            cbNatAcaoPro.setSelectedItem("Selecione a natureza da ação");
            cbSituacaoPro.setSelectedItem("Selecione a situação do processo");
            txtNumPro.setText(null);
            txtHonorarios.setText(null);
            btnCadPro.setEnabled(true);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        cbSituacaoPro = new javax.swing.JComboBox<>();
        btnEditarPro = new javax.swing.JButton();
        cbTipoAcaoPro = new javax.swing.JComboBox<>();
        btnLimparCampos = new javax.swing.JButton();
        txtHonorarios = new javax.swing.JTextField();
        cbSituacaoCli = new javax.swing.JComboBox<>();
        cbNatAcaoPro = new javax.swing.JComboBox<>();
        jLabel13 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtNumPro = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        btnCadPro = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbPro = new javax.swing.JTable();
        cbNomeCli = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        txtPesqPro = new javax.swing.JTextField();
        btnExcluirPro1 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();

        setBackground(new java.awt.Color(38, 123, 249));
        setClosable(true);
        setTitle("Processos");

        jPanel1.setBackground(java.awt.Color.white);

        cbSituacaoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a situação do processo", "1° instância", "2° instância", "3° instância", "Arquivado/Finalizado" }));

        btnEditarPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Document Edit.png"))); // NOI18N
        btnEditarPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarProActionPerformed(evt);
            }
        });

        cbTipoAcaoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o tipo de ação", "Administrativo", "Cível", "Criminal", "Família", "Previdência", "Trabalhista", "Tributário" }));

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Symbol - Remove.png"))); // NOI18N
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        cbSituacaoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a situação do cliente", "Réu", "Autor" }));

        cbNatAcaoPro.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione a natureza da ação", "Aberto", "Cancelado", "Finalizado" }));

        jLabel13.setText("Honorários");

        jLabel4.setText("Natureza da ação");

        jLabel11.setText("Situação do processo");

        jLabel2.setText("N° do processo");

        jLabel6.setText("Tipo de ação");

        btnCadPro.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Symbol - Add.png"))); // NOI18N
        btnCadPro.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadPro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadProActionPerformed(evt);
            }
        });

        jLabel1.setText("Nome do cliente");

        jLabel5.setText("Situação do cliente");

        tbPro.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbPro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbProMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbPro);

        cbNomeCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o cliente" }));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/View.png"))); // NOI18N
        jLabel3.setText("Pesquisar");

        txtPesqPro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqProKeyReleased(evt);
            }
        });

        btnExcluirPro1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Symbol - Delete.png"))); // NOI18N
        btnExcluirPro1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));

        jLabel7.setText("Id Cliente");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel5)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSituacaoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel11)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbSituacaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel13)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, 728, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(138, 138, 138))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGap(237, 237, 237)
                                    .addComponent(btnCadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnEditarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnExcluirPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbNatAcaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jLabel6)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(cbTipoAcaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGap(329, 329, 329)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtPesqPro, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 811, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(60, 60, 60))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtPesqPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(1, 1, 1)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtNumPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cbNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(cbSituacaoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(cbNatAcaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(cbTipoAcaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(cbSituacaoPro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(txtHonorarios, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnEditarPro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCadPro, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnExcluirPro1, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 934, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        setBounds(0, 0, 945, 627);
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadProActionPerformed
        cadastrarPro();
    }//GEN-LAST:event_btnCadProActionPerformed

    private void btnEditarProActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarProActionPerformed
        alterarPro();
    }//GEN-LAST:event_btnEditarProActionPerformed

    private void tbProMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbProMouseClicked
        tabelaProcessos();
    }//GEN-LAST:event_tbProMouseClicked

    private void txtPesqProKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqProKeyReleased
        pesqPro();
    }//GEN-LAST:event_txtPesqProKeyReleased

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadPro;
    private javax.swing.JButton btnEditarPro;
    private javax.swing.JButton btnExcluirPro1;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JComboBox<String> cbNatAcaoPro;
    private javax.swing.JComboBox<String> cbNomeCli;
    private javax.swing.JComboBox<String> cbSituacaoCli;
    private javax.swing.JComboBox<String> cbSituacaoPro;
    private javax.swing.JComboBox<String> cbTipoAcaoPro;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbPro;
    private javax.swing.JTextField txtHonorarios;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtNumPro;
    private javax.swing.JTextField txtPesqPro;
    // End of variables declaration//GEN-END:variables
}
