package org.me.user;

import org.me.exception.ExceptionError;

public class UserController {

    public User login(User user) throws ExceptionError {
        
        UserDao userDao = new UserDao();
        User retorno = userDao.login(user);
        return retorno;
        
    }
    
    
    public boolean cadastrar(User user) throws ExceptionError {
        
        UserDao userDao = new UserDao();
        boolean retorno = userDao.cadastrar(user);
        return retorno;
        
    }

}
