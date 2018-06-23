/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.me.Estatistica;

import com.mysql.fabric.xmlrpc.base.Data;
import java.sql.Date;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import org.me.util.SessionMB;

   
@ManagedBean (name = "EstatisticaMB")
@SessionScoped
public class estatisticaMB {


    private Date periodoFinal;
    private Date periodoInicial;
    private SessionMB sessionMB = new SessionMB();

    public Date getPeriodoFinal() {
        return periodoFinal;
    }

    public void setPeriodoFinal(Date periodoFinal) {
        this.periodoFinal = periodoFinal;
    }

    public Date getPeriodoInicial() {
        return periodoInicial;
    }

    public void setPeriodoInicial(Date periodoInicial) {
        this.periodoInicial = periodoInicial;
    }


   
    
    
}
