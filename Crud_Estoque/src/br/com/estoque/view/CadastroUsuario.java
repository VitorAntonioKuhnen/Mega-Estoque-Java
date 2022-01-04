/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.view;

import br.com.estoque.controller.NegocioEstoque;
import br.com.estoque.dao.UsuarioDao;
import br.com.estoque.dao.UsuarioDaoImpl;
import br.com.estoque.model.Usuario;
import br.com.estoque.util.EnviaEmail;
import br.com.estoque.util.GeradorUtil;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

/**
 *
 * @author vitor.kuhnen
 */
public class CadastroUsuario extends javax.swing.JFrame {

    private Usuario usuario;
    private NegocioEstoque negocioEstoque;
    private UsuarioDao usuarioDao;
    private EnviaEmail enviaEmail;

    /**
     * Creates new form Cadastro
     */
    public CadastroUsuario() {
        initComponents();
        usuario = new Usuario();
        usuarioDao = new UsuarioDaoImpl();
        enviaEmail = new EnviaEmail();
        lbErro.setVisible(false);
        erroLogin.setVisible(false);
        erroEmail.setVisible(false);
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
        titulo = new javax.swing.JLabel();
        lbEmail = new javax.swing.JLabel();
        lbNome = new javax.swing.JLabel();
        lbSenha = new javax.swing.JLabel();
        varNome = new javax.swing.JTextField();
        lbConfirmaSenha = new javax.swing.JLabel();
        varEmail = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        varConfirmaSenha = new javax.swing.JPasswordField();
        varSenha = new javax.swing.JPasswordField();
        lbLogin = new javax.swing.JLabel();
        varLogin = new javax.swing.JTextField();
        lbErro = new javax.swing.JLabel();
        erroLogin = new javax.swing.JLabel();
        erroEmail = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Mega Estoque");

        titulo.setFont(new java.awt.Font("Trebuchet MS", 1, 24)); // NOI18N
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Cadastro Mega Estoque");

        lbEmail.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbEmail.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        lbEmail.setText("E-mail: ");

        lbNome.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbNome.setHorizontalAlignment(javax.swing.SwingConstants.RIGHT);
        lbNome.setText("Nome:");

        lbSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbSenha.setText("Senha:");

        lbConfirmaSenha.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbConfirmaSenha.setText("Confirma Senha:");

        varEmail.setToolTipText("Informe um E-mail existente!");
        varEmail.setName(""); // NOI18N

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
            }
        });

        lbLogin.setFont(new java.awt.Font("Trebuchet MS", 1, 12)); // NOI18N
        lbLogin.setText("Login:");

        lbErro.setFont(lbErro.getFont().deriveFont((lbErro.getFont().getStyle() | java.awt.Font.ITALIC)));
        lbErro.setForeground(new java.awt.Color(255, 0, 0));
        lbErro.setText("Verifique novamente seu cadastro!");

        erroLogin.setFont(erroLogin.getFont().deriveFont((erroLogin.getFont().getStyle() | java.awt.Font.ITALIC)));
        erroLogin.setForeground(new java.awt.Color(255, 0, 0));
        erroLogin.setText("Login já existe!");

        erroEmail.setFont(erroEmail.getFont().deriveFont((erroEmail.getFont().getStyle() | java.awt.Font.ITALIC)));
        erroEmail.setForeground(new java.awt.Color(255, 0, 0));
        erroEmail.setText("E-mail invalido!");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(titulo, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbLogin)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(erroLogin))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(erroEmail))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbSenha)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lbConfirmaSenha)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(varConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(btCadastrar)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbErro, javax.swing.GroupLayout.PREFERRED_SIZE, 189, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, 197, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(100, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(titulo, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(5, 5, 5)
                .addComponent(lbErro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbNome)
                    .addComponent(varNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbEmail)
                    .addComponent(varEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroEmail))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbLogin)
                    .addComponent(varLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(erroLogin))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbSenha)
                    .addComponent(lbConfirmaSenha)
                    .addComponent(varSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(varConfirmaSenha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btCadastrar)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed

        negocioEstoque = new NegocioEstoque();
//        Verifica Strings da tela
        boolean verificaNome = (negocioEstoque.validarNome(usuario, varNome.getText().trim()));
        String senha = new String(this.varSenha.getPassword());
        String confirmaSenha = new String(this.varConfirmaSenha.getPassword());
        String login = varLogin.getText().trim();
        boolean verificaSenha = (negocioEstoque.validarSenha(usuario, senha, confirmaSenha));

        try {
            boolean verificaEmail = negocioEstoque.validarEmail(usuario, varEmail.getText().trim());
            if (verificaEmail == true) {
                System.out.println("Email informado já existe");
                erroEmail.setVisible(true);
            } //            Valida o login se já existe
            else if (negocioEstoque.validarUsuario(usuario, login).equals("Correto")) {
                System.out.println("Login informado já existe");
                erroLogin.setVisible(true);
            } else {
//                Salvando o login após a validação
                usuario.setLogin(login);
//                valida se a senha é igual a confirmação, se o e-mail possui "@" e "." e se o nome não está vazio
                if (!verificaSenha && !verificaEmail && !verificaNome) {
//                    Gera um Token e salva na clase usuario
                    usuario.setToken(GeradorUtil.gerarToken());
//                    Envia um e-mail contendo o Token gerado
                    enviaEmail.enviarEmailToken(usuario);

//                    Loop para a confirmação do Token
                    while (true) {
                        String token = JOptionPane.showInputDialog("Informe o Token enviado por e-mail!");
//                        Validando Token informado se é valido para salvar no banco de dados
                        if (!NegocioEstoque.validarToken(usuario, token)) {
                            enviaEmail.enviarEmailDados(usuario);
                            usuarioDao.salvar(usuario);
                            System.out.println("Dados salvos no banco de dados");
                            JOptionPane.showMessageDialog(null, "Cadastrado com Sucesso!! \nVerifique seu E-mail");
                            new LoginUsuario().setVisible(true);
                            dispose();
                            break;
                        } else {
                            JOptionPane.showMessageDialog(null, "Informe o token valido!");
                        }
                    }

                } else {
                    lbErro.setVisible(true);
                }

            }

        } catch (Exception ex) {
            System.err.println("Erro ao Salvar usuario " + ex.getMessage());
        }

    }//GEN-LAST:event_btCadastrarActionPerformed

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
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroUsuario.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroUsuario().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JLabel erroEmail;
    private javax.swing.JLabel erroLogin;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lbConfirmaSenha;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbErro;
    private javax.swing.JLabel lbLogin;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbSenha;
    private javax.swing.JLabel titulo;
    private javax.swing.JPasswordField varConfirmaSenha;
    private javax.swing.JTextField varEmail;
    private javax.swing.JTextField varLogin;
    private javax.swing.JTextField varNome;
    private javax.swing.JPasswordField varSenha;
    // End of variables declaration//GEN-END:variables
}
