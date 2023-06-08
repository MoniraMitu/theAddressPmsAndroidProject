package com.example.theaddresspms;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.theaddresspms.database.Database;
import com.example.theaddresspms.entity.Property;

public class AddProperty extends AppCompatActivity {
    EditText edPropertyName;
    EditText edPropertyArea;
    EditText edPropertyAddress;
    EditText edPropertyPrice;

    Button btn;
    Spinner spinnerTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_property);


        edPropertyName=findViewById(R.id.editTextName);
        edPropertyArea=findViewById(R.id.editTextArea);
        edPropertyAddress=findViewById(R.id.editTextAddress);
        edPropertyPrice=findViewById(R.id.editTextProPrice);
        btn=findViewById(R.id.submit);

        spinnerTypes=findViewById(R.id.spinnerProType);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Property pro=new Property();


                String name=  edPropertyName.getText().toString();
                String  area= edPropertyArea.getText().toString();
                String address=edPropertyAddress.getText().toString();
                Integer price = Integer.valueOf( edPropertyPrice.getText().toString());

                String types=spinnerTypes.getSelectedItem().toString();


               pro.setName(name);
                pro.setArea(area);
                pro.setAddress(address);
                pro.setPrice(price);

                pro.setType(types);



                Database database = new Database(getApplicationContext(),"theAddress",null,1);


//                Toast.makeText(getApplicationContext(),"Name: "+name+ "Password: "+password+"Com Name: " +coName +"Email: "+email,Toast.LENGTH_SHORT).show();

                if( name.length()==0 ||  area.length()==0 || address.length()==0 ||  price.intValue()==0 || types.length()==0){
                    Toast.makeText(getApplicationContext(),"Please Fill All The Data Field",Toast.LENGTH_SHORT).show();
                }else {
                    database.addNewProperty(pro);

                    Toast.makeText(getApplicationContext(),"Property added..",Toast.LENGTH_SHORT).show();
                }
                startActivity(new Intent(AddProperty.this, ViewPropertyList.class));
            }



        });
    }


    }
