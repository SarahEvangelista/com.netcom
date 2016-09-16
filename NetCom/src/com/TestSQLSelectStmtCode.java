/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *
 * @author Sarah
 */
public class TestSQLSelectStmtCode {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String testStr = null;
        String column = null;
        String tableName = null;
        
        System.out.println("Enter table name: ");
        tableName = br.readLine();
        
        do {
            System.out.println("Enter column name: ");
            column = br.readLine();
            if (null == testStr) {
                testStr = "select \t" + column + "\n" +
                          "from   \t" + tableName;
            } 
            else {
                if (!"exit".equals(column)){
                    testStr = testStr.substring(testStr.indexOf("select"), testStr.indexOf("from") - 1) +
                                ", \n\t" + column + testStr.substring(testStr.indexOf("from") - 1);
                }
            }
        } while (!"exit".equals(column)) ;

        //print out final select statement
        System.out.println("\n"+testStr);
    }
}
