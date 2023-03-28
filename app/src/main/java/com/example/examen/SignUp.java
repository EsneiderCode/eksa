package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.examen.Db.User;
import com.example.examen.Db.UserDao;
import com.example.lab2.Db.AppDb;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        setOnClick();
    }

    private void setOnClick(){
        findViewById(R.id.btnGoToSignIn).setOnClickListener(this);
        findViewById(R.id.btnSendFormSignUp).setOnClickListener(this);
    }
    public void onClick(View view){
        switch (view.getId()){
            case R.id.btnGoToSignIn:{
                startActivity(new Intent(this, SignIn.class));
                finish();
            }
            break;
            case R.id.btnSendFormSignUp:{
                EditText editTextEmail = findViewById(R.id.editEmailSignUp);
                EditText editTextPassword = findViewById(R.id.editPasswordSignUp);
                String userEmail = editTextEmail.getText().toString();
                String userPassword = editTextPassword.getText().toString();

                AppDb db = AppDb.getInstance(this);
                UserDao userDao = db.userDao();
                User dbUser = new User();
                if (!userEmail.matches("") && !userPassword.matches("")){
                    dbUser.email = userEmail;
                    dbUser.password = userPassword;
                    userDao.insert(dbUser);
                    startActivity(new Intent(this, Home.class));
                    finish();
                }else{
                    Toast.makeText(this, "Sorry", Toast.LENGTH_SHORT).show();
                }

            }
            break;
        }
    }
}