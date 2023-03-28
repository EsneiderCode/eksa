package com.example.examen.Db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import java.util.List;

@Dao
public interface UserDao {
    @Query("SELECT * FROM user")
     List<User> getAll();

    @Query("SELECT * FROM user WHERE user.email =:userEmail")
    List<User> getUserByEmail(String userEmail);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(User... users);
}
