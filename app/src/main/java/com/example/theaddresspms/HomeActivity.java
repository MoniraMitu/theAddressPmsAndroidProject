package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Build;
import android.os.Bundle;
import android.renderscript.Allocation;
import android.renderscript.Element;
import android.renderscript.RenderScript;
import android.renderscript.ScriptIntrinsicBlur;
import android.widget.ImageView;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);


        ImageView backgroundImage = findViewById(R.id.backgroundImage);

// Apply blur effect
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            RenderScript rs = RenderScript.create(this);
            Allocation overlayAlloc = Allocation.createFromBitmap(rs, BitmapFactory.decodeResource(getResources(), R.drawable.address));
            ScriptIntrinsicBlur blur = ScriptIntrinsicBlur.create(rs, Element.U8_4(rs));
            blur.setInput(overlayAlloc);
            blur.setRadius(25); // Adjust the blur radius as per your preference
            blur.forEach(overlayAlloc);
            overlayAlloc.copyTo(BitmapFactory.decodeResource(getResources(), R.drawable.address));
            rs.destroy();
        }

    }
}