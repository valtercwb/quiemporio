
package org.tiago.Cliente;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.tiago.Pedido.Pedido;
import org.tiago.endereco.Endereco;


public class ClienteDAO {
    
    
    public List<Cliente> listar() throws ExceptionError{
         ArrayList<Cliente> retorno = new ArrayList<Cliente>();

        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM cliente";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Cliente clientes = new Cliente();
                
                
                clientes.setNome(myResult.getString("nome"));
                clientes.setCNPJ(myResult.getString("CNPJ"));
 
                retorno.add(clientes);
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;
                
    }
    
     public List<Cliente> listarCompleto() throws ExceptionError{
         ArrayList<Cliente> retorno = new ArrayList<Cliente>();

        try {
            Database myDb = new Database();

            String sql = "SELECT nome, CNPJ, end_nome, numero, CEP FROM cliente " +
                            "inner join endereco on endereco_end_id = endereco.end_id;";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Cliente clientes = new Cliente();
                Endereco clienteEnd = new Endereco();
                
                clientes.setNome(myResult.getString("nome"));
                clientes.setCNPJ(myResult.getString("CNPJ"));
                clienteEnd.setEnd_nome(myResult.getString("end_nome"));
                clienteEnd.setEnd_numero(myResult.getInt("numero"));
                clienteEnd.setCEP(myResult.getString("CEP"));
           
                clientes.setEnderecoCompleto(clienteEnd);
                

                retorno.add(clientes);
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;
                
    }
    
}
