package com.evertdev.payu_example.model.checkout;

public class AdditionalValues {
    TX_VALUE TX_VALUEObject;
    TX_TAX TX_TAXObject;
    TX_TAX_RETURN_BASE TX_TAX_RETURN_BASEObject;


    // Getter Methods

    public TX_VALUE getTX_VALUE() {
        return TX_VALUEObject;
    }

    public TX_TAX getTX_TAX() {
        return TX_TAXObject;
    }

    public TX_TAX_RETURN_BASE getTX_TAX_RETURN_BASE() {
        return TX_TAX_RETURN_BASEObject;
    }

    // Setter Methods

    public void setTX_VALUE(TX_VALUE TX_VALUEObject) {
        this.TX_VALUEObject = TX_VALUEObject;
    }

    public void setTX_TAX(TX_TAX TX_TAXObject) {
        this.TX_TAXObject = TX_TAXObject;
    }

    public void setTX_TAX_RETURN_BASE(TX_TAX_RETURN_BASE TX_TAX_RETURN_BASEObject) {
        this.TX_TAX_RETURN_BASEObject = TX_TAX_RETURN_BASEObject;
    }
}
