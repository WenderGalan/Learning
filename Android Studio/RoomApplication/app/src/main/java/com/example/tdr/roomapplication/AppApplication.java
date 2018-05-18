package com.example.tdr.roomapplication;

import android.app.Application;
import android.arch.persistence.room.Room;

public class AppApplication extends Application {

    private AppDatabase mDatabase;

    @Override
    public void onCreate() {
        super.onCreate();
        synchronized (AppApplication.class){
            mDatabase = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "database").build();
        }
    }

    public AppDatabase getDatabase() {
        return mDatabase;
    }

}
