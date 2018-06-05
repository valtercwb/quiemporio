
package org.tiago.Produto;

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
            
            System.out.println("oioioioi");
            
            throw new ExceptionError(e);
            
        }
        return retorno;
    }
    
    public boolean atualizar (Produtos prod) throws ExceptionError{
        
        boolean retorno = false;
               
        try {
            
            
        Database MyDB = new Database();            
            
        String sql = "UPDATE produtos SET valor_un = ?, nome = ?, quantidade = ? WHERE prod_id = ?;";
        
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
            
            String sql = "delete from produtos where prod_id = ?";
            
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
}
