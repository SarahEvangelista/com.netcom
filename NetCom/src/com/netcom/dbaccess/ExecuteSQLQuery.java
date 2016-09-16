/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcom.dbaccess;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author Sarah
 */
public abstract class ExecuteSQLQuery {
    
    //database connection
    private String host, user, password;
    private Connection conn;

    //generic query usage
    private String selQuery;
    
    
    // **** GETTERS AND SETTERS **** //
    private String getDBUser() {
        return this.user = "sample";
    }

    private String getDBUserPassword() {
        return this.password = "password";
    }
    
    
    // **** CLASS METHODS **** //
    public String appendSelectColumn(String column, String tableName){
        if (null == this.selQuery) {
            this.selQuery = "select \t" + column + "\n" +
                            "from   \t" + tableName;
        } 
        else {
            this.selQuery = this.selQuery.substring(this.selQuery.indexOf("select"), this.selQuery.indexOf("from") - 1) +
                            ", \n\t" + column + this.selQuery.substring(this.selQuery.indexOf("from") - 1);
        }
        return this.selQuery;
    }

    public Connection initConnection() {
        try (Connection tryCon = DriverManager.getConnection(host, user, password);) {
            this.conn = tryCon;
        } catch (SQLException sqle) {
            System.out.println("SQL Exception caught: " + sqle.getMessage() + "\nSQL State: " + sqle.getSQLState());
            this.conn = null;
        }
        return this.conn;
    }

    public String executeSelect(String query) {
        return "test";
    }

    public void closeConnection() {
        try (Connection tryCon = this.conn) {
            tryCon.close();
        } catch (SQLException sqle) {
            System.out.println("SQL Exception caught: " + sqle.getMessage() + "\nSQL State: " + sqle.getSQLState());
        }
    }
}
