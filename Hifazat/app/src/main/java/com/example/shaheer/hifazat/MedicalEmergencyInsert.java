package com.example.shaheer.hifazat;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

public class MedicalEmergencyInsert extends StringRequest {
    private static final String MEDICAL_INSERT_URL = "http://hifazat.gbdevelopers.net/addmedicalemergency.php";
    private Map<String, String> params;

    public MedicalEmergencyInsert(String longitude, String latitude, String landmark , String status, String description, Response.Listener<String> listener){
        super(Method.POST, MEDICAL_INSERT_URL, listener, null);
        params=new HashMap<>();
        params.put("longitude", longitude);
        params.put("latitude", latitude);
        params.put("nearestlandmark", landmark);
        params.put("status", status);
        params.put("description", description);
       ;

    }
    @Override
    public Map<String, String>getParams(){
        return params;

    }
}
