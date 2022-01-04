/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.dao;

import br.com.estoque.model.Usuario;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Vítor
 */
public class UsuarioDaoImpl implements UsuarioDao {

    private Connection conexao;
    private PreparedStatement preparaSql;
    private ResultSet resultado;
    private Usuario usuario;

    @Override
    public void salvar(Usuario usuario) throws SQLException {
        String sql = "INSERT INTO usuario(nome, login, senha, email, ultimoAcesso) VALUES(?, ?, ?, ?, now())";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparaSql.setString(1, usuario.getNome());
            preparaSql.setString(2, usuario.getLogin());
            preparaSql.setString(3, usuario.getSenha());
            preparaSql.setString(4, usuario.getEmail());
            preparaSql.executeUpdate();
            resultado = preparaSql.getGeneratedKeys();
            resultado.next();
            usuario.setIdUsuario(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar salvar no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
    }

    @Override
    public void alterar(Usuario usuario) throws SQLException {
        String sql = "UPDATE usuario SET nome = ?, login = ?, senha = ? WHERE idUsuario = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, usuario.getNome());
            preparaSql.setString(2, usuario.getLogin());
            preparaSql.setString(3, usuario.getSenha());
            preparaSql.setInt(4, usuario.getIdUsuario());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar alterar o usuario no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public void excluir(int idUsuario) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement("DELETE FROM usuario WHERE idUsuario = ?");
            preparaSql.setInt(1, idUsuario);
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar excluir o usuario no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public Usuario pesquisarPorId(int idUsuario) throws SQLException {
        Usuario usuario = null;
        String consulta = "SELECT * FROM usuario WHERE idUsuario = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setInt(1, idUsuario);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar o ID no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return usuario;
    }

    @Override
    public List<Usuario> pesquisarPorNome(String nome) throws SQLException {
        String consulta = "SELECT * FROM usuario WHERE nome LIKE ?";
        List<Usuario> user = new ArrayList<>();
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, nome);
            resultado = preparaSql.executeQuery();
            Usuario usuario;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setIdUsuario(resultado.getInt("idUsuario"));
                usuario.setNome(resultado.getString("nome"));
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));
                usuario.setEmail(resultado.getString("email"));
                user.add(usuario);

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar por nome no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return user;
    }

    @Override
    public List<Usuario> pesquisarPorEmail(String email) throws SQLException {
        String consulta = "SELECT email FROM usuario WHERE email = ?";
        List<Usuario> user = new ArrayList<>();
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, email);
            resultado = preparaSql.executeQuery();
            Usuario usuario;
            while (resultado.next()) {
                usuario = new Usuario();
                usuario.setEmail(resultado.getString("email"));
                user.add(usuario);

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar por nome no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return user;
    }

    @Override
    public Usuario pesquisarPorLogin(String login, String senha) throws SQLException {
        String consulta = "SELECT login, senha FROM usuario WHERE login = ? AND senha = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, login);
            preparaSql.setString(2, senha);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setLogin(resultado.getString("login"));
                usuario.setSenha(resultado.getString("senha"));

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar o ID no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return usuario;
    }

    @Override
    public Usuario pesquisarPorUsuario(String login) throws SQLException {
        String consulta = "SELECT login FROM usuario WHERE login = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, login);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                usuario = new Usuario();
                usuario.setLogin(resultado.getString("login"));

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar o ID no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return usuario;
    }
}
