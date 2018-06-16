package org.tiago.endereco;

public class Endereco {
    
    private int end_id;
    private int end_numero;
    private String end_complemento;
    private String CEP;
    private String end_nome;

    public String getEnd_nome() {
        return end_nome;
    }

    public void setEnd_nome(String end_nome) {
        this.end_nome = end_nome;
    }

    public Endereco(int end_id, int end_numero, String end_complemento, String CEP, String end_nome) {
        this.end_id = end_id;
        this.end_numero = end_numero;
        this.end_complemento = end_complemento;
        this.CEP = CEP;
        this.end_nome = end_nome;
        
    }

    public Endereco() {
    }

    public int getEnd_id() {
        return end_id;
    }

    public void setEnd_id(int end_id) {
        this.end_id = end_id;
    }

    public int getEnd_numero() {
        return end_numero;
    }

    public void setEnd_numero(int end_numero) {
        this.end_numero = end_numero;
    }

    public String getEnd_complemento() {
        return end_complemento;
    }

    public void setEnd_complemento(String end_complemento) {
        this.end_complemento = end_complemento;
    }

    public String getCEP() {
        return CEP;
    }

    public void setCEP(String CEP) {
        this.CEP = CEP;
    }
    
    
}
