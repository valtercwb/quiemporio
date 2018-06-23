package org.me.user;

import java.sql.ResultSet;
import org.me.database.Database;
import org.me.exception.ExceptionError;

public class UserDao {

    public User login(User user) throws ExceptionError {
        User retorno = null;
        try {
            Database myDb = new Database();

            String sql = "SELECT * FROM usuario WHERE usu_email = ? AND usu_senha = MD5(?)";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, user.getEmail());
            myDb.setQueryParameter().setString(2, user.getPassword());

            //System.out.println(user.getLogin());
            //System.out.println(user.getPassword());
            ResultSet myResult = myDb.setQueryParameter().executeQuery();

            if (myResult.next()) {
                User userLogado = new User();
                
                userLogado.setId(myResult.getInt("usu_id"));
                userLogado.setEmail(myResult.getString("usu_email"));
                userLogado.setName(myResult.getString("usu_nome"));
                userLogado.setPassword(myResult.getString("usu_senha"));

                
                retorno = userLogado;
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }

    public boolean cadastrar(User user) throws ExceptionError {
        boolean retorno = false;
        try {
            Database myDb = new Database();
            
           

            String sql = "INSERT INTO usuario (usu_nome, usu_login, usu_senha, usu_email) "
                       + "VALUES (?, ?, MD5(?), ?)";
            myDb.setQuerySql(sql);

            myDb.setQueryParameter().setString(1, user.getName());
            myDb.setQueryParameter().setString(2, user.getLogin());
            myDb.setQueryParameter().setString(3, user.getPassword());
            myDb.setQueryParameter().setString(4, user.getEmail());

            if (myDb.setQueryParameter().executeUpdate()!=0) {
                retorno = true;
            }
        } catch (ExceptionError error) {
            throw new ExceptionError(error);
        } catch (Exception error) {
            throw new ExceptionError(error);
        }
        return retorno;

    }

}
