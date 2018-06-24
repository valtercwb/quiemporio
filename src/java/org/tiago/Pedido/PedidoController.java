
package org.tiago.Pedido;

import java.sql.SQLException;
import java.util.List;
import org.me.exception.ExceptionError;
import org.tiago.ProdutosPedidos.ProdutosPedidosDAO;
import org.tiago.ProdutosPedidos.Produtos_Pedidos;


public class PedidoController {
    
    public List<Pedido> listar(int id) throws ExceptionError{
        
        PedidoDAO pedido = new PedidoDAO();
        List pedidos = pedido.listar(id);
        
        return pedidos;
    }
    
    public List<Produtos_Pedidos> ListarProdutos() throws ExceptionError{
        
        ProdutosPedidosDAO pedido = new ProdutosPedidosDAO();
        List pedidos = pedido.listarProdutos();
        
        return pedidos;
        
    }
    
    public int inserirPedido (Pedido pedido) throws ExceptionError, SQLException{
        PedidoDAO insertpedido = new PedidoDAO();
        int idPedido = insertpedido.inserir(pedido);
        return idPedido;
    }
    
    public boolean excluirPedido (Pedido pedido) throws ExceptionError{
         PedidoDAO excluipedido = new PedidoDAO();
        boolean idPedido = excluipedido.excluir(pedido);
        return idPedido;
    }
    
}
