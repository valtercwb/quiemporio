
package org.tiago.Pedido;

import com.mysql.fabric.xmlrpc.Client;
import java.sql.Connection;
import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.tiago.Cliente.Cliente;
import org.tiago.Produto.Produtos;


public class PedidoDAO {
    
    public List<Pedido> listar(int id) throws ExceptionError{
         ArrayList<Pedido> retorno = new ArrayList<Pedido>();

        try {
            Database myDb = new Database();

            String sql = "SELECT p.ped_id,c.nome, en.CEP, p.data, p.ped_valor_total FROM pedidos as p\n" +
                        "inner join cliente as c on p.cliente_cli_id = c.cli_id\n" +
                        "inner join endereco as en on c.endereco_end_id = en.end_id"
                    + "  where p.usuario_usu_id = ? order by p.data;";
            myDb.setQuerySql(sql);
            myDb.setQueryParameter().setInt(1, id);
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
    
    public int inserir(Pedido pedido) throws ExceptionError, SQLException{
            int idPedido = 0;
            Database MyDB = new Database();
            String sql = "INSERT INTO pedidos (cliente_cli_id, ped_valor_total, usuario_usu_id)" +
                    "VALUES (?, ?, ?);";
            Connection connection = MyDB.preStatement.getConnection();
            PreparedStatement stmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
            stmt.setInt(1, pedido.getCliente_cli_id());
            stmt.setDouble(2, pedido.getPed_valor_total());
            stmt.setInt(3, pedido.getVendedor_vend_id());
            ResultSet rs = MyDB.setQueryParameter().getGeneratedKeys();
            if (MyDB.setQueryParameter().executeUpdate() != 0 && rs.getInt(1) != 0){
                
                
                idPedido = rs.getInt(1);
            }
        
        return idPedido;
    }

    public boolean excluir (Pedido pedido) throws ExceptionError{
        
        boolean retorno = false;
        
        try {
            
            Database MyDB = new Database();
            
            String sql = "delete from pedidos where ped_id = ?";
            
            MyDB.setQuerySql(sql);
            MyDB.setQueryParameter().setInt(1, pedido.getPed_id());
            
            if (MyDB.setQueryParameter().executeUpdate() != 0){
                
                retorno = true;
            }
            
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        return retorno;
    }
}
