/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcom.login;

import com.netcom.dbaccess.SQLQuery;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Sarah
 */
public class Login implements SQLQuery{
    private String user, pwd;
    private String host, dbUser, dbPwd;
    private Connection conn;
    
    public Login(String user, String pwd){
        super();
        this.user = user;
        this.pwd = pwd;
    }
    
    @Override
    public boolean initConnection() {
        //Make a database
        this.host = "jdbc:odbc://localhost:8080/[tables]";
        this.dbUser = "admin";
        this.dbPwd = "Password";
        
        try (Connection connection = DriverManager.getConnection(this.host, this.dbUser, this.dbPwd)){
            //wait to connect til 30 seconds
            this.conn = connection;
            return this.conn.isValid(30);
        }
        catch(SQLException excp){
            System.err.println("Error in database connection. \n" + excp.getNextException());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, excp);
            return false;
        }
    }
    
    @Override
    public String executeSelect() {
        try {
            Statement createStatement = conn.createStatement();
            createStatement.executeQuery("select * from dual");
            ResultSet result = createStatement.getResultSet();
            //get the result
            return result.toString();
        } 
        catch(SQLException excp){
            System.err.println("Error in database connection. \n" + excp.getNextException());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, excp);
            return null;
        }
    }

    @Override
    public void closeConnection() {
        try {
            this.conn.close();
        } catch (SQLException excp) {
            System.err.println("Error in database connection. \n" + excp.getNextException());
            Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, excp);
        }
    }
    
    protected boolean isValidCred(){
        
        return false;
    }
}
