/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.dao;

import br.com.estoque.model.ProdutoEstoque;
import java.sql.SQLException;
import java.util.List;
/**
 *
 * @author Vítor
 */
public interface ProdutoDao {
    void salvar(ProdutoEstoque produtosEstoque) throws SQLException;

    void alterar(ProdutoEstoque produtosEstoque) throws SQLException;

    void excluir(int idProduto) throws SQLException;

    ProdutoEstoque pesquisarPorId(int idProduto) throws SQLException;

    List<ProdutoEstoque> pesquisarPorNome(String nomeProduto) throws SQLException;
    
    ProdutoEstoque pesquisarPorNomeProduto(String nomeProduto) throws SQLException;
}
