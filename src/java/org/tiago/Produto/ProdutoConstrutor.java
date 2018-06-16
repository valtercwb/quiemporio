package org.tiago.Produto;


import java.util.ArrayList;
import java.util.List;
import org.me.exception.ExceptionError;




public class ProdutoConstrutor {
    
    public boolean cadastrar (Produtos produtos) throws ExceptionError{
        
        ProdutoDAO produto = new ProdutoDAO();
        
        boolean ret = produto.cadastrar(produtos);
        
        return ret;
        
    }
    
    public List<Produtos> listar() throws ExceptionError{
        
        ProdutoDAO produto = new ProdutoDAO();
        List produtos = produto.listar();
        
        return produtos;
    }
    
}
