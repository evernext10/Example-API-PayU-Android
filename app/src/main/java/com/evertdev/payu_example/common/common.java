package com.evertdev.payu_example.common;

public class common {

    public static String merchantId = "508029";
    public static String APILogin = "pRRXKOl8ikMmt9u";
    public static String APIKey = "4Vj8eK4rloUd272L48hsrarnUA";
    public static String accoundtId = "512321";
    public static String BASE_URL_CONSULTAS = "https://sandbox.api.payulatam.com/reports-api/4.0/service.cgi";
    public static String BASE_URL_PAGOS = "https://sandbox.api.payulatam.com/payments-api/4.0/service.cgi";


    //Variables para obtener Bancos
    public static String language = "es";
    public static String command = "GET_BANKS_LIST";
    public static String command_buy = "SUBMIT_TRANSACTION";
    public static String paymentMethod = "PSE";
    public static String paymentCountry = "CO";
    public static String SUCCESS = "SUCCESS";
    public static String CONTENT_TYPE = "application/json";

    //Other
    public static String accountId = "512321";
    public static String referenceCode = "TestPayU";
    public static String description = "payment test";
    public static String signature = "7ee7cf808ce6a39b17481c54f2c57acc";
    public static String notifyUrl = "http://www.tes.com/confirmation";
    public static String currency = "COP";
    public static String emailAddress_bayer = "buyer_test@test.com";

    //ExtraParameters
    public static String RESPONSE_URL = "http://www.test.com/response";
    public static String PSE_REFERENCE1 = "127.0.0.1";
    public static String type = "AUTHORIZATION_AND_CAPTURE";
    public static String ipAddress = "127.0.0.1";
    public static String cookie = "pt1t38347bs6jc9ruv2ecpv7o2";
    public static String userAgent = "Mozilla/5.0 (Windows NT 5.1; rv:18.0) Gecko/20100101 Firefox/18.0";
    public static float value_tx_tax = 3193;
    public static float value_tx_tax_return_base = 16806;



}
