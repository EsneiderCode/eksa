package com.example.examen;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.Db.User;
import com.example.examen.Db.UserDao;
import com.example.lab2.Db.AppDb;

import java.util.List;

public class Home extends AppCompatActivity {

    TextView emailField ;
    TextView passwordField ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        AppDb db =  AppDb.getInstance(this);
        UserDao userDao = db.userDao();

        List<User> usersDb = userDao.getAll();
        emailField = findViewById(R.id.textViewUserEmail);
        passwordField = findViewById(R.id.textViewUserPassword);
        emailField.setText(usersDb.get(0).email);
        passwordField.setText(usersDb.get(0).password);
    }
}