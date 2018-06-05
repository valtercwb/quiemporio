
package org.me.user;

import org.me.exception.ExceptionError;


public class testeUser {
   
    public static void main(String args[]) throws ExceptionError{
        UserController userController = new UserController();
       
        System.out.println(userController.cadastrar(new User()));
    }
}
