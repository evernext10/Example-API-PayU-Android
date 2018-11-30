package com.evertdev.payu_example.model.Banks;

public class BankListInformation {
    private String paymentMethod;
    private String paymentCountry;


    // Getter Methods

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentCountry() {
        return paymentCountry;
    }

    // Setter Methods

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentCountry(String paymentCountry) {
        this.paymentCountry = paymentCountry;
    }
}
