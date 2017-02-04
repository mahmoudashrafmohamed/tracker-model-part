package com.mah.tracker;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.mah.tracker.model.Users;
import com.mah.tracker.model.connector;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

     //Register With volley test
        connector c = new connector(this);
        Users u = new Users();
        u.setUsername("kkkkkkkkkAAAA");
        u.setPhone("1000000010");
        u.setPassword("Gh1aaaaas");
        u.setEmail("qwertyhhh@yahoo.com");
        u.setName("mmmnnnmmmnbgf");
        c.getResponsePage("https://tugcce.herokuapp.com/api/register",u);

       // SharedPreferences preferences;
        //SharedPreferences.Editor prefEditor;
       // preferences = PreferenceManager.getDefaultSharedPreferences(this);
       // prefEditor = preferences.edit();



    }
}
