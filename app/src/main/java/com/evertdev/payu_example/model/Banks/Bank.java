package com.evertdev.payu_example.model.Banks;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class Bank {
    private String id;
    private String description;
    private String pseCode;

    public Bank() {
    }

    public Bank(String id, String description, String pseCode) {
        this.id = id;
        this.description = description;
        this.pseCode = pseCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPseCode() {
        return pseCode;
    }

    public void setPseCode(String pseCode) {
        this.pseCode = pseCode;
    }

    public static Bank fromJSON(JSONObject jsonObject){
        Bank bank = new Bank();

        try{
            bank.id = jsonObject.getString("id");
            bank.description = jsonObject.getString("description");
            bank.pseCode = jsonObject.getString("pseCode");
        }catch (JSONException e){
            e.printStackTrace();
            return null;
        }
        return bank;
    }

    public static ArrayList<Bank> fromJSONArray(JSONArray jsonArray){
        JSONObject bankJson;
        ArrayList<Bank> banks = new ArrayList<Bank>(jsonArray.length());

        for(int i = 0; i<jsonArray.length(); i++){
            try{
                bankJson = jsonArray.getJSONObject(i);
            }catch (Exception e){
                e.printStackTrace();
                continue;
            }

            Bank bank = Bank.fromJSON(bankJson);
            if(bank != null){
                banks.add(bank);
            }
        }
        return banks;
    }
}
