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
import com.example.theaddresspms.entity.Property;

public class EditProperty extends AppCompatActivity {
    EditText edName,  edArea, edAddress, edPrice,  edId;
    Button btn;
    Button btn1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_property);

        edId = findViewById(R.id.editId);
        edName = findViewById(R.id.editName);
        edArea = findViewById(R.id.editArea);
        edAddress = findViewById(R.id.editAddress);
        edPrice = findViewById(R.id.editPrice);
//        edDate = findViewById(R.id.dateEDIT);
//        spinnerDepartment = sqLiteCreateFragment.spinnerDepartment;

        btn = findViewById(R.id.buttonEDIT);
        btn1 = findViewById(R.id.buttonBack);




        edId.setKeyListener(null);

        Intent intent = getIntent();

        String id = intent.getStringExtra("ID");
        String name = intent.getStringExtra("NAME");
        String price = intent.getStringExtra("PRICE");
        String address = intent.getStringExtra("ADDRESS");
        String area = intent.getStringExtra("AREA");
        edId.setText(id);
        edName.setText(name);
        edArea.setText(area);
        edAddress.setText(address);
        edPrice.setText(price);
//        Toast.makeText(this, "NAME: "+name+" , AREA: "+ area+", ADDRESS: "+ address, Toast.LENGTH_SHORT).show();

        Database db = new Database(getApplicationContext(), "theAddress", null,1);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
//                startActivity(new Intent(EditProperty.this, ViewPropertyList.class));

                Property pro = new  Property();
                Integer id = Integer.parseInt(edId.getText().toString());
                String name = edName.getText().toString();
                String area = edArea.getText().toString();
                String address = edAddress.getText().toString();

                String price = edPrice.getText().toString();

                pro.setId(id);
                pro.setName(name);
                pro.setArea(area);
                pro.setAddress(address);
                pro.setPrice(Integer.valueOf(price));


                Boolean result = db.updateProperty(pro);
                String message = result ? "Successfully Updated!" : "Failed to Update.";
                Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();//
                Intent intent = new Intent(getApplicationContext(), ViewPropertyList.class);
                startActivity(intent);
            }
        });

    }
}