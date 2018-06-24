
package org.tiago.ProdutosPedidos;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import org.me.database.Database;
import org.me.exception.ExceptionError;
import org.tiago.Produto.Produtos;

public class ProdutosPedidosDAO {
    
    public List<Produtos_Pedidos> listarProdutos () throws ExceptionError{
        
         ArrayList<Produtos_Pedidos> retorno = new ArrayList<Produtos_Pedidos>();

        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM quiemporio.pedidos_has_produtos\n" +
                         "inner join produtos on produtos.id_produtos = produtos_id_produtos\n" +
                         "where pedidos_ped_id = 3;";
            myDb.setQuerySql(sql);

            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            while(myResult.next()) {
                Produtos_Pedidos produtopedido = new Produtos_Pedidos();
                Produtos produto = new Produtos();
                
                produtopedido.setPedId(myResult.getInt("produtos_id_produtos"));
                produto.setNome(myResult.getString("nome"));
                produtopedido.setProdutos(produto);
                produtopedido.setPreco_produto(myResult.getDouble("valor_un"));
                produtopedido.setQuantidade_produto(myResult.getInt("quantidade"));
                
                retorno.add(produtopedido);
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;
        
    }
    
    public boolean inserirProdutos (ArrayList<Produtos_Pedidos> produtosPedidos) throws ExceptionError{
         boolean b = false;
        try {
            Database MyDB = new Database();
            String sql = "INSERT INTO pedidos_has_produtos (`pedidos_ped_id`, `produtos_id_produtos`, `quantidade`, `valor_produto`) \n" +
                            "VALUES (?, ?, ?, ?);";
                
            MyDB.setQuerySql(sql);
            
            for (Produtos_Pedidos produtosPedido : produtosPedidos) {
                MyDB.setQueryParameter().setInt(1, produtosPedido.getPedId());
                MyDB.setQueryParameter().setInt(2, produtosPedido.getProdId());
                MyDB.setQueryParameter().setInt(3, produtosPedido.getQuantidade_produto());
                MyDB.setQueryParameter().setDouble(4, produtosPedido.getPreco_produto());
                MyDB.setQueryParameter().executeUpdate();
            }
            b = true;
            
                        
        } catch (Exception e) {
            throw new ExceptionError(e);
        }
        return b;
    }
}
