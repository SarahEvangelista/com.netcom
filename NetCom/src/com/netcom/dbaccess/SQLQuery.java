/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.netcom.dbaccess;

/**
 *
 * @author Sarah
 */
public interface SQLQuery {
    public boolean initConnection();
    public String executeSelect();
    public void closeConnection();
}
