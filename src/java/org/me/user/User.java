
package org.me.user;


public class User {
    private int id;
    private String name;
    private String login;
    private String password;
    private String email;
    private int usu_tipo_usu;

    public int getUsu_tipo_usu() {
        return usu_tipo_usu;
    }

    public void setUsu_tipo_usu(int usu_tipo_usu) {
        this.usu_tipo_usu = usu_tipo_usu;
    }

    public User() {
    }

    public User(int id, String name, String login, String password, String email, int usu_tipo_usu) {
        this.id = id;
        this.name = name;
        this.login = login;
        this.password = password;
        this.email = email;
        this.usu_tipo_usu = usu_tipo_usu;
    }
    
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    
    
}
