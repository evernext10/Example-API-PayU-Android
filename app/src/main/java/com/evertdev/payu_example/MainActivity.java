package com.evertdev.payu_example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.androidnetworking.AndroidNetworking;
import com.androidnetworking.common.Priority;
import com.androidnetworking.error.ANError;
import com.androidnetworking.interfaces.JSONObjectRequestListener;
import com.evertdev.payu_example.common.common;
import com.evertdev.payu_example.model.Banks.Bank;
import com.evertdev.payu_example.model.Banks.BankListInformation;
import com.evertdev.payu_example.model.Banks.Merchant;
import com.evertdev.payu_example.model.Banks.PayUGetBaks;
import com.evertdev.payu_example.model.checkout.AdditionalValues;
import com.evertdev.payu_example.model.checkout.Buyer;
import com.evertdev.payu_example.model.checkout.ExtraParameters;
import com.evertdev.payu_example.model.checkout.Order;
import com.evertdev.payu_example.model.checkout.PayUBuy;
import com.evertdev.payu_example.model.checkout.Payer;
import com.evertdev.payu_example.model.checkout.TX_TAX;
import com.evertdev.payu_example.model.checkout.TX_TAX_RETURN_BASE;
import com.evertdev.payu_example.model.checkout.TX_VALUE;
import com.evertdev.payu_example.model.checkout.Transaction;
import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import okhttp3.OkHttpClient;


public class MainActivity extends AppCompatActivity {

    Gson gson = new Gson();

    //Spinner Bank
    private Spinner spinner_banks;
    String bank_selected = "";
    ArrayList<Bank> banks;

    //Spinner Client Type
    private Spinner spinner_client;
    ArrayList<String> client_type;
    String client_selected = "";


    //Spinner Document Type
    private Spinner spinner_document;
    ArrayList<String> document_type;
    String document_selected = "";

    //EditTexts
    EditText money, name, document, email, phone;

    //Button buy
    Button btn_checkout;

    Merchant merchant = new Merchant();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AndroidNetworking.initialize(getApplicationContext());

        initViews();
        getBanks();
        OnClickMethod();


    }

    private void initViews() {
        btn_checkout = (Button)findViewById(R.id.btnPayNow);
        spinner_banks = (Spinner) findViewById(R.id.spinner_banks);
        spinner_client = (Spinner) findViewById(R.id.spinner_client_type);
        spinner_document = (Spinner) findViewById(R.id.spinner_document);
        money = (EditText) findViewById(R.id.editTextAmount);
        name = (EditText) findViewById(R.id.editTextName);
        document = (EditText) findViewById(R.id.editTextDocument);
        email = (EditText) findViewById(R.id.editTextEmail);
        phone = (EditText) findViewById(R.id.editTextPhone);

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

        spinner_document.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                document_selected = spinner_document.getItemAtPosition(spinner_document.getSelectedItemPosition()).toString();
                Toast.makeText(MainActivity.this, ""+document_selected, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        spinner_client.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                client_selected = spinner_client.getItemAtPosition(spinner_client.getSelectedItemPosition()).toString();
                if(client_selected.equals("Persona Natural")){
                    client_selected = "N";
                }else if(client_selected.equals("Persona Juridica")){
                    client_selected = "J";
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });


        btn_checkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(TextUtils.isEmpty(money.getText().toString())){
                    money.setError("Ingresar dinero");
                }else{
                    if(TextUtils.isEmpty(name.getText().toString())){
                        name.setError("Ingresar nombre");
                    }else{
                        if(TextUtils.isEmpty(document.getText().toString())){
                            document.setError("Ingresar documento");
                        }else{
                            if(TextUtils.isEmpty(email.getText().toString())){
                                email.setError("Ingresar el correo");
                            }else{
                                if(TextUtils.isEmpty(phone.getText().toString())){
                                    phone.setError("Ingresar el numero de celular");
                                }else{
                                    if(TextUtils.isEmpty(client_selected)){
                                        Toast.makeText(MainActivity.this, "Por favor seleccionar el tipo de cliente", Toast.LENGTH_SHORT).show();
                                    }else{
                                        if(TextUtils.isEmpty(document_selected)){
                                            Toast.makeText(MainActivity.this, "Por favor seleccionar el tipo de documento", Toast.LENGTH_SHORT).show();
                                        }else{
                                            if(TextUtils.isEmpty(bank_selected)){
                                                Toast.makeText(MainActivity.this, "Por favor seleccionar el banco", Toast.LENGTH_SHORT).show();
                                            }else{
                                                checkout();
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });
    }

    private void checkout() {
        PayUBuy payUBuy = new PayUBuy();
        Transaction transaction = new Transaction();
        Order order = new Order();
        AdditionalValues additionalValues = new AdditionalValues();
        TX_TAX tx_tax = new TX_TAX();
        TX_VALUE tx_value = new TX_VALUE();
        TX_TAX_RETURN_BASE tx_tax_return_base = new TX_TAX_RETURN_BASE();
        ExtraParameters extraParameters = new ExtraParameters();
        Payer payer = new Payer();
        Buyer buyer = new Buyer();

        payer.setContactPhone(phone.getText().toString());
        payer.setEmailAddress(email.getText().toString());
        payer.setFullName(name.getText().toString());

        buyer.setEmailAddress(email.getText().toString());


        for(Bank bank : banks){
            if(bank.getDescription() != null && bank.getDescription().contains(bank_selected)){
                extraParameters.setFINANCIAL_INSTITUTION_CODE(bank.getId());
            }
        }
        extraParameters.setRESPONSE_URL(common.RESPONSE_URL);
        extraParameters.setPSE_REFERENCE1(common.PSE_REFERENCE1);
        extraParameters.setPSE_REFERENCE2(document_selected);
        extraParameters.setPSE_REFERENCE3(document.getText().toString());
        extraParameters.setUSER_TYPE(client_selected);

        tx_tax.setCurrency(common.currency);
        tx_tax.setValue(common.value_tx_tax);
        tx_value.setCurrency(common.currency);
        tx_value.setValue(Float.parseFloat(money.getText().toString()));
        tx_tax_return_base.setCurrency(common.currency);
        tx_tax_return_base.setValue(common.value_tx_tax_return_base);
        additionalValues.setTX_TAX(tx_tax);
        additionalValues.setTX_TAX_RETURN_BASE(tx_tax_return_base);
        additionalValues.setTX_VALUE(tx_value);


        order.setAccountId(common.accountId);
        order.setDescription(common.description);
        order.setLanguage(common.language);
        order.setNotifyUrl(common.notifyUrl);
        order.setReferenceCode(common.referenceCode);
        order.setSignature(common.signature);
        order.setBuyer(buyer);
        transaction.setCookie(common.cookie);
        transaction.setExtraParameters(extraParameters);
        transaction.setOrder(order);
        transaction.setIpAddress(common.ipAddress);
        transaction.setPaymentCountry(common.paymentCountry);
        transaction.setPaymentMethod(common.paymentMethod);
        transaction.setType(common.type);
        transaction.setUserAgent(common.userAgent);
        transaction.setPayer(payer);


        payUBuy.setTest(false);
        payUBuy.setCommand(common.command_buy);
        payUBuy.setLanguage(common.language);
        payUBuy.setMerchant(merchant);
        payUBuy.setTransaction(transaction);

        String json_checkout = gson.toJson(payUBuy);

        AndroidNetworking.post(common.BASE_URL_PAGOS)
                .addApplicationJsonBody(json_checkout)
                .setContentType(common.CONTENT_TYPE)
                .addHeaders("Content-Type",common.CONTENT_TYPE)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();

                    }
                    @Override
                    public void onError(ANError error) {
                        // handle error
                        Toast.makeText(MainActivity.this, ""+error.getErrorDetail(), Toast.LENGTH_SHORT).show();
                    }
                });


    }

    private void getBanks() {

        banks = new ArrayList<Bank>();

        final PayUGetBaks baks = new PayUGetBaks();
        BankListInformation bankListInformation = new BankListInformation();



        bankListInformation.setPaymentCountry(common.paymentCountry);
        bankListInformation.setPaymentMethod(common.paymentMethod);

        merchant.setApiKey(common.APIKey);
        merchant.setApiLogin(common.APILogin);

        baks.setLanguage(common.language);
        baks.setCommand(common.command);

        baks.setBankListInformation(bankListInformation);
        baks.setMerchant(merchant);
        baks.setTest(false);

        final String json_get = gson.toJson(baks);


        AndroidNetworking.post(common.BASE_URL_CONSULTAS)
                .addApplicationJsonBody(json_get)
                .setContentType(common.CONTENT_TYPE)
                .addHeaders("Content-Type",common.CONTENT_TYPE)
                .setPriority(Priority.HIGH)
                .build()
                .getAsJSONObject(new JSONObjectRequestListener() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Toast.makeText(MainActivity.this, ""+response, Toast.LENGTH_SHORT).show();
                        try{
                            if(response.getString("code").equals(common.SUCCESS)){
                                JSONArray jsonArray_banks = response.getJSONArray("banks");
                                banks.clear();
                                banks.addAll(Bank.fromJSONArray(jsonArray_banks));
                            }
                            spinner_banks.setAdapter(new ArrayAdapter<Bank>(MainActivity.this, android.R.layout.simple_spinner_dropdown_item, banks));
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
