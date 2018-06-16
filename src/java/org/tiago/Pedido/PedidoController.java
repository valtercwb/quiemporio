
package org.tiago.Pedido;

import java.util.List;
import org.me.exception.ExceptionError;


public class PedidoController {
    
    public List<Pedido> listar() throws ExceptionError{
        
        PedidoDAO pedido = new PedidoDAO();
        List pedidos = pedido.listar();
        
        return pedidos;
    }
    
}
