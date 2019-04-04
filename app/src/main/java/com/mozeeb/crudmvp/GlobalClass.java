package com.mozeeb.crudmvp;

import android.app.Application;

import com.androidnetworking.AndroidNetworking;

public class GlobalClass extends Application {

    public static final String BASE_URL = "http://192.168.70.148/api_rpla/index.php/Api/";

    @Override
    public void onCreate() {
        super.onCreate();
        AndroidNetworking.initialize(getApplicationContext());

    }
}
