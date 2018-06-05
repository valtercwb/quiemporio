package org.me.util;

import java.io.IOException;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;


public class RedirectMB {
    
    private String url;

    public RedirectMB(String url) {
        try {
            this.url = url;
            ExternalContext context = FacesContext.getCurrentInstance().getExternalContext();
            context.redirect(context.getRequestContextPath() + url);
            
        } catch (IOException error) {
            new MessageMB(null, "Não foi possível redirecionar o site! "+error.getMessage(), "", 3);
        }
    }
  
    
}
