
package org.tiago.Pedido;

import java.util.List;
import org.me.exception.ExceptionError;
import org.tiago.ProdutosPedidos.ProdutosPedidosDAO;
import org.tiago.ProdutosPedidos.Produtos_Pedidos;


public class PedidoController {
    
    public List<Pedido> listar() throws ExceptionError{
        
        PedidoDAO pedido = new PedidoDAO();
        List pedidos = pedido.listar();
        
        return pedidos;
    }
    
    public List<Produtos_Pedidos> ListarProdutos() throws ExceptionError{
        
        ProdutosPedidosDAO pedido = new ProdutosPedidosDAO();
        List pedidos = pedido.listarProdutos();
        
        return pedidos;
        
    }
    
}
