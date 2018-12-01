package com.evertdev.payu_example.model.checkout;

public class ExtraParameters {
    private String RESPONSE_URL;
    private String PSE_REFERENCE1;
    private String FINANCIAL_INSTITUTION_CODE;
    private String USER_TYPE;
    private String PSE_REFERENCE2;
    private String PSE_REFERENCE3;


    // Getter Methods

    public String getRESPONSE_URL() {
        return RESPONSE_URL;
    }

    public String getPSE_REFERENCE1() {
        return PSE_REFERENCE1;
    }

    public String getFINANCIAL_INSTITUTION_CODE() {
        return FINANCIAL_INSTITUTION_CODE;
    }

    public String getUSER_TYPE() {
        return USER_TYPE;
    }

    public String getPSE_REFERENCE2() {
        return PSE_REFERENCE2;
    }

    public String getPSE_REFERENCE3() {
        return PSE_REFERENCE3;
    }

    // Setter Methods

    public void setRESPONSE_URL(String RESPONSE_URL) {
        this.RESPONSE_URL = RESPONSE_URL;
    }

    public void setPSE_REFERENCE1(String PSE_REFERENCE1) {
        this.PSE_REFERENCE1 = PSE_REFERENCE1;
    }

    public void setFINANCIAL_INSTITUTION_CODE(String FINANCIAL_INSTITUTION_CODE) {
        this.FINANCIAL_INSTITUTION_CODE = FINANCIAL_INSTITUTION_CODE;
    }

    public void setUSER_TYPE(String USER_TYPE) {
        this.USER_TYPE = USER_TYPE;
    }

    public void setPSE_REFERENCE2(String PSE_REFERENCE2) {
        this.PSE_REFERENCE2 = PSE_REFERENCE2;
    }

    public void setPSE_REFERENCE3(String PSE_REFERENCE3) {
        this.PSE_REFERENCE3 = PSE_REFERENCE3;
    }
}
