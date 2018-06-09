package com.example.materiatest3;

import org.litepal.crud.DataSupport;



public class Sql extends DataSupport{
    private String accountId;
    private String passwordId;

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getPasswordId() {
        return passwordId;
    }

    public void setPasswordId(String passwordId) {
        this.passwordId = passwordId;
    }
}
