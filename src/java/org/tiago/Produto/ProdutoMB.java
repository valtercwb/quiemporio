
package org.tiago.Produto;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean (name = "ProdutoMB")
@SessionScoped

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
             
                new MessageMB("msgInfo", "Produto Cadastrado", "", 1);
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
    
    public void buscar(Produtos produto) throws IOException {
        try {

            setProdutos(produto);
            String url = "/dashProduto/dashboard_produto_alterar.xhtml";

            RedirectMB redirectMB = new RedirectMB(url);
            
        } catch (Exception error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

    }
    
    public void alterar () throws IOException{
        
        try {
            ProdutoConstrutor produtoControler = new ProdutoConstrutor();
            if (produtoControler.alterar(this.produtos)){
                new MessageMB("msgInfo", "Produto Alterado", "", 1);
            }else{
                new MessageMB("msgInfo", "Produto não alterado!", "", 3);
            }
            
        } catch (Exception e) {
        }
        
               
    }
    
    public void excluir (Produtos produto) throws IOException{
         
        try {
            
            ProdutoConstrutor produtoController = new ProdutoConstrutor();
            if (produtoController.excluir(produto)){
                new MessageMB("msgInfo", "Produto Excluido", "", 1);
            }else{
                new MessageMB("msgInfo", "Produto não excluido!", "", 3);
            }
        } catch (Exception e) {
            new MessageMB("msgInfo", e.getMessage(), "", 4);
        }
    }
//    public void buscar1() throws IOException {
//        try {
//            ProdutoConstrutor produtoController = new ProdutoConstrutor();
//
//            Produtos buscarProduto = produtoController.buscar(this.produtos);
//
//            if (buscarProduto.getProd_id()!= 0) {
//                setProdutos(buscarProduto);
//            } else {
//                new MessageMB("msgInfo", "Produto não encontrado!", "", 3);
//                //return null;
//            }
//        } catch (ExceptionError error) {
//            new MessageMB("msgInfo", error.getMessage(), "", 4);
//        }
//
//    }
     public void limparObjeto(){
    
         String url = "/dashProduto/dashboard_produto_cadastrar.xhtml";

            RedirectMB redirectMB = new RedirectMB(url);       
    }
}
