/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.tiago.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.SessionMB;

@ManagedBean (name = "ProdutoMB")
@RequestScoped

public class ProdutoMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Produtos produtos = new Produtos();

    public ProdutoMB(){
    
    }
    public Produtos getProdutos() {
        return produtos;
    }

    public void setProdutos(Produtos produtos) {
        this.produtos = produtos;
    }
    
    public void cadastrar(){
            
        try {
            ProdutoConstrutor produtoControler = new ProdutoConstrutor();
            if (produtoControler.cadastrar(this.produtos)){
             
                new MessageMB("msgInfo", "Produto Cadastrado", "", 3);
            }else{
                new MessageMB("msgInfo", "Produto não cadastrado!", "", 3);
            }
                
            
        } catch (Exception e) {
          
            new MessageMB("msgInfo", e.getMessage(), "", 4);
        }
    }
    
       public List<Produtos> listar() throws IOException {
        List produtoList = new ArrayList<Produtos>();

        try {
            ProdutoConstrutor userController = new ProdutoConstrutor();

            produtoList = userController.listar();

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return produtoList;
        }
    
    
    
    
}
