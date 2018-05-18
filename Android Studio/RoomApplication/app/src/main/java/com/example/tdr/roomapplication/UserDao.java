package com.example.tdr.roomapplication;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
    LiveData<List<User>> getAll();

    @Query("SELECT * FROM user WHERE uid IN (:userIds)")
    List<User> loadAllByIds(int[] userIds);

    @Query("SELECT * FROM user WHERE first_name LIKE :first AND " + "last_name LIKE :last LIMIT 1")
    User findByName(String first, String last);

    @Query("SELECT * FROM user WHERE first_name LIKE :first LIMIT 1")
    User findByFirstName(String first);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    long[] insertAll(User... users);

    @Insert()
    void insert(User user);

    @Delete
    void delete(User user);

    @Update()
    void updateFirstUser(User user);

    @Query("DELETE FROM user")
    void deleteAll();
}
