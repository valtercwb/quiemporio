
package org.tiago.Pedido;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.event.ValueChangeEvent;
import org.me.exception.ExceptionError;
import org.me.user.UserMB;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;
import org.tiago.Cliente.Cliente;
import org.tiago.Cliente.ClienteController;
import org.tiago.Produto.ProdutoDAO;
import org.tiago.Produto.Produtos;
import org.tiago.ProdutosPedidos.ProdutosPedidosDAO;
import org.tiago.ProdutosPedidos.Produtos_Pedidos;

@ManagedBean (name = "PedidoMB")
@SessionScoped
    
public class PedidoMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Pedido pedido = new Pedido();
    private Produtos produto = new Produtos();
    private int quantidadeEdit; 
    private double d_Valor_Total;

    public double getD_Valor_Total() {
        return d_Valor_Total;
    }

    public void setD_Valor_Total(double d_Valor_Total) {
        this.d_Valor_Total = d_Valor_Total;
    }
    
    
    public int getQuantidadeEdit() {
        return quantidadeEdit;
    }

    public void setQuantidadeEdit(int quantidadeEdit) {
        this.quantidadeEdit = quantidadeEdit;
    }
   
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
    
       public void buscaProduto (ValueChangeEvent event) throws ExceptionError{
            Integer valor = ((Integer) event.getNewValue());
           ProdutoDAO buscaProduto = new ProdutoDAO();
           Produtos pro = buscaProduto.buscar(valor);
           
            setProduto(pro);          
        
       } 
        
       public List<Pedido> listar() throws IOException {
        List pedidoList = new ArrayList<Pedido>();
        UserMB user = new UserMB();
        try {
            PedidoController pedidoController = new PedidoController();

            pedidoList = pedidoController.listar(user.getSessionUser("user").getId());

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
        
        
        public void adicionarListaProduto() throws IOException, ExceptionError{
           
           Produtos_Pedidos ProdutosPedidos =  new Produtos_Pedidos();
           Produtos produtin = new Produtos();
           ProdutosPedidos.setPedId(3);
           ProdutosPedidos.setPreco_produto(this.produto.getPreco_un());
           ProdutosPedidos.setProdId(this.produto.getProd_id());
           ProdutosPedidos.setQuantidade_produto(getQuantidadeEdit());
           produtin.setNome(this.produto.getNome());
           ProdutosPedidos.setProdutos(produtin);
            setD_Valor_Total(d_Valor_Total + (this.produto.getPreco_un()* getQuantidadeEdit()));
           ListaProdutosPedidos.add(ProdutosPedidos);
            
        }
        
        public void excluirListaProduto(Produtos_Pedidos produto) throws IOException{
            setD_Valor_Total(d_Valor_Total - (produto.getPreco_produto()* produto.getQuantidade_produto()));
            ListaProdutosPedidos.remove(produto);
        }
        
        public void excluirTudoListaProduto(){
            setD_Valor_Total(0);
            ListaProdutosPedidos.removeAll(ListaProdutosPedidos);
        }
        
        public void gerarPedido () throws IOException{
            
            
        }
        
        public void salvarPedido () throws IOException, ExceptionError{
            PedidoDAO inserir = new PedidoDAO();
            
        try {
            UserMB user = new UserMB();
            pedido.setPed_valor_total(d_Valor_Total);
            pedido.setVendedor_vend_id(user.getSessionUser("User").getId());          
            System.out.println("" + inserir.inserir(pedido));
            
        } catch (SQLException e) {
             new MessageMB("msgInfo", e.getMessage(), "", 4);
        }
            
        }
        
        public void salvarProdutosPedido () throws IOException, ExceptionError{
            ProdutosPedidosDAO inserir = new ProdutosPedidosDAO();
            
            
             try {
                if (inserir.inserirProdutos(ListaProdutosPedidos)){
             
                new MessageMB("msgInfo", "Pedido Inserido", "", 1);
                ListaProdutosPedidos.removeAll(ListaProdutosPedidos);
                    setQuantidadeEdit(0);
                    setProduto(null);
            }else{
                new MessageMB("msgInfo", "Produto não cadastrado!", "", 3);
            }
                
            }catch (Exception e) {
          
            new MessageMB("msgInfo", e.getMessage(), "", 4);
            }

        }

        public void excluirPedido (Pedido pedido) throws IOException {
            
            try {
                PedidoController exclusaoPedido = new PedidoController();
                if (exclusaoPedido.excluirPedido(pedido)){
                    new MessageMB("msgInfo", "Pedido excluido!", "", 1);   
                }else{
                            new MessageMB("msgInfo", "Pedido não excluido!", "", 3);   
                            }
                               
                
            } catch (Exception e) {
               new MessageMB("msgInfo", e.getMessage(), "", 4);                            
            }
            
        }
}
