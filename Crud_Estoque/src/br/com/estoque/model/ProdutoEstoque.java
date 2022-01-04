/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.estoque.model;

/**
 *
 * @author Vítor
 */
public class ProdutoEstoque {

    private Integer idProduto;
    private String nomeProduto;
    private String descricao;
    private String codigoBarra;
    private Double precoUnitario;
    private int unidadeEmEstoque;

    public ProdutoEstoque() {
    }

    public ProdutoEstoque(String nomeProduto, String descricao, String codigoBarra, Double precoUnitario, int unidadeEmEstoque) {
        this.nomeProduto = nomeProduto;
        this.descricao = descricao;
        this.codigoBarra = codigoBarra;
        this.precoUnitario = precoUnitario;
        this.unidadeEmEstoque = unidadeEmEstoque;
    }
    
    

    public Integer getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Integer idProduto) {
        this.idProduto = idProduto;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getCodigoBarra() {
        return codigoBarra;
    }

    public void setCodigoBarra(String codigoBarra) {
        this.codigoBarra = codigoBarra;
    }

    public Double getPrecoUnitario() {
        return precoUnitario;
    }

    public void setPrecoUnitario(Double precoUnitario) {
        this.precoUnitario = precoUnitario;
    }

    public int getUnidadeEmEstoque() {
        return unidadeEmEstoque;
    }

    public void setUnidadeEmEstoque(int unidadeEmEstoque) {
        this.unidadeEmEstoque = unidadeEmEstoque;
    }

}
