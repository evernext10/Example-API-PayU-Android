package com.evertdev.payu_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.evertdev.payu_example.common.common;
import com.evertdev.payu_example.model.Banks.BankListInformation;
import com.evertdev.payu_example.model.Banks.Merchant;
import com.evertdev.payu_example.model.Banks.PayUGetBaks;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    Gson gson = new Gson();

    //Spinner
    private Spinner spinner_banks;
    ArrayList<String> banks_name;
    String bank_selected = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());


        getBanks();
        OnClickMethod();


    }

    private void OnClickMethod() {
        spinner_banks.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                bank_selected = spinner_banks.getItemAtPosition(spinner_banks.getSelectedItemPosition()).toString();
                Toast.makeText(MainActivity.this, ""+bank_selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private void getBanks() {

        banks_name = new ArrayList<>();
        spinner_banks = (Spinner) findViewById(R.id.spinner_banks);

        PayUGetBaks baks = new PayUGetBaks();
        BankListInformation bankListInformation = new BankListInformation();
        Merchant merchant = new Merchant();


        bankListInformation.setPaymentCountry(common.paymentCountry);
        bankListInformation.setPaymentMethod(common.paymentMethod);

        merchant.setApiKey(common.APIKey);
        merchant.setApiLogin(common.APILogin);

        baks.setLanguage(common.language);
        baks.setCommand(common.command);

        baks.setBankListInformation(bankListInformation);
        baks.setMerchant(merchant);

        final String json_get = gson.toJson(baks);


        AndroidNetworking.post(common.BASE_URL_CONSULTAS)
                .addStringBody(json_get)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try{
                            if(response.getString("code").equals(common.SUCCESS)){
                                JSONArray jsonArray_banks = response.getJSONArray("banks");
                                for(int i = 0; i<jsonArray_banks.length();i++){
                                    JSONObject object =jsonArray_banks.getJSONObject(i);
                                    String name = object.getString("description");
                                    banks_name.add(name);
                                }
                            }
                            spinner_banks.setAdapter(new ArrayAdapter<String>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, banks_name));
                        }catch (JSONException e){
                            e.printStackTrace();
                        }
                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Toast.makeText(MainActivity.this, ""+error.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    }
                });

    }
}
