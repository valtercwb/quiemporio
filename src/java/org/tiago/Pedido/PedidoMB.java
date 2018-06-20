
package org.tiago.Pedido;

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
import org.tiago.Cliente.Cliente;
import org.tiago.Cliente.ClienteController;
import org.tiago.Produto.ProdutoConstrutor;
import org.tiago.Produto.Produtos;
import org.tiago.ProdutosPedidos.Produtos_Pedidos;

@ManagedBean (name = "PedidoMB")
@SessionScoped
    
public class PedidoMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Pedido pedido = new Pedido();
    private Produtos produto = new Produtos();
    ArrayList<Produtos_Pedidos> ListaProdutosPedidos = new ArrayList<>();

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }


    public ArrayList<Produtos_Pedidos> getListaProdutosPedidos() {
        return ListaProdutosPedidos;
    }

    public void setListaProdutosPedidos(ArrayList<Produtos_Pedidos> ListaProdutosPedidos) {
        this.ListaProdutosPedidos = ListaProdutosPedidos;
    }
    
    
    
    public PedidoMB() {
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
      
       public List<Produtos_Pedidos> listarProdutosPedido() throws IOException{
            List pedidoList = new ArrayList<Produtos_Pedidos>();

        try {
            PedidoController pedidoController = new PedidoController();

            pedidoList = pedidoController.ListarProdutos();

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return pedidoList;
       } 
       
       public void limparObjeto(){
    
        
         String url = "/dashPedido/dashboard_index_cadastrar.xhtml";

         RedirectMB redirectMB = new RedirectMB(url);
            
        }
        
        
        public void adicionarListaProduto() throws IOException{
           
           Produtos_Pedidos ProdutosPedidos =  new Produtos_Pedidos();
           ProdutosPedidos.setPreco_produto(this.produto.getPreco_un());
           ProdutosPedidos.setProdId(this.produto.getProd_id());
           ProdutosPedidos.setQuantidade_produto(this.produto.getQuantidade());
           
           
           ListaProdutosPedidos.add(ProdutosPedidos);
            
        }
        
        public void excluirListaProduto(Produtos_Pedidos produto) throws IOException{
            
            ListaProdutosPedidos.remove(produto);
        }
          

}
