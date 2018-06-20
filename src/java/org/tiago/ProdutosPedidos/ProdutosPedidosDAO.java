
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
    
}
