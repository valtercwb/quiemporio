package org.me.user;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean(name = "userMB")
@SessionScoped

public class UserMB {

    private SessionMB sessionMB = new SessionMB();
    private User user = new User();

    public UserMB() {
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void login() throws IOException {
        try {
            UserController userController = new UserController();
            user = userController.login(this.user);
            if (user.getName() != null){
                boolean auth = true;
                sessionMB.setAttribute("auth", auth);
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("nome", user.getName());

                String url = "/dashPedido/dashboard_index.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "Usuário ou Senha inválidos!", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

    }
    
    public String logout(){
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("nome");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

    public void cadastrar() throws IOException {
        try {
            UserController userController = new UserController();

            if (userController.cadastrar(this.user)) {

                boolean auth = true;
                sessionMB.setAttribute("auth", auth);

                String url = "/site/cadastrar_ok.xhtml";
                new RedirectMB(url);
            } else {
                new MessageMB("msgInfo", "Usuário não cadastrado!", "", 3);
                //return null;
            }
        } catch (ExceptionError error) {
            new MessageMB("msgInfo", error.getMessage(), "", 4);
        }

    }
    
    public void mudaTelaCadastro (){
       
       
       sessionMB.setAttribute("auth", true);
                
                String url= "/CrudProduto.xhtml";
                new RedirectMB(url);
   }
    public void mudaTelaCadastroUsuario (){
       
       
       sessionMB.setAttribute("auth", true);
                
                String url= "/signin.xhtml";
                new RedirectMB(url);
   }
   public void mudaTelaEditar (){
       
       
       sessionMB.setAttribute("auth", true);
                
                String url= "/Atualizar.xhtml";
                new RedirectMB(url);
   }

}
