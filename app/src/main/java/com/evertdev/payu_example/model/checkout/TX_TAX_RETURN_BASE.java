package com.evertdev.payu_example.model.checkout;

public class TX_TAX_RETURN_BASE {
    private float value;
    private String currency;


    // Getter Methods

    public float getValue() {
        return value;
    }

    public String getCurrency() {
        return currency;
    }

    // Setter Methods

    public void setValue(float value) {
        this.value = value;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
