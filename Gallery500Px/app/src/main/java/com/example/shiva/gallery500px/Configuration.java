package com.example.shiva.gallery500px;

import android.app.Application;
import android.util.Log;

import com.parse.Parse;

/**
 * Created by shiva on 17-11-2015.
 */
public class Configuration extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.enableLocalDatastore(this);
        Parse.initialize(this, getString(R.string.Application_ID), getString(R.string.Client_ID));
        Log.d("Config","Parse initialization is called");

    }
}
