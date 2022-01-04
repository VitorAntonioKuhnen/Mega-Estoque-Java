/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.controller;

import br.com.estoque.dao.FabricaConexao;
import br.com.estoque.dao.UsuarioDao;
import br.com.estoque.dao.UsuarioDaoImpl;
import br.com.estoque.model.ProdutoEstoque;
import br.com.estoque.model.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Vítor
 */
public class NegocioEstoque {

    private Usuario usuario;
    private UsuarioDao usuarioDao;
    private ProdutoEstoque produtosEstoque;

    public static boolean validarSenha(Usuario usuario, String password, String confirmPassword) {
        if (password.equals(confirmPassword)) {
            usuario.setSenha(password);
            return false;
        } else {
            return true;
        }
    }

    public boolean validarEmail(Usuario usuario, String email) throws SQLException {
        Pattern especialAro = Pattern.compile("@");
        Pattern especialPont = Pattern.compile(".");
        Matcher caracterArroba = especialAro.matcher(email);
        Matcher caracterPonto = especialPont.matcher(email);

        usuarioDao = new UsuarioDaoImpl();
        
        if (caracterArroba.find() == true && caracterPonto.find() == true && usuarioDao.pesquisarPorEmail(email).isEmpty()) {
            usuario.setEmail(email);
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarToken(Usuario usuario, String token) {
        if (usuario.getToken().equals(token)) {
            return false;
        } else {
            return true;
        }
    }

    public static boolean validarNome(Usuario usuario, String nome) {
        Pattern numero = Pattern.compile("[0-9]");
        Matcher temNumero = numero.matcher(nome);
        if (!temNumero.find()) {
            usuario.setNome(nome);
            return false;
        } else {
            return true;
        }
    }

    public String validaLogin(Usuario usuario, String login, String senha) throws SQLException {

        usuarioDao = new UsuarioDaoImpl();
        try {
            usuario = usuarioDao.pesquisarPorLogin(login, senha);
            if (usuario.getLogin().equals(login)) {
                return "Correto";
            }
        } catch (Exception e) {
            return "erroLogin";
        }
        return "erroLogin";

    }

    public String validarUsuario(Usuario usuario, String login) {
        usuarioDao = new UsuarioDaoImpl();
        try {
            usuario = usuarioDao.pesquisarPorUsuario(login);
            if (usuario.getLogin().equals(login)) {
                return "Correto";
            }
        } catch (Exception e) {
            return "erroLogin";
        }
        return "erroLogin";

    }

    public static String validarProduto(ProdutoEstoque produtosEstoque, String modelo, int quantidade, double valor, String codigoBarras, String descricao) {

        if (modelo.length() <= 1) {
            return "NomeProduto";
        }
        if (quantidade <= 0) {
            return "Quantidade";
        }
        if (valor < 0.1) {
            return "Preco";
        } else {
            produtosEstoque.setNomeProduto(modelo);
            produtosEstoque.setUnidadeEmEstoque(quantidade);
            produtosEstoque.setPrecoUnitario(valor);
            produtosEstoque.setCodigoBarra(codigoBarras);
            produtosEstoque.setDescricao(descricao);
            return "salvar";
        }
    }

}
