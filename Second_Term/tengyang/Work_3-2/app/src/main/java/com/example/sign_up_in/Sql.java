package com.example.sign_up_in;

import org.litepal.crud.DataSupport;

/**
 * Created by 滕扬 on 2018/5/9.
 */

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
