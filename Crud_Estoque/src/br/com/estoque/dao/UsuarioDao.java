/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.dao;


import br.com.estoque.model.Usuario;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Vítor
 */
public interface UsuarioDao {

    void salvar(Usuario usuario) throws SQLException;

    void alterar(Usuario usuario) throws SQLException;

    void excluir(int idUsuario) throws SQLException;

    Usuario pesquisarPorId(int idUsuario) throws SQLException;

    List<Usuario> pesquisarPorNome(String nome) throws SQLException;
    
    List<Usuario> pesquisarPorEmail(String email) throws SQLException;
    
    Usuario pesquisarPorLogin(String login, String senha) throws SQLException;
    
    Usuario pesquisarPorUsuario(String login) throws SQLException;
}
