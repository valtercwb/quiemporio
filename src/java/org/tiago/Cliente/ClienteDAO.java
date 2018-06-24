
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

            String sql = "SELECT cli_id, nome, CNPJ, end_nome, numero, CEP FROM cliente " +
                            "inner join endereco on endereco_end_id = endereco.end_id;";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Cliente clientes = new Cliente();
                Endereco clienteEnd = new Endereco();
                clientes.setCliente_Id(myResult.getInt("cli_id"));
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
    
    public boolean cadastro(Cliente cliente) throws ExceptionError{
        boolean ret = false;
        try {
            Database myDb = new Database();

            String sql = "call sp_cadastro_cliente(?, ?, ?, ?, ?, ?, ?, ?, ?)";
            myDb.setQuerySql(sql);
            
            myDb.setQueryParameter().setString(1, cliente.getNome());
            myDb.setQueryParameter().setString(2, cliente.getCNPJ());
            myDb.setQueryParameter().setString(3, cliente.getEnderecoCompleto().getEnd_nome());
            myDb.setQueryParameter().setInt(4, cliente.getEnderecoCompleto().getEnd_numero());
            myDb.setQueryParameter().setString(5, cliente.getEnderecoCompleto().getEnd_complemento());
            myDb.setQueryParameter().setString(6, cliente.getEnderecoCompleto().getCEP());            
            myDb.setQueryParameter().setString(7, cliente.getEnderecoCompleto().getBairro());
            myDb.setQueryParameter().setString(8, cliente.getEnderecoCompleto().getCidade());
            myDb.setQueryParameter().setString(9, cliente.getEnderecoCompleto().getUf());
            
            if (myDb.setQueryParameter().executeUpdate() != 0){
                ret = true;
               
            }
            myDb.setQueryParameter().close();
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        
        return ret;
    }

    public boolean atualizar (Cliente cliente) throws ExceptionError{
        
        boolean ret = false;
        try {
            Database myDb = new Database();

            String sql = "call sp_atualizar_cliente(?, ?, ?, ?, ?, ?, ?)";
            myDb.setQuerySql(sql);
            
            myDb.setQueryParameter().setInt(1, cliente.getCliente_Id());
            myDb.setQueryParameter().setString(2, cliente.getNome());
            myDb.setQueryParameter().setString(3, cliente.getCNPJ());
            myDb.setQueryParameter().setString(4, cliente.getEnderecoCompleto().getEnd_nome());
            myDb.setQueryParameter().setInt(5, cliente.getEnderecoCompleto().getEnd_numero());
            myDb.setQueryParameter().setString(6, cliente.getEnderecoCompleto().getEnd_complemento());
            myDb.setQueryParameter().setString(7, cliente.getEnderecoCompleto().getCEP());
            myDb.setQueryParameter().setString(8, cliente.getEnderecoCompleto().getBairro());
            myDb.setQueryParameter().setString(9, cliente.getEnderecoCompleto().getCidade());
            myDb.setQueryParameter().setString(10, cliente.getEnderecoCompleto().getUf());
        if (myDb.setQueryParameter().executeUpdate() != 0){
                ret = true;
               
            }
            myDb.setQueryParameter().close();
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        
        return ret;
    }

    public boolean excluir (Cliente cliente) throws ExceptionError{
        boolean ret = false;
        try {
            Database myDb = new Database();

            String sql = "call sp_excluir_cliente(?)";
            myDb.setQuerySql(sql);
            
            myDb.setQueryParameter().setInt(1, cliente.getCliente_Id());
           
        if (myDb.setQueryParameter().executeUpdate() != 0){
                ret = true;
               
            }
            myDb.setQueryParameter().close();
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        
        return ret;
    }
}
