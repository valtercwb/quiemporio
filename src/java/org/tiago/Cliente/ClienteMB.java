
package org.tiago.Cliente;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.SessionMB;

@ManagedBean (name = "ClienteMB")
@RequestScoped
public class ClienteMB {
    
    private SessionMB sessionMB = new SessionMB();
    private Cliente clientela = new Cliente();

    public ClienteMB() {
    }

        
    public Cliente getClientela() {
        return clientela;
    }

    public void setClientela(Cliente clientela) {
        this.clientela = clientela;
    }
    
    public List<Cliente> listar() throws IOException {
        List clienteList = new ArrayList<Cliente>();

        try {
            ClienteController clienteController = new ClienteController();

            clienteList = clienteController.listarTudo();

        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

        return clienteList;
        }
    
    
    
}
