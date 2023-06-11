package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.theaddresspms.entity.Property;

public class ViewProperty extends AppCompatActivity {
    TextView tvName,  tvArea, tvAddress, tvPrice , tvId;
    ImageView iv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property);

        tvId = findViewById(R.id.textViewId);
        tvId.setVisibility(View.GONE);
        tvName = findViewById(R.id.textViewName);
        tvArea = findViewById(R.id.textViewArea);
        tvAddress = findViewById(R.id.textViewAddress);
        tvPrice = findViewById(R.id.textViewPrice);
        iv=findViewById(R.id.pro_Image_view);


        tvId.setKeyListener(null);
        tvName.setKeyListener(null);
        tvArea.setKeyListener(null);
        tvAddress.setKeyListener(null);
        tvPrice.setKeyListener(null);

        Intent intent = getIntent();

        String id = intent.getStringExtra("ID");
        String name = intent.getStringExtra("NAME");
        String price = intent.getStringExtra("PRICE");
        String address = intent.getStringExtra("ADDRESS");
        String area = intent.getStringExtra("AREA");
        tvId.setText(id);
        tvName.setText(name);
        tvArea.setText(area);
        tvAddress.setText(address);
        tvPrice.setText(price);

    }
}