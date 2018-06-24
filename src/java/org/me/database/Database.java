package org.me.database;

import java.sql.*;
import org.me.exception.ExceptionError;
import org.me.exception.LibraryError;

public class Database {

    public Connection conexao;
    public Statement statement;
    public PreparedStatement preStatement;
    private String mensagem;

    //--------------------------------------------------------------------------
    public void open() throws ExceptionError {
        
        try {
            String driver;
            String url;
            String usuario;
            String senha;

            driver = "com.mysql.fabric.jdbc.FabricMySQLDriver";
            url = "jdbc:mysql://localhost/quiemporio";
            usuario = "root";
            senha = "2429";

            DriverManager.registerDriver(new com.mysql.jdbc.Driver());

            this.conexao = DriverManager.getConnection(url, usuario, senha);
            this.statement = conexao.createStatement();
        } catch (Exception error) {
            mensagem = "Erro ao conectar na base de dados.\n";
            mensagem = mensagem + error.getMessage();             
            throw new ExceptionError(LibraryError.ESQLC, LibraryError.ESQLS + mensagem, LibraryError.Application, LibraryError.Organization);
        }
    }

    //--------------------------------------------------------------------------
    private void close() throws ExceptionError {
        try {
            if (this.statement != null) {
                this.statement.close();
            }
            if (this.conexao != null) {
                this.conexao.close();
            }
        } catch (Exception error) {
            mensagem = "Erro ao fechar a conexão.\n";
            mensagem = mensagem + error.getMessage();             
            throw new ExceptionError(LibraryError.ESQLC, LibraryError.ESQLS + mensagem, LibraryError.Application, LibraryError.Organization);
        }
    }

    //--------------------------------------------------------------------------
    public ResultSet query(String sql, int tipo) throws ExceptionError {
        ResultSet result;
        result = null;
        try {
            if (this.conexao == null || this.statement == null) {
                open();
            }
            
            if (tipo == 1) {
                result = this.statement.executeQuery(sql);
            } else {
                statement.executeUpdate(sql);
            }
        } catch (Exception error) {
            mensagem = "Erro ao executar a query no banco de dados. \n";
            mensagem = mensagem + error.getMessage();             
            throw new ExceptionError(LibraryError.ESQLC, LibraryError.ESQLS + mensagem, LibraryError.Application, LibraryError.Organization);
        }
        return result;
    }
    //--------------------------------------------------------------------------

    public void setQuerySql(String sql) throws ExceptionError{
        try {
            if (this.conexao == null || this.statement == null) {
                open();
            }

            this.preStatement = this.conexao.prepareStatement(sql);
        } catch (Exception error) {
            mensagem = "Erro ao definir query para execução no banco de dados. \n";
            mensagem = mensagem + error.getMessage();             
            throw new ExceptionError(LibraryError.ESQLC, LibraryError.ESQLS + mensagem, LibraryError.Application, LibraryError.Organization);
        }
    }

    //--------------------------------------------------------------------------
    public PreparedStatement setQueryParameter() {

        return this.preStatement;

    }

}
