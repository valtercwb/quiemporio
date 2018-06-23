
package org.tiago.Produto;

import java.sql.Timestamp;


public class Produtos {
    
    private int prod_id;
    private Timestamp data_adicionado;
    private double preco_un;
    private String nome;
    private int quantidade;

    public Produtos(int prod_id, Timestamp data_adicionado, double preco_un, String nome, int quantidade) {
        this.prod_id = prod_id;
        this.data_adicionado = data_adicionado;
        this.preco_un = preco_un;
        this.nome = nome;
        this.quantidade = quantidade;
    }

    public Produtos() {
    }
    

    public int getProd_id() {
        return prod_id;
    }

    public void setProd_id(int prod_id) {
        this.prod_id = prod_id;
    }

    public Timestamp getData_adicionado() {
        return data_adicionado;
    }

    public void setData_adicionado(Timestamp data_adicionado) {
        this.data_adicionado = data_adicionado;
    }

    public double getPreco_un() {
        return preco_un;
    }

    public void setPreco_un(double preco_un) {
        this.preco_un = preco_un;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return "Produtos{" + "prod_id=" + prod_id + ", data_adicionado=" + data_adicionado + ", preco_un=" + preco_un + ", nome=" + nome + ", quantidade=" + quantidade + '}';
    }
    
    
}
