
package org.tiago.Produto;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;


public class ProdutoDAO {
    
    public boolean cadastrar (Produtos prod) throws ExceptionError {
        boolean retorno = false;
       
        try {
             
            Database MyDB = new Database();
            
            String sql = "insert into produtos(valor_un, nome, quantidade) values (?,?,?)";
            MyDB.setQuerySql(sql);
            
            MyDB.setQueryParameter().setDouble(1, prod.getPreco_un());
            MyDB.setQueryParameter().setString(2, prod.getNome());
            
            MyDB.setQueryParameter().setInt(3, prod.getQuantidade());
            
            if (MyDB.setQueryParameter().executeUpdate() != 0){
                
                retorno = true;
            }
            
        } catch (Exception e) {
                       
            throw new ExceptionError(e);
            
        }
        return retorno;
    }
    
    public boolean atualizar (Produtos prod) throws ExceptionError{
        
        boolean retorno = false;
               
        try {
            
            
        Database MyDB = new Database();            
            
        String sql = "UPDATE produtos SET valor_un = ?, nome = ?, quantidade = ? WHERE id_produtos = ?;";
        
        MyDB.setQuerySql(sql);
        
        MyDB.setQueryParameter().setDouble(1, prod.getPreco_un());
        MyDB.setQueryParameter().setString(2, prod.getNome());
        MyDB.setQueryParameter().setDouble(3, prod.getQuantidade());
        MyDB.setQueryParameter().setInt(4, prod.getProd_id());
        
        if(MyDB.setQueryParameter().executeUpdate() != 0){
            retorno = true;
        }
            
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
               return retorno;
    }

    public boolean excluir (Produtos prod) throws ExceptionError{
        
        boolean retorno = false;
        
        try {
            
            Database MyDB = new Database();
            
            String sql = "delete from produtos where id_produtos = ?";
            
            MyDB.setQuerySql(sql);
            MyDB.setQueryParameter().setInt(1, prod.getProd_id());
            
            if (MyDB.setQueryParameter().executeUpdate() != 0){
                
                retorno = true;
            }
            
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        return retorno;
    }
    
     public List<Produtos> listar() throws ExceptionError {
        ArrayList<Produtos> retorno = new ArrayList<Produtos>();

        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM produtos";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Produtos user = new Produtos();
                
                user.setProd_id(myResult.getInt("id_produtos"));
                user.setNome(myResult.getString("nome"));
                user.setQuantidade(myResult.getInt("quantidade"));
                user.setPreco_un(myResult.getDouble("valor_un"));
                user.setData_adicionado(myResult.getTimestamp("data_adicionado"));
                
                retorno.add(user);
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
     
     public Produtos buscar(int id) throws ExceptionError {
        Produtos retorno = new Produtos();

        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM produtos WHERE id_produtos = ?";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setInt(1, id);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            if (myResult.next()) {
                retorno.setProd_id(myResult.getInt("id_produtos"));
                retorno.setNome(myResult.getString("nome"));
                retorno.setPreco_un(myResult.getDouble("valor_un"));
                retorno.setQuantidade(myResult.getInt("quantidade"));
                
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }
}
