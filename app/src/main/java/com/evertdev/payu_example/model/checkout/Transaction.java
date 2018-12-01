package com.evertdev.payu_example.model.checkout;

public class Transaction {
    Order OrderObject;
    Payer PayerObject;
    ExtraParameters ExtraParametersObject;
    private String type;
    private String paymentMethod;
    private String paymentCountry;
    private String ipAddress;
    private String cookie;
    private String userAgent;


    // Getter Methods

    public Order getOrder() {
        return OrderObject;
    }

    public Payer getPayer() {
        return PayerObject;
    }

    public ExtraParameters getExtraParameters() {
        return ExtraParametersObject;
    }

    public String getType() {
        return type;
    }

    public String getPaymentMethod() {
        return paymentMethod;
    }

    public String getPaymentCountry() {
        return paymentCountry;
    }

    public String getIpAddress() {
        return ipAddress;
    }

    public String getCookie() {
        return cookie;
    }

    public String getUserAgent() {
        return userAgent;
    }

    // Setter Methods

    public void setOrder(Order orderObject) {
        this.OrderObject = orderObject;
    }

    public void setPayer(Payer payerObject) {
        this.PayerObject = payerObject;
    }

    public void setExtraParameters(ExtraParameters extraParametersObject) {
        this.ExtraParametersObject = extraParametersObject;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPaymentMethod(String paymentMethod) {
        this.paymentMethod = paymentMethod;
    }

    public void setPaymentCountry(String paymentCountry) {
        this.paymentCountry = paymentCountry;
    }

    public void setIpAddress(String ipAddress) {
        this.ipAddress = ipAddress;
    }

    public void setCookie(String cookie) {
        this.cookie = cookie;
    }

    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }
}
