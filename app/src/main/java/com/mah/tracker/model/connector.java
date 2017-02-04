package com.mah.tracker.model;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.mah.tracker.Main2Activity;
import com.mah.tracker.MainActivity;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mah on 2/4/2017.
 */

public class connector {
    Context context;

    SharedPreferences preferences;
    SharedPreferences.Editor prefEditor;

    public connector(Context context){
        this.context = context;

    }

    public void getResponsePage(final String URL, final Users user) {
        preferences = PreferenceManager.getDefaultSharedPreferences(context);
        prefEditor = preferences.edit();

        StringRequest request = new StringRequest(Request.Method.POST, URL, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                Log.e("Registration Service", "Response : "+ response);
                prefEditor.putString("token",response).apply();

               context. startActivity(new Intent(context, Main2Activity.class));




            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Registration Service", "Error :Send Token Failed");
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("name", user.getName());
                params.put("phone", user.getPhone());
                params.put("email", user.getUsername());
                params.put("username", user.getEmail());
                params.put("password", user.getPassword());

                return params;

            }
        };

        Volley.newRequestQueue(context).add(request);

    }
}
