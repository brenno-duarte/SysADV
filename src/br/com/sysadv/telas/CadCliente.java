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
public class CadCliente extends javax.swing.JInternalFrame {

    Connection conexao;
    PreparedStatement pst;
    ResultSet rs;

    /**
     * Creates new form CadCliente
     */
    public CadCliente() {
        initComponents();
        conexao = Conexao.Conectar();
        pesqCli();
    }

    public void limparCampos() {
        txtNomeCli.setText(null);
        txtCpfCli.setText(null);
        txtRuaCli.setText(null);
        txtBairroCli.setText(null);
        txtCidadeCli.setText(null);
        txtEstadoCli.setText(null);
        txtNumeroCli.setText(null);
        txtIdCli.setText(null);
        btnCadCli.setEnabled(true);
    }

    public void cadastrarCliente() {
        String sql = "insert into tb_clientes (nomeCli,cpfCli,sexoCli,ruaCli,bairroCli,cidadeCli,estadoCli,numeroCli) values (?,?,?,?,?,?,?,?)";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            pst.setString(2, txtCpfCli.getText());
            pst.setString(3, cbSexoCli.getSelectedItem().toString());
            pst.setString(4, txtRuaCli.getText());
            pst.setString(5, txtBairroCli.getText());
            pst.setString(6, txtCidadeCli.getText());
            pst.setString(7, txtEstadoCli.getText());
            pst.setString(8, txtNumeroCli.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente cadastrado com sucesso");
            txtNomeCli.setText(null);
            txtCpfCli.setText(null);
            txtRuaCli.setText(null);
            txtBairroCli.setText(null);
            txtCidadeCli.setText(null);
            txtEstadoCli.setText(null);
            txtNumeroCli.setText(null);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void alterarCli() {
        String sql = "update tb_clientes set nomeCli=?,cpfCli=?,sexoCli=?,ruaCli=?,bairroCli=?,cidadeCli=?,estadoCli=?,numeroCli=? where idcli=?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtNomeCli.getText());
            pst.setString(2, txtCpfCli.getText());
            pst.setString(3, cbSexoCli.getSelectedItem().toString());
            pst.setString(4, txtRuaCli.getText());
            pst.setString(5, txtBairroCli.getText());
            pst.setString(6, txtCidadeCli.getText());
            pst.setString(7, txtEstadoCli.getText());
            pst.setString(8, txtNumeroCli.getText());
            pst.setString(9, txtIdCli.getText());
            pst.executeUpdate();
            JOptionPane.showMessageDialog(null, "Cliente alterado com sucesso");
            txtNomeCli.setText(null);
            txtCpfCli.setText(null);
            txtRuaCli.setText(null);
            txtBairroCli.setText(null);
            txtCidadeCli.setText(null);
            txtEstadoCli.setText(null);
            txtNumeroCli.setText(null);
            txtIdCli.setText(null);
            btnCadCli.setEnabled(true);
            pesqCli();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }

    public void deletarCli() {
        String sql = "delete from tb_clientes where idcli=1";
        try {
            int confirmar = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja excluir este cliente?", "Aviso", JOptionPane.YES_NO_OPTION);
            if (confirmar == JOptionPane.YES_OPTION) {
                pst = conexao.prepareStatement(sql);
                pst.setString(1, txtIdCli.getText());
                pst.executeUpdate();
                JOptionPane.showMessageDialog(null, "Cliente removido com sucesso");
                txtNomeCli.setText(null);
                txtCpfCli.setText(null);
                txtRuaCli.setText(null);
                txtBairroCli.setText(null);
                txtCidadeCli.setText(null);
                txtEstadoCli.setText(null);
                txtNumeroCli.setText(null);
                txtIdCli.setText(null);
                pesqCli();
            }
        } catch (Exception e) {
        }
    }

    public void tabelaClientes() {
        int setar = tbClientes.getSelectedRow();
        txtIdCli.setText(tbClientes.getModel().getValueAt(setar, 0).toString());
        txtNomeCli.setText(tbClientes.getModel().getValueAt(setar, 1).toString());
        txtCpfCli.setText(tbClientes.getModel().getValueAt(setar, 2).toString());
        cbSexoCli.setSelectedItem(tbClientes.getModel().getValueAt(setar, 3).toString());
        txtRuaCli.setText(tbClientes.getModel().getValueAt(setar, 4).toString());
        txtBairroCli.setText(tbClientes.getModel().getValueAt(setar, 5).toString());
        txtCidadeCli.setText(tbClientes.getModel().getValueAt(setar, 6).toString());
        txtEstadoCli.setText(tbClientes.getModel().getValueAt(setar, 7).toString());
        txtNumeroCli.setText(tbClientes.getModel().getValueAt(setar, 8).toString());
        btnCadCli.setEnabled(false);
    }

    public void pesqCli() {
        String sql = "select idcli as Id,nomeCli as Nome, cpfCli as CPF, sexoCli as Sexo, ruaCli as Rua, bairroCli as Bairro, cidadeCli as Cidade, estadoCli as Estado, numeroCli as Num from tb_clientes where nomeCli like ?";
        try {
            pst = conexao.prepareStatement(sql);
            pst.setString(1, txtPesqCli.getText() + "%");
            rs = pst.executeQuery();
            tbClientes.setModel(DbUtils.resultSetToTableModel(rs));
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
        txtBairroCli = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtCpfCli = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtRuaCli = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNumeroCli = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbClientes = new javax.swing.JTable();
        txtEstadoCli = new javax.swing.JTextField();
        txtNomeCli = new javax.swing.JTextField();
        btnCadCli = new javax.swing.JButton();
        btnEditarCli = new javax.swing.JButton();
        txtCidadeCli = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cbSexoCli = new javax.swing.JComboBox<>();
        txtPesqCli = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtIdCli = new javax.swing.JTextField();
        btnExcluirCli1 = new javax.swing.JButton();
        btnLimparCampos = new javax.swing.JButton();

        setBackground(new java.awt.Color(34, 144, 254));
        setClosable(true);
        setTitle("Cadastrar Cliente");

        jPanel1.setBackground(java.awt.Color.white);

        jLabel6.setText("Número");

        jLabel7.setText("Estado");

        jLabel1.setText("Nome");

        jLabel5.setText("Cidade");

        jLabel3.setText("Bairro");

        jLabel4.setText("Rua");

        jLabel2.setText("CPF");

        tbClientes.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Id", "Nome", "CPF", "Sexo", "Rua", "Bairro", "Cidade", "Estado", "N°"
            }
        ));
        tbClientes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbClientesMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbClientes);

        btnCadCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Create.png"))); // NOI18N
        btnCadCli.setText("Cadastrar");
        btnCadCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCadCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCadCliActionPerformed(evt);
            }
        });

        btnEditarCli.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Modify.png"))); // NOI18N
        btnEditarCli.setText("Alterar");
        btnEditarCli.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnEditarCli.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEditarCliActionPerformed(evt);
            }
        });

        jLabel8.setText("Sexo");

        cbSexoCli.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Masculino", "Feminino" }));

        txtPesqCli.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPesqCliKeyReleased(evt);
            }
        });

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/View.png"))); // NOI18N
        jLabel9.setText("Pesquisar");

        jLabel10.setText("Id");

        txtIdCli.setEditable(false);
        txtIdCli.setEnabled(false);

        btnExcluirCli1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Delete.png"))); // NOI18N
        btnExcluirCli1.setText("Excluir");
        btnExcluirCli1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnExcluirCli1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnExcluirCli1ActionPerformed(evt);
            }
        });

        btnLimparCampos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/sysadv/icones/Remove.png"))); // NOI18N
        btnLimparCampos.setText("Limpar");
        btnLimparCampos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLimparCamposActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, 216, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtRuaCli, javax.swing.GroupLayout.PREFERRED_SIZE, 406, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumeroCli)
                                .addGap(104, 104, 104))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(jPanel1Layout.createSequentialGroup()
                                            .addComponent(jLabel1)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, 433, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel8)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(cbSexoCli, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(jLabel2)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                            .addComponent(txtCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                        .addGap(45, 45, 45))))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(223, 223, 223)
                .addComponent(btnCadCli, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEditarCli, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnExcluirCli1, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnLimparCampos, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtPesqCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtIdCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNomeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(cbSexoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(txtCpfCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtRuaCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(txtNumeroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtBairroCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jLabel7)
                    .addComponent(txtEstadoCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtCidadeCli, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCadCli)
                    .addComponent(btnEditarCli, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnExcluirCli1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnLimparCampos))
                .addGap(104, 104, 104))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCadCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCadCliActionPerformed
        cadastrarCliente();
    }//GEN-LAST:event_btnCadCliActionPerformed

    private void tbClientesMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbClientesMouseClicked
        tabelaClientes();
    }//GEN-LAST:event_tbClientesMouseClicked

    private void txtPesqCliKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPesqCliKeyReleased
        pesqCli();
    }//GEN-LAST:event_txtPesqCliKeyReleased

    private void btnEditarCliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEditarCliActionPerformed
        alterarCli();
    }//GEN-LAST:event_btnEditarCliActionPerformed

    private void btnLimparCamposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLimparCamposActionPerformed
        limparCampos();
    }//GEN-LAST:event_btnLimparCamposActionPerformed

    private void btnExcluirCli1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnExcluirCli1ActionPerformed
        deletarCli();
    }//GEN-LAST:event_btnExcluirCli1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCadCli;
    private javax.swing.JButton btnEditarCli;
    private javax.swing.JButton btnExcluirCli1;
    private javax.swing.JButton btnLimparCampos;
    private javax.swing.JComboBox<String> cbSexoCli;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbClientes;
    private javax.swing.JTextField txtBairroCli;
    private javax.swing.JTextField txtCidadeCli;
    private javax.swing.JTextField txtCpfCli;
    private javax.swing.JTextField txtEstadoCli;
    private javax.swing.JTextField txtIdCli;
    private javax.swing.JTextField txtNomeCli;
    private javax.swing.JTextField txtNumeroCli;
    private javax.swing.JTextField txtPesqCli;
    private javax.swing.JTextField txtRuaCli;
    // End of variables declaration//GEN-END:variables
}
