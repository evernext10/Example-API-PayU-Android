package com.evertdev.payu_example.model.checkout;

public class Payer {
    private String fullName;
    private String emailAddress;
    private String contactPhone;


    // Getter Methods

    public String getFullName() {
        return fullName;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getContactPhone() {
        return contactPhone;
    }

    // Setter Methods

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setContactPhone(String contactPhone) {
        this.contactPhone = contactPhone;
    }
}
