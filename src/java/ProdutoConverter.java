
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;
import org.me.exception.ExceptionError;
import org.tiago.Produto.ProdutoDAO;
import org.tiago.Produto.Produtos;
    
@FacesConverter(value = "ProdutoConverte", forClass = Produtos.class)
public class ProdutoConverter implements javax.faces.convert.Converter{
    
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string != null && !string.isEmpty()) {
             ProdutoDAO produtoDao = new ProdutoDAO();
            try {
                return produtoDao.buscar(Integer.parseInt(string));
            } catch (ExceptionError ex) {
                Logger.getLogger(ProdutoConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o != null && (o instanceof Produtos)) {
            return String.valueOf(((Produtos) o).getProd_id());
        }

        return null;
    }


}
