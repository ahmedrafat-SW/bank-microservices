package org.rafat.dev.accounts.util.enums;

public enum AccountType {
    SAVING("Saving Account"),
    BUSINESS("Business Account")

    ;

    private String name;

    AccountType(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
