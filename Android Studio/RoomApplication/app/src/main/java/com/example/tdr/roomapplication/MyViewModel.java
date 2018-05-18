package com.example.tdr.roomapplication;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.arch.persistence.room.Room;
import android.content.Context;
import android.support.annotation.NonNull;

import java.util.List;

public class MyViewModel extends AndroidViewModel {
    private LiveData<List<User>> users;
    private Application appApplication;

    public MyViewModel(@NonNull Application application) {
        super(application);
        appApplication = application;
    }


    public LiveData<List<User>> getUsers(){
        if (users == null){
            users = new MutableLiveData<List<User>>();
            loadUsers();
        }
        return users;
    }

    private void loadUsers() {
        //users = app.userDao().getAll();
    }
}
