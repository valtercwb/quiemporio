package org.tiago.Produto;


import java.util.ArrayList;
import java.util.List;
import org.me.exception.ExceptionError;
import org.tiago.ProdutosPedidos.ProdutosPedidosDAO;




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
    
    public Produtos buscar(Produtos produto) throws ExceptionError {
        
        ProdutoDAO produtoDao = new ProdutoDAO();
        Produtos retorno = produtoDao.buscar(produto);
        return retorno;
        
    }
    
    public boolean alterar (Produtos produtos) throws ExceptionError{
        
        ProdutoDAO produto = new ProdutoDAO();
        boolean ret = produto.atualizar(produtos);
        return ret;
    }

    public boolean excluir (Produtos produtos) throws ExceptionError{
        
        ProdutoDAO produtoExcluir = new ProdutoDAO();
        boolean ret = produtoExcluir.excluir(produtos);
        return ret;
        
    }
}
