package com.codepath.solvesense;

import android.app.Application;

import com.parse.Parse;

public class AppParse extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        Parse.initialize(new Parse.Configuration.Builder(this)
                .applicationId("EnXNJL5YfaJjWUg8rYvytAS0jz1Tq1dCrrwBkS0Q")
                .clientKey("YGaWJsmMBf2UzaLlgJ0PwO6fnFDZ3dMqB01W00NT")
                .server("https://parseapi.back4app.com")
                .build()
        );
    }
}
