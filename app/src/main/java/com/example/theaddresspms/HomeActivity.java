package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class HomeActivity extends AppCompatActivity {
  CardView cardView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        cardView = findViewById(R.id.addProperty);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "okkk ....!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, AddProperty.class));
            }
        });

        cardView = findViewById(R.id.viewPropertyList);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "okkk ....!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, ViewPropertyList.class));
            }
        });

        cardView = findViewById(R.id.viewProperty);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "okkk ....!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, ViewProperty.class));
            }
        });

        cardView = findViewById(R.id.findProperty);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "okkk ....!", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(HomeActivity.this, FindProperty.class));
            }
        });


        cardView = findViewById(R.id.cardBack);
        cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(HomeActivity.this, LogOut.class));
                Toast.makeText(getApplicationContext(), "Logged Out ...!", Toast.LENGTH_SHORT).show();
            }
        });



    }
}