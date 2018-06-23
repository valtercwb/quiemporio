
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
    
    public boolean cadastrar(Cliente clienteNovo) throws ExceptionError{
        
        ClienteDAO clienteCadastro = new ClienteDAO();
        boolean ret = clienteCadastro.cadastro(clienteNovo);
        return ret;
        
    }
    
    public boolean atualizar(Cliente clienteAtualizado) throws ExceptionError{
        
        ClienteDAO clienteAtualizar = new ClienteDAO();
        boolean ret = clienteAtualizar.atualizar(clienteAtualizado);
        return ret;
        
    }
    
    public boolean excluir (Cliente clienteExcluido) throws ExceptionError{
        
         ClienteDAO clienteExcluir = new ClienteDAO();
        boolean ret = clienteExcluir.excluir(clienteExcluido);
        return ret;
    }
}
