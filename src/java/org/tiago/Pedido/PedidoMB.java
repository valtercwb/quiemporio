
package org.tiago.Pedido;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;
import org.tiago.Cliente.Cliente;
import org.tiago.Cliente.ClienteController;
import org.tiago.Produto.ProdutoConstrutor;
import org.tiago.Produto.Produtos;

@ManagedBean (name = "PedidoMB")
@RequestScoped
    
public class PedidoMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Pedido produtos = new Pedido();

    public PedidoMB() {
    }

    public Pedido getProdutos() {
        return produtos;
    }

    public void setProdutos(Pedido produtos) {
        this.produtos = produtos;
    }
  
    /*public void cadastrar(){
            
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
    }*/
    
       public List<Pedido> listar() throws IOException {
        List pedidoList = new ArrayList<Pedido>();

        try {
            PedidoController pedidoController = new PedidoController();

            pedidoList = pedidoController.listar();

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return pedidoList;
    }
       public List<Cliente> listarCliente() throws IOException{
            List pedidoList = new ArrayList<Cliente>();

        try {
            ClienteController pedidoController = new ClienteController();

            pedidoList = pedidoController.listar();

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return pedidoList;
       }
        public void limparObjeto(){
    
        this.produtos = null;
         String url = "/dashPedido/dashboard_index_cadastrar.xhtml";

            RedirectMB redirectMB = new RedirectMB(url);       
    }
    

}
