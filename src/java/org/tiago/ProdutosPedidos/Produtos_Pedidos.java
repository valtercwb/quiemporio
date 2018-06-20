
package org.tiago.ProdutosPedidos;

import org.tiago.Produto.Produtos;


public class Produtos_Pedidos {
    
    private int PedId;
    private int ProdId;
    private int quantidade_produto;
    private double preco_produto;
    private Produtos produtos;
   
    
    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
    
    public Produtos_Pedidos() {
    }

    public Produtos_Pedidos(int PedId, int ProdId, int quantidade_produto, double preco_produto) {
        this.PedId = PedId;
        this.ProdId = ProdId;
        this.quantidade_produto = quantidade_produto;
        this.preco_produto = preco_produto;
    }

    
    
    public int getPedId() {
        return PedId;
    }

    public void setPedId(int PedId) {
        this.PedId = PedId;
    }

    public int getProdId() {
        return ProdId;
    }

    public void setProdId(int ProdId) {
        this.ProdId = ProdId;
    }

    public int getQuantidade_produto() {
        return quantidade_produto;
    }

    public void setQuantidade_produto(int quantidade_produto) {
        this.quantidade_produto = quantidade_produto;
    }

    public double getPreco_produto() {
        return preco_produto;
    }

    public void setPreco_produto(double preco_produto) {
        this.preco_produto = preco_produto;
    }
    
    
    
}

