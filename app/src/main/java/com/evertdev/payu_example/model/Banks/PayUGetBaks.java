package com.evertdev.payu_example.model.Banks;

import com.evertdev.payu_example.model.Banks.BankListInformation;
import com.evertdev.payu_example.model.Banks.Merchant;

public class PayUGetBaks {
    private String language;
    private String command;
    Merchant MerchantObject;
    private boolean test;
    BankListInformation BankListInformationObject;


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

    public boolean getTest() {
        return test;
    }

    public BankListInformation getBankListInformation() {
        return BankListInformationObject;
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

    public void setTest(boolean test) {
        this.test = test;
    }

    public void setBankListInformation(BankListInformation bankListInformationObject) {
        this.BankListInformationObject = bankListInformationObject;
    }
}
