package com.mah.tracker.model;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Mah on 2/4/2017.
 */

public class Parser {

   String data;
    boolean f=true;
    public String ParseRegister(String jsonFile) {
        try {
            f=true;
                JSONObject mainObject = new JSONObject(jsonFile);
            if(mainObject.has("token")) {
                data = mainObject.getString("token");
            }
            if(mainObject.has("error")){
                data = mainObject.getString("error");
                f=false;

            }

            } catch (JSONException e) {
                e.printStackTrace();
            }



        return data;
    }

    public boolean responseHasError(){
        return f;
    }

}
