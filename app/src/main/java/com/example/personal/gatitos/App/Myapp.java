package com.example.personal.gatitos.App;

import android.app.Application;
import android.os.SystemClock;

public class Myapp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        SystemClock.sleep(3000);
    }
}
