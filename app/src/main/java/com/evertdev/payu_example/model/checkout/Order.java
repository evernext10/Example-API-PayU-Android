package com.evertdev.payu_example.model.checkout;

public class Order {
    private String accountId;
    private String referenceCode;
    private String description;
    private String language;
    private String signature;
    private String notifyUrl;
    AdditionalValues AdditionalValuesObject;
    Buyer BuyerObject;


    // Getter Methods

    public String getAccountId() {
        return accountId;
    }

    public String getReferenceCode() {
        return referenceCode;
    }

    public String getDescription() {
        return description;
    }

    public String getLanguage() {
        return language;
    }

    public String getSignature() {
        return signature;
    }

    public String getNotifyUrl() {
        return notifyUrl;
    }

    public AdditionalValues getAdditionalValues() {
        return AdditionalValuesObject;
    }

    public Buyer getBuyer() {
        return BuyerObject;
    }

    // Setter Methods

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public void setReferenceCode(String referenceCode) {
        this.referenceCode = referenceCode;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public void setNotifyUrl(String notifyUrl) {
        this.notifyUrl = notifyUrl;
    }

    public void setAdditionalValues(AdditionalValues additionalValuesObject) {
        this.AdditionalValuesObject = additionalValuesObject;
    }

    public void setBuyer(Buyer buyerObject) {
        this.BuyerObject = buyerObject;
    }
}
