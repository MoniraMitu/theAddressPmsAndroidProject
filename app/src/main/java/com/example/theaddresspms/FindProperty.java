package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class FindProperty extends AppCompatActivity {
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find_property);

//        CardView exit = findViewById(R.id.cardBack);
//
//        exit.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                startActivity(new Intent(FindProperty.this, HomeActivity.class));
//            }
//        });

        iv = findViewById(R.id.cardProperty);

       iv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(FindProperty.this, ViewPropertyList.class);
                intent.putExtra("title","All Property");
                startActivity(intent);
            }
        });
    }
}