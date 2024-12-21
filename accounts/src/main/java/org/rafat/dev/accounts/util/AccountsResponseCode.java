package org.rafat.dev.accounts.util;

public enum AccountsResponseCode {
    ACCOUNT_CREATED("Successfully created new Account", "201"),
    ACCOUNT_UPDATED("Successfully updated Account", "200");

    private String message;
    private String code;

    AccountsResponseCode(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public String getCode() {
        return code;
    }
}
