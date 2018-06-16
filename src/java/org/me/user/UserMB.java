package org.me.user;

import java.io.IOException;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import org.me.exception.ExceptionError;
import org.me.util.MessageMB;
import org.me.util.RedirectMB;
import org.me.util.SessionMB;

@ManagedBean(name = "userMB")
@RequestScoped

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

            if (userController.login(this.user)) {

                boolean auth = true;
                sessionMB.setAttribute("auth", auth);

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
