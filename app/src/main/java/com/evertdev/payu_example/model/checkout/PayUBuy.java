package com.evertdev.payu_example.model.checkout;

import com.evertdev.payu_example.model.Banks.Merchant;

public class PayUBuy {
    private String language;
    private String command;
    Merchant MerchantObject;
    Transaction TransactionObject;
    private boolean test;


    // Getter Methods

    public String getLanguage() {
        return language;
    }

    public String getCommand() {
        return command;
    }

    public Merchant getMerchant() {
        return MerchantObject;
    }

    public Transaction getTransaction() {
        return TransactionObject;
    }

    public boolean getTest() {
        return test;
    }

    // Setter Methods

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setMerchant(Merchant merchantObject) {
        this.MerchantObject = merchantObject;
    }

    public void setTransaction(Transaction transactionObject) {
        this.TransactionObject = transactionObject;
    }

    public void setTest(boolean test) {
        this.test = test;
    }
}


