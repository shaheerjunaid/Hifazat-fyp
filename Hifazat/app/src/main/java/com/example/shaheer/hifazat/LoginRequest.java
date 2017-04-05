package com.example.shaheer.hifazat;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;


public class LoginRequest extends StringRequest{
    //public static final String LOGIN_REQUEST_URL = "http://hifazat.gbdevelopers.net/login.php";
    public static final String LOGIN_REQUEST_URL = "http://10.0.2.2/hifazat/login.php";
    private Map<String, String> params;

    public LoginRequest(String number, String password, Response.Listener<String> listener){
        super(Method.POST, LOGIN_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("number", number);
        params.put("password", password);

    }
    @Override
    public Map<String, String> getParams(){//volley accesses this data.
        return params;

    }
}
