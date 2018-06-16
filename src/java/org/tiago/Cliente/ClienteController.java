
package org.tiago.Cliente;

import java.util.List;
import org.me.exception.ExceptionError;
import org.tiago.Pedido.Pedido;
import org.tiago.Pedido.PedidoDAO;


public class ClienteController {
    
    public List<Cliente> listar() throws ExceptionError{
        
        ClienteDAO cliente = new ClienteDAO();
        List clientes = cliente.listar();
        
        return clientes;
    }
    
    public List<Cliente> listarTudo() throws ExceptionError{
        
        ClienteDAO clientes = new ClienteDAO();
        List clientela = clientes.listarCompleto();
        
        return clientela;
    }
    
}
