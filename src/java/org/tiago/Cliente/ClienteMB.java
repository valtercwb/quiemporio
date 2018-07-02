
package org.tiago.Cliente;
import static java.nio.charset.StandardCharsets.*;
import org.tiago.endereco.ViaCEP;
import org.tiago.endereco.ViaCEPEvents;
import org.tiago.endereco.ViaCEPException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import org.me.exception.ExceptionError;
import org.me.user.UserMB;
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
        try {
            List clienteList = new ArrayList<Cliente>();
            UserMB user = new UserMB();
            ClienteController clienteController = new ClienteController();
            clienteList = clienteController.listarTudo();
            if(clienteList!=null){
            return clienteList;
            }else{
             return null;
            }
        } catch (ExceptionError ex) {
            Logger.getLogger(ClienteMB.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
    public void cadastrar() throws IOException{
        
        try {
            UserMB user = new UserMB();
            ClienteController clienteCadastro = new ClienteController();
            clientela.setUsu_id(user.getSessionUser("user").getId());
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
    
     public void RedirectToCadastro(){
        String url = "/dashCli/dashboard_clientes_cadastrar.xhtml";
        RedirectMB redirectMB = new RedirectMB(url);       
    }
     
    public void limparObjeto(){
        this.endereco.setEnd_nome("");
        this.endereco.setBairro("");
        this.endereco.setCidade("");
        this.endereco.setUf("");
        this.endereco.setEnd_complemento("");
        this.endereco.setEnd_numero(0);
        this.endereco.setCEP("");
        this.clientela.setCNPJ("");
        this.clientela.setNome("");
        String url = "/dashCli/dashboard_clientes.xhtml";
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
        String logradouro = cep.getLogradouro();        
        String bairro = cep.getBairro();
        String cidade = cep.getLocalidade();

        byte[] loByte;         
        byte[] baByte; 
        byte[] ciByte; 

        loByte = logradouro.getBytes(ISO_8859_1);            
        baByte = bairro.getBytes(ISO_8859_1);
        ciByte = cidade.getBytes(ISO_8859_1);
        String logradouroEncoded = new String(loByte, UTF_8);        
        String bairroEncoded = new String(baByte, UTF_8);
        String cidadeEncoded = new String(ciByte, UTF_8);
        this.endereco.setEnd_nome(logradouroEncoded);
        this.endereco.setBairro(bairroEncoded);
        this.endereco.setCidade(cidadeEncoded);
        this.endereco.setUf(cep.getUf());
//        String url = "/dashCli/dashboard_clientes_cadastrar.xhtml";
//        RedirectMB redirectMB = new RedirectMB(url);
    }

    @Override
    public void onCEPError(String cep) {
        System.out.println();
        System.out.println("Não foi possível encontrar o CEP " + cep + "!");
        System.out.println();
    }
	private static List<Cliente> data = new ArrayList<Cliente>();
//	static {
//		data.add(new Cliente("Egypt" , "Cairo, Egypt", "Africa"));
//		data.add(new Cliente("Germany" , "Berlin, Germany", "Europe"));
//		data.add(new Cliente("Austria" , "Vienna, Austria", "Europe"));
//		data.add(new Cliente("US" , "Washington, USA", "North America"));
//		data.add(new Cliente("China" , "Beijing, China", "Asia"));
//		data.add(new Cliente("Brazil" , "Brazilia, Brazil", "South America"));		
//	}

	public List<Cliente> getData() {
		return data;
	}

	public void setData(List<Cliente> data) {
		this.data = data;
	}	
    
}
