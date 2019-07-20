package com.mikeescom.mlkitexamples;

import android.app.Application;

import com.google.firebase.FirebaseApp;

public class MLKitExamplesApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        FirebaseApp.initializeApp(this);
    }
}
