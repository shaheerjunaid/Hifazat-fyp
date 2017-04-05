package com.example.shaheer.hifazat;


import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class CrimeInsert extends StringRequest {
    private static final String CRIME_INSERT_URL = "http://hifazat.gbdevelopers.net/addcrime.php";
    //private static final String CRIME_INSERT_URL = "http://10.0.2.2/hifazat/addcrime.php";
    private Map<String, String> params;

    public CrimeInsert(String longitude, String latitude, String landmark , String typeofcrimes, String description, Response.Listener<String> listener){
        super(Method.POST, CRIME_INSERT_URL, listener, null);
        params=new HashMap<>();
        params.put("longitude", longitude);
        params.put("latitude", latitude);
        params.put("nearestlandmark", landmark);
        params.put("typeofcrime", typeofcrimes);
        params.put("description", description);
        ;

    }
    @Override
    public Map<String, String>getParams(){
        return params;

    }
}
