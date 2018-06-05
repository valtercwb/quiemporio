package org.tiago.Produto;


import org.me.exception.ExceptionError;




public class ProdutoConstrutor {
    
    public boolean cadastrar (Produtos produtos) throws ExceptionError{
        
        ProdutoDAO produto = new ProdutoDAO();
        
        boolean ret = produto.cadastrar(produtos);
        
        return ret;
        
    }
    
}
