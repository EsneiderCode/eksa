package com.example.lab2.Db;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.example.examen.Db.User;
import com.example.examen.Db.UserDao;

@Database(entities = { User.class}, version = 1)
public abstract class AppDb extends RoomDatabase {

    public abstract UserDao userDao();
    private static AppDb instance;

    public static AppDb getInstance(Context context) {
        if(instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(), AppDb.class, "WorldSkills")
                    .allowMainThreadQueries()
                    .build();
        }

        return instance;
    }
}