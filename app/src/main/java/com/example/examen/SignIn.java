package com.example.examen;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class SignIn extends AppCompatActivity implements View.OnClickListener{

    private Button bt1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        setOnClick();
    }

    private void setOnClick(){
        findViewById(R.id.btn_sign_up).setOnClickListener(this);
        findViewById(R.id.btn_sign_in).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.btn_sign_up:{
                Intent intentSignUp = new Intent(this, SignUp.class);
                startActivity(intentSignUp);
                finish();
            }
            break;
            case R.id.btn_sign_in:{
                boolean myAnswer = isCheckedAllInputs();
                if ( myAnswer == true){
                    Intent intentHome = new Intent(this, Home.class);
                    startActivity(intentHome);
                    finish();
                }
            }
            break;
        }
    }

    public boolean isCheckedAllInputs(){
        EditText email = findViewById(R.id.editEmail);
        EditText password = findViewById(R.id.editPassword);
        boolean allFiled = true;
        if (email.getText().toString().matches("") ){
            Toast.makeText(this, "Email input should be filled", Toast.LENGTH_SHORT).show();
            allFiled = false;
        }

        if (password.getText().toString().matches("")){
            allFiled = false;
            Toast.makeText(this, "Password input should be filled", Toast.LENGTH_SHORT).show();
        }

        return allFiled;
    }
}