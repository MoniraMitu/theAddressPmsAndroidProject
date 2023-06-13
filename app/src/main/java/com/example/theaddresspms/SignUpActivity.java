package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.theaddresspms.database.Database;

public class SignUpActivity extends AppCompatActivity {
    EditText edUserName;
    EditText edPassword;
    EditText edEmail;
    EditText edContact;
    Button btn;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

//        btn=findViewById(R.id.signin);
//
//        btn.setOnClickListener(new View.OnClickListener() {
//
//            @Override
//            public void onClick(View v) {
//                startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
//            }
//        });

        edUserName=findViewById(R.id.name);
        edPassword=findViewById(R.id.password);
        edEmail=findViewById(R.id.email);
        edContact=findViewById(R.id.contact);
        btn=findViewById(R.id.signin);
        tv=findViewById(R.id.coname);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name= edUserName.getText().toString();
                String  password=edPassword.getText().toString();
                String email=edEmail.getText().toString();
                Integer contact = Integer.valueOf(edContact.getText().toString());
                String coName=tv.getText().toString();


                Database database = new Database(getApplicationContext(),"theAddress",null,1);


//                Toast.makeText(getApplicationContext(),"Name: "+name+ "Password: "+password+"Com Name: " +coName +"Email: "+email,Toast.LENGTH_SHORT).show();

                if( name.length()==0 ||  password.length()==0 || email.length()==0 ){
                    Toast.makeText(getApplicationContext(),"Please Fill All The Data Field",Toast.LENGTH_SHORT).show();
                }else {
                    database.addNewUser(name,email,password,contact);

                    Toast.makeText(getApplicationContext(),"Done..",Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(SignUpActivity.this, LogInActivity.class));
                }
            }
        });
    }
}