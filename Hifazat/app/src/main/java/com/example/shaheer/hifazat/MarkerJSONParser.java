package com.example.shaheer.hifazat;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MarkerJSONParser {
    public List<HashMap<String,String>> parse(JSONObject jObject){

        JSONArray jMarkers = null;
        try {
            /** Retrieves all the elements in the 'markers' array */
            jMarkers = jObject.getJSONArray("markers");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        /** Invoking getMarkers with the array of json object
         * where each json object represent a marker
         */
        return getMarkers(jMarkers);
    }

    private List<HashMap<String, String>> getMarkers(JSONArray jMarkers){
        int markersCount = jMarkers.length();
        List<HashMap<String, String>> markersList = new ArrayList<HashMap<String,String>>();
        HashMap<String, String> marker = null;

        /** Taking each marker, parses and adds to list object */
        for(int i=0; i<markersCount;i++){
            try {
                /** Call getMarker with marker JSON object to parse the marker */
                marker = getMarker((JSONObject)jMarkers.get(i));
                markersList.add(marker);
            }catch (JSONException e){
                e.printStackTrace();
            }
        }
        return markersList;
    }
    private HashMap<String, String> getMarker(JSONObject jMarker){

        HashMap<String, String> marker = new HashMap<String, String>();
        String latitude = "-NA-";
        String longitude ="-NA-";

        try {
            // Extracting latitude, if available
            if(!jMarker.isNull("latitude")){
                latitude = jMarker.getString("latitude");
            }

            // Extracting longitude, if available
            if(!jMarker.isNull("longitude")){
                longitude = jMarker.getString("longitude");
            }
            marker.put("latitude", latitude);
            marker.put("longitude", longitude);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return marker;
    }
}