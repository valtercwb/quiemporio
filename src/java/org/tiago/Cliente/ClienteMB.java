
package org.tiago.Cliente;

import br.com.parg.viacep.ViaCEP;
import br.com.parg.viacep.ViaCEPEvents;
import br.com.parg.viacep.ViaCEPException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;
import static org.primefaces.component.calendar.Calendar.PropertyKeys.locale;
import org.tiago.endereco.Endereco;

@ManagedBean (name = "ClienteMB")
@SessionScoped
public class ClienteMB implements ViaCEPEvents{
       
    private SessionMB sessionMB = new SessionMB();
    private Cliente clientela = new Cliente();
    private Endereco endereco = new Endereco();

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

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
    
    public void cadastrar() throws IOException{
        
        try {
            ClienteController clienteCadastro = new ClienteController();
            this.clientela.setEnderecoCompleto(this.endereco);
            if(clienteCadastro.cadastrar(this.clientela)){
                 new MessageMB("msgInfo", "Cliente cadastro!", "", 1);
                 setClientela(new Cliente());
                setEndereco(new Endereco());
            }else{
                new MessageMB("msgInfo", "Cliente não cadastrado!", "", 3);
            }
            
        } catch (Exception e) {
            new MessageMB("msgInfo", e.getMessage(), "", 4);
        }
    }
   
    public void atualizar() throws IOException{
        
        try {
            ClienteController clienteAtualizar = new ClienteController();
            
            if(clienteAtualizar.atualizar(this.clientela)){
                
             new MessageMB("msgInfo", "Cliente atualizado!", "", 1);
             
                setClientela(new Cliente());
                setEndereco(new Endereco());
            }else{
                new MessageMB("msgInfo", "Produto não alterado!", "", 3);
            }
            
        } catch (Exception e) {
        }
    }
    
     public void buscar(Cliente cliente) throws IOException {
        try {
              
            setClientela(cliente);
            setEndereco(cliente.getEnderecoCompleto());
            String url = "/dashCli/dashboard_clientes_Alterar.xhtml";

            RedirectMB redirectMB = new RedirectMB(url);
            
        } catch (Exception error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

    }
 
    public void excluir (Cliente cliente) throws IOException{
       
        try {
            ClienteController clienteExcluir = new ClienteController();
            if(clienteExcluir.excluir(cliente)){
                new MessageMB("msgInfo", "Cliente excluido!", "", 1);
            }else{
                new MessageMB("msgInfo", "Cliente não excluido!", "", 3);
            }
        } catch (Exception e) {
            new MessageMB("msgInfo", e.getMessage(), "", 3);
        }
    } 
     
    public void limparObjeto(){
         String url = "/dashCli/dashboard_clientes_cadastrar.xhtml";

            RedirectMB redirectMB = new RedirectMB(url);       
    }
    
    public void buscarEndereco(String cep) {
        ViaCEP viaCEP = new ViaCEP(this);
            if (!cep.equals("")) {
                try {
                    viaCEP.buscar(cep);
                } catch (ViaCEPException ex) {
                    System.err.println("Ocorreu um erro na classe " + ex.getClasse() + ": " + ex.getMessage());
                }
            }
    }
    
    @Override
    public void onCEPSuccess(ViaCEP cep) {
        this.endereco.setEnd_nome(cep.getLogradouro());
        this.endereco.setBairro(cep.getBairro());
        this.endereco.setCidade(cep.getLocalidade());
        this.endereco.setUf(cep.getUf());
         String url = "/dashCli/dashboard_clientes_cadastrar.xhtml";
         RedirectMB redirectMB = new RedirectMB(url); 
    }

    @Override
    public void onCEPError(String cep) {
        System.out.println();
        System.out.println("Não foi possível encontrar o CEP " + cep + "!");
        System.out.println();
    }
}
