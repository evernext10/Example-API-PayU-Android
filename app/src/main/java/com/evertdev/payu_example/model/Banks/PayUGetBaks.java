package com.evertdev.payu_example.model.Banks;

import com.evertdev.payu_example.model.Banks.BankListInformation;
import com.evertdev.payu_example.model.Banks.Merchant;

public class PayUGetBaks {
    private String language;
    private String command;
    Merchant merchant;
    private boolean test;
    BankListInformation bankListInformation;


    // Getter Methods

    public String getLanguage() {
        return language;
    }

    public String getCommand() {
        return command;
    }

    public Merchant getMerchant() {
        return merchant;
    }

    public boolean getTest() {
        return test;
    }

    public BankListInformation getBankListInformation() {
        return bankListInformation;
    }

    // Setter Methods

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public void setMerchant(Merchant merchantObject) {
        this.merchant = merchantObject;
    }

    public void setTest(boolean test) {
        this.test = test;
    }

    public void setBankListInformation(BankListInformation bankListInformation) {
        this.bankListInformation = bankListInformation;
    }
}
