package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theaddresspms.database.Database;

public class LogInActivity extends AppCompatActivity {
    EditText edUserName;
    EditText edPassword;
    Button btn;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);

//        btn=findViewById(R.id.btnSubmit);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(LogInActivity.this, HomeActivity.class));
//            }
//        });

        edUserName=findViewById(R.id.name);
        edPassword=findViewById(R.id.password);
        btn=findViewById(R.id.logIn);
        tv=findViewById(R.id.newUser);

        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(LogInActivity.this, HomeActivity.class);
                startActivity(intent);
            }});

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                String name= edUserName.getText().toString();
                String  password=edPassword.getText().toString();
                Database database = new Database(getApplicationContext(),"theAddress",null,1);

//                Toast.makeText(getApplicationContext(),"Name: "+name+ "Password: "+password,Toast.LENGTH_SHORT).show();
                if(edUserName.length()==0 || edPassword.length()==1){
                    Toast.makeText(getApplicationContext(),"Please fill the following Fields",Toast.LENGTH_SHORT).show();
                }else {
                    if(database.logInActivity(name,password)==1){
                        Toast.makeText(getApplicationContext(),"Login Successfull",Toast.LENGTH_SHORT).show();
                        SharedPreferences preferences=getSharedPreferences("shared_pref", Context.MODE_PRIVATE);
                        SharedPreferences.Editor editor = preferences.edit();
                        editor.apply();
                        editor.commit();
                        startActivity(new Intent(LogInActivity.this, HomeActivity.class));
                    }
                }
            }
        });
    }
    public void logIn(){}
}


