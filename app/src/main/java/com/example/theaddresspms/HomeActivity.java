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



    }
}