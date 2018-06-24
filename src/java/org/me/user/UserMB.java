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
    
    public void userSeguranca(){
        
        Object logado = sessionMB.getAttribute("auth");
        
        if(logado==null){
            String url = "/index.xhtml";
            new RedirectMB(url);   
         
        }
        
    }
    public User getSessionUser(String user){
        return (User) sessionMB.getAttribute("user");
    }
    
    public void logout() throws IOException, ExceptionError{
        boolean auth = true;
 
        sessionMB.setAttribute("auth", auth);
        sessionMB.setAttribute("user", null);
       String url = "/index.xhtml";
            new RedirectMB(url);  
    }
    
        public void login() throws IOException {
        try {
            UserController userController = new UserController();

            User userLogado = userController.login(this.user);
            
            if (userLogado!=null) {

                boolean auth = true;
                sessionMB.setAttribute("auth", auth);
                sessionMB.setAttribute("user", userLogado);

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
    
<<<<<<< HEAD
    public String logout2() {
        FacesContext.getCurrentInstance().getExternalContext().getSessionMap().remove("nome");
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
        return "login";
    }

=======




>>>>>>> b457254db38df30b4a1f3c22b1c7c21555bc9dff
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

}
