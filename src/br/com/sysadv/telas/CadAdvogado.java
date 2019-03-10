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
public class CadAdvogado extends javax.swing.JInternalFrame {

    Connection con;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form CadAdvogado
     */
    public CadAdvogado() {
        initComponents();
        con = Conexao.Conectar();
        pesqAdv();
        txtIdAdv.setVisible(false);
    }

    public void limparCampos() {
        txtNomeAdv.setText(null);
        txtCpfAdv.setText(null);
        txtEmailAdv.setText(null);
        txtUsuarioAdv.setText(null);
        txtSenhaAdv.setText(null);
        cbSexoAdv.setSelectedItem("Selecione o sexo:");
    }

    public void tabelaAdv() {
        int setar = tbAdv.getSelectedRow();
        txtIdAdv.setText(tbAdv.getModel().getValueAt(setar, 0).toString());
        txtNomeAdv.setText(tbAdv.getModel().getValueAt(setar, 1).toString());
        txtCpfAdv.setText(tbAdv.getModel().getValueAt(setar, 2).toString());
        cbSexoAdv.setSelectedItem(tbAdv.getModel().getValueAt(setar, 3).toString());
        txtEmailAdv.setText(tbAdv.getModel().getValueAt(setar, 4).toString());
        txtUsuarioAdv.setText(tbAdv.getModel().getValueAt(setar, 5).toString());
        btnCadAdv.setEnabled(false);
    }

    public void pesqAdv() {
        String sql = "select idadv as ID,nomeAdv as Nome,CPFaDV AS cpf,sexoAdv as Sexo,emailAdv as Email,loginAdv as Usuario from tb_advogado where nomeAdv like ?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtPesqAdv.getText() + "%");
            rs = pst.executeQuery();
            tbAdv.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void cadastrarAdv() {
        String sql = "insert into tb_advogado (nomeAdv,cpfAdv,sexoAdv,emailAdv,loginAdv,senhaAdv) values (?,?,?,?,?,?)";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNomeAdv.getText());
            pst.setString(2, txtCpfAdv.getText());
            pst.setString(3, cbSexoAdv.getSelectedItem().toString());
            pst.setString(4, txtEmailAdv.getText());
            pst.setString(5, txtUsuarioAdv.getText());
            pst.setString(6, txtSenhaAdv.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Advogado cadastrado com sucesso");
            txtNomeAdv.setText(null);
            txtCpfAdv.setText(null);
            txtEmailAdv.setText(null);
            txtUsuarioAdv.setText(null);
            txtSenhaAdv.setText(null);
            cbSexoAdv.setSelectedItem("Selecione o sexo:");
            pesqAdv();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarAdv() {
        String sql = "update tb_advogado set nomeAdv=?,cpfAdv=?,sexoAdv=?,emailAdv=?,loginAdv=?,senhaAdv=? where idadv=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtNomeAdv.getText());
            pst.setString(2, txtCpfAdv.getText());
            pst.setString(3, cbSexoAdv.getSelectedItem().toString());
            pst.setString(4, txtEmailAdv.getText());
            pst.setString(5, txtUsuarioAdv.getText());
            pst.setString(6, txtSenhaAdv.getText());
            pst.setString(7, txtIdAdv.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Advogado alterado com sucesso");
            txtNomeAdv.setText(null);
            txtCpfAdv.setText(null);
            txtEmailAdv.setText(null);
            txtUsuarioAdv.setText(null);
            txtSenhaAdv.setText(null);
            cbSexoAdv.setSelectedItem("Selecione o sexo:");
            btnCadAdv.setEnabled(true);
            pesqAdv();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletarAdv() {
        String sql = "delete from tb_advogado where idadv=?";
        try {
            pst = con.prepareStatement(sql);
            pst.setString(1, txtIdAdv.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Advogado alterado com sucesso");
            txtNomeAdv.setText(null);
            txtCpfAdv.setText(null);
            txtEmailAdv.setText(null);
            txtUsuarioAdv.setText(null);
            txtSenhaAdv.setText(null);
            cbSexoAdv.setSelectedItem("Selecione o sexo:");
            btnCadAdv.setEnabled(true);
            pesqAdv();
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
        jLabel3 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCpfAdv = new javax.swing.JTextField();
        txtUsuarioAdv = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNomeAdv = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbAdv = new javax.swing.JTable();
        txtSenhaAdv = new javax.swing.JPasswordField();
        txtEmailAdv = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        btnCadAdv = new javax.swing.JButton();
        btnEditarAdv = new javax.swing.JButton();
        btnExcluirAdv = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cbSexoAdv = new javax.swing.JComboBox<>();
        btnLimparCampos = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        txtPesqAdv = new javax.swing.JTextField();
        txtIdAdv = new javax.swing.JTextField();

        setBackground(new java.awt.Color(0, 137, 255));
        setClosable(true);
        setResizable(true);
        setTitle("Cadastrar Advogado");

        jPanel1.setBackground(java.awt.Color.white);

        jLabel3.setText("Nome de Usuário");

        jLabel1.setText("Nome");

        jLabel5.setText("Senha");

        jLabel2.setText("CPF");

        jLabel4.setText("Email");

        tbAdv.setModel(new javax.swing.table.DefaultTableModel(
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
        tbAdv.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbAdvMouseClicked(evt);
            }
        });
        tbAdv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tbAdvKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(tbAdv);

        jLabel6.setText("Confirme a senha");

        btnCadAdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Create.png"))); // NOI18N
        btnCadAdv.setText("Cadastrar");
        btnCadAdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadAdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadAdvActionPerformed(evt);
            }
        });

        btnEditarAdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Modify.png"))); // NOI18N
        btnEditarAdv.setText("Alterar");
        btnEditarAdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarAdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarAdvActionPerformed(evt);
            }
        });

        btnExcluirAdv.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Delete.png"))); // NOI18N
        btnExcluirAdv.setText("Excluir");
        btnExcluirAdv.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirAdv.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirAdvActionPerformed(evt);
            }
        });

        jLabel7.setText("Sexo");

        cbSexoAdv.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o sexo:", "Masculino", "Feminino" }));

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Remove.png"))); // NOI18N
        btnLimparCampos.setText("Limpar");
        btnLimparCampos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/View.png"))); // NOI18N
        jLabel8.setText("Pesquisar");

        txtPesqAdv.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqAdvKeyReleased(evt);
            }
        });

        txtIdAdv.setEditable(false);
        txtIdAdv.setEnabled(false);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesqAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(txtIdAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel1)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtNomeAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel2)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtCpfAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 166, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel7)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(cbSexoAdv, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addComponent(jScrollPane1)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel4)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtEmailAdv)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jLabel3)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtUsuarioAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 266, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel5)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(txtSenhaAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 316, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(jLabel6)
                            .addGap(7, 7, 7)
                            .addComponent(jTextField1, javax.swing.GroupLayout.DEFAULT_SIZE, 359, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(130, 130, 130)
                            .addComponent(btnCadAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(38, 38, 38)
                            .addComponent(btnEditarAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(43, 43, 43)
                            .addComponent(btnExcluirAdv, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(35, 35, 35)
                            .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(46, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtPesqAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtIdAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(38, 38, 38)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(42, 42, 42)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbSexoAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtEmailAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(txtUsuarioAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(txtSenhaAdv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnEditarAdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirAdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCadAdv, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimparCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(97, 97, 97))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadAdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadAdvActionPerformed
        cadastrarAdv();
    }//GEN-LAST:event_btnCadAdvActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void txtPesqAdvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqAdvKeyReleased
        pesqAdv();
    }//GEN-LAST:event_txtPesqAdvKeyReleased

    private void tbAdvKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tbAdvKeyReleased
        //tabelaAdv();
    }//GEN-LAST:event_tbAdvKeyReleased

    private void btnEditarAdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarAdvActionPerformed
        alterarAdv();
    }//GEN-LAST:event_btnEditarAdvActionPerformed

    private void tbAdvMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbAdvMouseClicked
        tabelaAdv();
    }//GEN-LAST:event_tbAdvMouseClicked

    private void btnExcluirAdvActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirAdvActionPerformed
        deletarAdv();
    }//GEN-LAST:event_btnExcluirAdvActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadAdv;
    private javax.swing.JButton btnEditarAdv;
    private javax.swing.JButton btnExcluirAdv;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JComboBox<String> cbSexoAdv;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTable tbAdv;
    private javax.swing.JTextField txtCpfAdv;
    private javax.swing.JTextField txtEmailAdv;
    private javax.swing.JTextField txtIdAdv;
    private javax.swing.JTextField txtNomeAdv;
    private javax.swing.JTextField txtPesqAdv;
    private javax.swing.JPasswordField txtSenhaAdv;
    private javax.swing.JTextField txtUsuarioAdv;
    // End of variables declaration//GEN-END:variables
}
