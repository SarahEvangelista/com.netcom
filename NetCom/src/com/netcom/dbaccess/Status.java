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
public enum Status {
    SUCCESS("Success"), FAILED("Failed");

    private String status;

    private Status(String stat) {
        status = stat;
    }

    public String getStatus() {
        return this.status;
    }
}
