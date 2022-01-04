/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.view;

import br.com.estoque.controller.NegocioEstoque;
import br.com.estoque.dao.ProdutoDao;
import br.com.estoque.dao.ProdutoDaoImpl;
import br.com.estoque.model.ProdutoEstoque;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author vitor.kuhnen
 */
public class CadastroProdutos extends javax.swing.JFrame {

    private ProdutoEstoque produtosEstoque;
    private NegocioEstoque negocioEstoque;
    private ProdutoDao produtoDao;

    /**
     * Creates new form CadastroProdutos
     */
    public CadastroProdutos() {
        initComponents();
        produtoDao = new ProdutoDaoImpl();
        negocioEstoque = new NegocioEstoque();
        produtosEstoque = new ProdutoEstoque();
        erroProduto.setVisible(false);
        erroQuantidade.setVisible(false);
        erroValor.setVisible(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panel = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        varMarcaModelo = new javax.swing.JTextField();
        lbQuantidade = new javax.swing.JLabel();
        varQuantidade = new javax.swing.JFormattedTextField();
        lbValor = new javax.swing.JLabel();
        lbCodigoBarras = new javax.swing.JLabel();
        varCodigo = new javax.swing.JTextField();
        lbDescricao = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        varDescricao = new javax.swing.JTextArea();
        btSalvar = new javax.swing.JButton();
        varValor = new javax.swing.JTextField();
        erroProduto = new javax.swing.JLabel();
        erroQuantidade = new javax.swing.JLabel();
        erroValor = new javax.swing.JLabel();
        btLimpar = new javax.swing.JToggleButton();
        menuBar = new javax.swing.JMenuBar();
        menuHome = new javax.swing.JMenu();
        home = new javax.swing.JMenuItem();
        sairdo = new javax.swing.JMenuItem();
        menuProdutos = new javax.swing.JMenu();
        produtoCadastro = new javax.swing.JMenuItem();
        menuRelatorio = new javax.swing.JMenu();
        produtoRelatorio = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega Estoque");

        titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro Produto Mega Estoque");

        lbNome.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbNome.setText("Marca/Modelo:");

        lbQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbQuantidade.setText("Quantidade:");

        varQuantidade.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));

        lbValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbValor.setText("Valor:");

        lbCodigoBarras.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbCodigoBarras.setText("Código de Barras:");

        lbDescricao.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        lbDescricao.setText("Descrição");

        varDescricao.setColumns(20);
        varDescricao.setRows(5);
        jScrollPane1.setViewportView(varDescricao);

        btSalvar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        erroProduto.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        erroProduto.setForeground(new java.awt.Color(255, 0, 0));
        erroProduto.setText("Informe um produto!");

        erroQuantidade.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        erroQuantidade.setForeground(new java.awt.Color(255, 0, 0));
        erroQuantidade.setText("Informe a quantidade!");

        erroValor.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        erroValor.setForeground(new java.awt.Color(255, 0, 0));
        erroValor.setText("Informe o valor!");

        btLimpar.setFont(new java.awt.Font("Segoe UI Black", 1, 14)); // NOI18N
        btLimpar.setText("Limpar");
        btLimpar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLimparActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelLayout = new javax.swing.GroupLayout(panel);
        panel.setLayout(panelLayout);
        panelLayout.setHorizontalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(panelLayout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(lbDescricao)
                    .addComponent(lbNome)
                    .addComponent(lbCodigoBarras)
                    .addComponent(lbQuantidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelLayout.createSequentialGroup()
                        .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(panelLayout.createSequentialGroup()
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btLimpar))
                            .addComponent(jScrollPane1)
                            .addComponent(varCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 301, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 372, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erroProduto))
                    .addGroup(panelLayout.createSequentialGroup()
                        .addComponent(varQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erroQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbValor)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(erroValor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        panelLayout.setVerticalGroup(
            panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(varMarcaModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroProduto))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbQuantidade)
                    .addComponent(varQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lbValor)
                    .addComponent(varValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroQuantidade)
                    .addComponent(erroValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbCodigoBarras)
                    .addComponent(varCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lbDescricao)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(panelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btSalvar)
                    .addComponent(btLimpar))
                .addContainerGap(39, Short.MAX_VALUE))
        );

        menuHome.setText("Inicio");

        home.setText("Inicio");
        home.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                homeMouseClicked(evt);
            }
        });
        home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                homeActionPerformed(evt);
            }
        });
        menuHome.add(home);

        sairdo.setText("Sair");
        sairdo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairdoActionPerformed(evt);
            }
        });
        menuHome.add(sairdo);

        menuBar.add(menuHome);

        menuProdutos.setText("Produtos");

        produtoCadastro.setText("Cadastro Produtos");
        produtoCadastro.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                produtoCadastroMouseClicked(evt);
            }
        });
        produtoCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoCadastroActionPerformed(evt);
            }
        });
        menuProdutos.add(produtoCadastro);

        menuBar.add(menuProdutos);

        menuRelatorio.setText("Relatorio");
        menuRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuRelatorioActionPerformed(evt);
            }
        });

        produtoRelatorio.setText("Relario Protudos");
        produtoRelatorio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                produtoRelatorioActionPerformed(evt);
            }
        });
        menuRelatorio.add(produtoRelatorio);

        menuBar.add(menuRelatorio);

        setJMenuBar(menuBar);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(panel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        String marcaModelo = varMarcaModelo.getText().trim();
        int quantidade = Integer.valueOf(varQuantidade.getText().trim());
        String strValor = (varValor.getText().trim()).replace(",", ".");
        double valor = Double.valueOf(strValor);
        String codigoBarras = varCodigo.getText().trim();
        String descricao = varDescricao.getText().trim();
        String validacao = negocioEstoque.validarProduto(produtosEstoque, marcaModelo, quantidade, valor, codigoBarras, descricao);
        erroProduto.setVisible(false);
        erroQuantidade.setVisible(false);
        erroValor.setVisible(false);
        if (validacao == "NomeProduto") {
            erroProduto.setVisible(true);
        } else if (validacao == "Quantidade") {
            erroQuantidade.setVisible(true);
        } else if (validacao == "Preco") {
            erroValor.setVisible(true);
        } else {

            try {
                System.out.println("Salvando no banco!");
                produtoDao.salvar(produtosEstoque);
                System.out.println("Salvo no banco!");
                btLimparActionPerformed(evt);
            } catch (SQLException ex) {
                System.err.println("Erro ao Salvar produto" + ex.getMessage());
            }
        }

    }//GEN-LAST:event_btSalvarActionPerformed

    private void btLimparActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLimparActionPerformed
        varCodigo.setText("");
        varDescricao.setText("");
        varMarcaModelo.setText("");
        varQuantidade.setText("");
        varValor.setText("");
    }//GEN-LAST:event_btLimparActionPerformed

    private void produtoCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoCadastroActionPerformed
        new CadastroProdutos().setVisible(true);
        dispose();
    }//GEN-LAST:event_produtoCadastroActionPerformed

    private void produtoCadastroMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_produtoCadastroMouseClicked

    }//GEN-LAST:event_produtoCadastroMouseClicked

    private void homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_homeActionPerformed
        new Principal().setVisible(true);
        dispose();
    }//GEN-LAST:event_homeActionPerformed

    private void homeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_homeMouseClicked

    }//GEN-LAST:event_homeMouseClicked

    private void sairdoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairdoActionPerformed
        new LoginUsuario().setVisible(true);
        dispose();
    }//GEN-LAST:event_sairdoActionPerformed

    private void menuRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuRelatorioActionPerformed
        new RelatorioProdutos().setVisible(true);
        dispose();
    }//GEN-LAST:event_menuRelatorioActionPerformed

    private void produtoRelatorioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_produtoRelatorioActionPerformed
        new RelatorioProdutos().setVisible(true);
        dispose();
    }//GEN-LAST:event_produtoRelatorioActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroProdutos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroProdutos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JToggleButton btLimpar;
    private javax.swing.JButton btSalvar;
    private javax.swing.JLabel erroProduto;
    private javax.swing.JLabel erroQuantidade;
    private javax.swing.JLabel erroValor;
    private javax.swing.JMenuItem home;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbCodigoBarras;
    private javax.swing.JLabel lbDescricao;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbQuantidade;
    private javax.swing.JLabel lbValor;
    private javax.swing.JMenuBar menuBar;
    private javax.swing.JMenu menuHome;
    private javax.swing.JMenu menuProdutos;
    private javax.swing.JMenu menuRelatorio;
    private javax.swing.JPanel panel;
    private javax.swing.JMenuItem produtoCadastro;
    private javax.swing.JMenuItem produtoRelatorio;
    private javax.swing.JMenuItem sairdo;
    private javax.swing.JLabel titulo;
    private javax.swing.JTextField varCodigo;
    private javax.swing.JTextArea varDescricao;
    private javax.swing.JTextField varMarcaModelo;
    private javax.swing.JFormattedTextField varQuantidade;
    private javax.swing.JTextField varValor;
    // End of variables declaration//GEN-END:variables
}