
package org.tiago.Pedido;

import java.sql.Timestamp;


public class Pedido {
    
    private int ped_id;
    private Timestamp ped_data;
    private double ped_valor_total;
    private int vendedor_vend_id;
    private int cliente_cli_id;

    public int getPed_id() {
        return ped_id;
    }

    public void setPed_id(int ped_id) {
        this.ped_id = ped_id;
    }

    public Timestamp getPed_data() {
        return ped_data;
    }

    public void setPed_data(Timestamp ped_data) {
        this.ped_data = ped_data;
    }

    public double getPed_valor_total() {
        return ped_valor_total;
    }

    public void setPed_valor_total(double ped_valor_total) {
        this.ped_valor_total = ped_valor_total;
    }

    public int getVendedor_vend_id() {
        return vendedor_vend_id;
    }

    public void setVendedor_vend_id(int vendedor_vend_id) {
        this.vendedor_vend_id = vendedor_vend_id;
    }

    public int getCliente_cli_id() {
        return cliente_cli_id;
    }

    public void setCliente_cli_id(int cliente_cli_id) {
        this.cliente_cli_id = cliente_cli_id;
    }

    public Pedido() {
    }

    public Pedido(int ped_id, Timestamp ped_data, double ped_valor_total, int vendedor_vend_id, int cliente_cli_id) {
        this.ped_id = ped_id;
        this.ped_data = ped_data;
        this.ped_valor_total = ped_valor_total;
        this.vendedor_vend_id = vendedor_vend_id;
        this.cliente_cli_id = cliente_cli_id;
    }
    
}
