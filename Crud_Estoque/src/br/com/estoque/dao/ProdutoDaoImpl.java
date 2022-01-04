/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.dao;

import br.com.estoque.model.ProdutoEstoque;
import java.sql.Connection;
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
public class ProdutoDaoImpl implements ProdutoDao{
    
    private Connection conexao;
    private PreparedStatement preparaSql;
    private ResultSet resultado;
    private ProdutoEstoque produtosEstoque;

    @Override
    public void salvar(ProdutoEstoque produtosEstoque) throws SQLException {
        String sql = "INSERT INTO produto(nomeProduto, descricao, codigoBarra, precoUnitario, unidadesEmEstoque) VALUES(?, ?, ?, ?, ?)";

        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            preparaSql.setString(1, produtosEstoque.getNomeProduto());
            preparaSql.setString(2, produtosEstoque.getDescricao());
            preparaSql.setString(3, produtosEstoque.getCodigoBarra());
            preparaSql.setDouble(4, produtosEstoque.getPrecoUnitario());
            preparaSql.setInt(5, produtosEstoque.getUnidadeEmEstoque());
            preparaSql.executeUpdate();
            resultado = preparaSql.getGeneratedKeys();
            resultado.next();
            produtosEstoque.setIdProduto(resultado.getInt(1));
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar salvar no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
    }

    @Override
    public void alterar(ProdutoEstoque produtosEstoque) throws SQLException {
        String sql = "UPDATE produto SET nomeProduto = ?, descricao = ?, codigoBarra = ?, precoUnitario = ?, unidadesEmEstoque = ? WHERE idProduto = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(sql);
            preparaSql.setString(1, produtosEstoque.getNomeProduto());
            preparaSql.setString(2, produtosEstoque.getDescricao());
            preparaSql.setString(3, produtosEstoque.getCodigoBarra());
            preparaSql.setDouble(4, produtosEstoque.getPrecoUnitario());
            preparaSql.setInt(5, produtosEstoque.getUnidadeEmEstoque());
            preparaSql.setInt(6, produtosEstoque.getIdProduto());
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar alterar o produto no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public void excluir(int idProduto) throws SQLException {
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement("DELETE FROM produto WHERE idProduto = ?");
            preparaSql.setInt(1, idProduto);
            preparaSql.executeUpdate();
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar excluir o produto no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
        }
    }

    @Override
    public ProdutoEstoque pesquisarPorId(int idProduto) throws SQLException {
        ProdutoEstoque produtosEstoque = null;
        String consulta = "SELECT * FROM produto WHERE idProduto = ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setInt(1, idProduto);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                produtosEstoque = new ProdutoEstoque();
                produtosEstoque.setIdProduto(resultado.getInt("idProduto"));
                produtosEstoque.setNomeProduto(resultado.getString("nomeProduto"));
                produtosEstoque.setDescricao(resultado.getString("descricao"));
                produtosEstoque.setCodigoBarra(resultado.getString("codigoBarra"));
                produtosEstoque.setPrecoUnitario(resultado.getDouble("precoUnitario"));
                produtosEstoque.setUnidadeEmEstoque(resultado.getInt("unidadesEmEstoque"));

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar o ID no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return produtosEstoque;
    }

    @Override
    public List<ProdutoEstoque> pesquisarPorNome(String nomeProduto) throws SQLException {
        String consulta = "SELECT * FROM produto WHERE nomeProduto LIKE ?";
        List<ProdutoEstoque> produtos = new ArrayList<>();
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, "%" + nomeProduto + "%");
            resultado = preparaSql.executeQuery();
            ProdutoEstoque produtosEstoque;
            while (resultado.next()) {
                produtosEstoque = new ProdutoEstoque();
                produtosEstoque.setIdProduto(resultado.getInt("idProduto"));
                produtosEstoque.setNomeProduto(resultado.getString("nomeProduto"));
                produtosEstoque.setDescricao(resultado.getString("descricao"));
                produtosEstoque.setCodigoBarra(resultado.getString("codigoBarra"));
                produtosEstoque.setPrecoUnitario(resultado.getDouble("precoUnitario"));
                produtosEstoque.setUnidadeEmEstoque(resultado.getInt("unidadesEmEstoque"));
                produtos.add(produtosEstoque);

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar por nome no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();

        }
        return produtos;
    }

    @Override
    public ProdutoEstoque pesquisarPorNomeProduto(String nomeProduto) throws SQLException {
        String consulta = "SELECT * FROM produto WHERE nomeProduto LIKE ?";
        try {
            conexao = FabricaConexao.abrirConexao();
            preparaSql = conexao.prepareStatement(consulta);
            preparaSql.setString(1, nomeProduto);
            resultado = preparaSql.executeQuery();
            if (resultado.next()) {
                produtosEstoque = new ProdutoEstoque();
                produtosEstoque.setIdProduto(resultado.getInt("idProduto"));
                produtosEstoque.setNomeProduto(resultado.getString("nomeProduto"));
                produtosEstoque.setDescricao(resultado.getString("descricao"));
                produtosEstoque.setCodigoBarra(resultado.getString("codigoBarra"));
                produtosEstoque.setPrecoUnitario(resultado.getDouble("precoUnitario"));
                produtosEstoque.setUnidadeEmEstoque(resultado.getInt("unidadesEmEstoque"));

            }
        } catch (Exception e) {
            System.out.println("Ocorreu um erro ao tentar pesquisar o nome do protudo no banco" + e.getMessage());
        } finally {
            conexao.close();
            preparaSql.close();
            resultado.close();
        }
        return produtosEstoque;
    }

    
}
