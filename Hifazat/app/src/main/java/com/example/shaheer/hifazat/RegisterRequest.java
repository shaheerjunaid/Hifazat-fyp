package com.example.shaheer.hifazat;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaheer on 27-Nov-16.
 */

public class RegisterRequest extends StringRequest{
    private static final String REGISTER_REQUEST_URL = "http://hifazat.gbdevelopers.net/signup.php";
    //private static final String REGISTER_REQUEST_URL = "http://10.0.2.2/hifazat/signup.php";
    private Map<String, String> params;

    public RegisterRequest(String name, String contactnumber, String password, String emailid, String homeaddress, Response.Listener<String> listener){
        super(Method.POST, REGISTER_REQUEST_URL, listener, null);
        params = new HashMap<>();
        params.put("name", name);
        params.put("contactNumber", contactnumber);
        params.put("password", password);
        params.put("emailid", emailid);
        params.put("homeaddress", homeaddress);

    }
    @Override
    public Map<String, String> getParams(){//volley accesses this data.
        return params;

    }
}
