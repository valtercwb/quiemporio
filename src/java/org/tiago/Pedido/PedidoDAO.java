
package org.tiago.Pedido;

import com.mysql.fabric.xmlrpc.Client;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.tiago.Cliente.Cliente;
import org.tiago.Produto.Produtos;


public class PedidoDAO {
    
    public List<Pedido> listar() throws ExceptionError{
         ArrayList<Pedido> retorno = new ArrayList<Pedido>();

        try {
            Database myDb = new Database();

            String sql = "SELECT p.ped_id,c.nome, en.CEP, p.data, p.ped_valor_total FROM pedidos as p\n" +
                        "inner join cliente as c on p.cliente_cli_id = c.cli_id\n" +
                        "inner join endereco as en on c.endereco_end_id = en.end_id;";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Pedido pedido = new Pedido();
                Cliente cli = new Cliente();
                pedido.setPed_id(myResult.getInt("ped_id"));
                cli.setNome(myResult.getString("nome"));
                pedido.setCliente(cli);
                pedido.setCEP_cli(myResult.getString("CEP"));
                pedido.setPed_data(myResult.getTimestamp("data"));
                pedido.setPed_valor_total(myResult.getDouble("ped_valor_total"));
                
                retorno.add(pedido);
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;
                
    }
    
}
