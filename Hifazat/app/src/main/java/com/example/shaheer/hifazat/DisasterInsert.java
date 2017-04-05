package com.example.shaheer.hifazat;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Shaheer on 05-Dec-16.
 */

public class DisasterInsert extends StringRequest {
    private static final String DISASTER_INSERT_URL = "http://hifazat.gbdevelopers.net/adddisaster.php";
    //private static final String DISASTER_INSERT_URL = "http://10.0.2.2/hifazat/adddisaster.php";
    private Map<String, String> params;

    public DisasterInsert(String longitude, String latitude, String landmark , String typeofdisaster, String description, Response.Listener<String> listener){
        super(Method.POST, DISASTER_INSERT_URL, listener, null);
        params=new HashMap<>();
        params.put("longitude", longitude);
        params.put("latitude", latitude);
        params.put("nearestlandmark", landmark);
        params.put("typeofdisaster", typeofdisaster);
        params.put("description", description);
        ;

    }
    @Override
    public Map<String, String>getParams(){
        return params;

    }
}
