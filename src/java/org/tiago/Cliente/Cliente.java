
package org.tiago.Cliente;

import org.tiago.endereco.Endereco;


public class Cliente extends Endereco{
    
    private int Cliente_Id;
    private String nome;
    private String CNPJ;
    private String CPF;

    public Cliente() {
    }

    public Cliente(int Cliente_Id, String nome, String CNPJ, String CPF) {
        this.Cliente_Id = Cliente_Id;
        this.nome = nome;
        this.CNPJ = CNPJ;
        this.CPF = CPF;
    }

    public int getCliente_Id() {
        return Cliente_Id;
    }

    public void setCliente_Id(int Cliente_Id) {
        this.Cliente_Id = Cliente_Id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCNPJ() {
        return CNPJ;
    }

    public void setCNPJ(String CNPJ) {
        this.CNPJ = CNPJ;
    }

    public String getCPF() {
        return CPF;
    }

    public void setCPF(String CPF) {
        this.CPF = CPF;
    }
    
    
    
    
}
