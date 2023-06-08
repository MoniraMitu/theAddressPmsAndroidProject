package com.example.theaddresspms;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SimpleAdapter;

import androidx.appcompat.app.AppCompatActivity;

import com.example.theaddresspms.database.Database;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;

public class ViewPropertyList extends AppCompatActivity {

    ArrayList viewPropertyList;
    Button createBtn;
    SimpleAdapter sa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_property_list);

        Database db = new Database(getApplicationContext(), "theAddress", null, 1);

        viewPropertyList = new ArrayList<>();
        viewPropertyList= db.getAllProperty();

        createBtn = findViewById(R.id.createButton);

        createBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getApplicationContext(), AddProperty.class));
            }
        });

        sa = new SimpleAdapter(this,
               viewPropertyList,
                R.layout.activity_view_property_list,
                new String[]{"ID", "NAME","AREA", "ADDRESS", "PRICE"},
                new int[]{R.id.line_id1, R.id.line_c1, R.id.line_d1, R.id.line_e1 , R.id.line_f1}
        ) {
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                View v = super.getView(position, convertView, parent);

                ImageView editBtn = v.findViewById(R.id.emp_edit_btn1);
                ImageView delBtn = v.findViewById(R.id.emp_del_btn1);


                editBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        System.out.println(position);
                        HashMap<String, String>  property = new HashMap<>();

                        try {
//                            System.out.println(v.findViewById(R.id.line_c).toString());

                          property= (HashMap<String, String>) viewPropertyList.get(position);


                            System.out.println(viewPropertyList.get(position));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }

//                        Toast.makeText(EmpListActivity.this, "Edit button clicked!! + " + position + user, Toast.LENGTH_SHORT).show();
//                        System.out.println("EDIT----");
                        Intent intent = new Intent(getApplicationContext(), EditProperty.class);
                        intent.putExtra("ID",  property.get("ID"));
                        intent.putExtra("NAME",  property.get("NAME"));
                        intent.putExtra("AREA",  property.get("AREA"));
                        intent.putExtra("ADDRESS",  property.get("ADDRESS"));
                        intent.putExtra("PRICE",  property.get("PRICE"));

                        startActivity(intent);
                    }
                });

                delBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        HashMap<String, String>  property = new HashMap<>();

                        property = (HashMap<String, String>) viewPropertyList.get(position);

                        boolean deleted = db.deleteProperty(Integer.parseInt(Objects.requireNonNull( property.get("ID"))));
                        if (deleted) {
                            viewPropertyList.remove(position);
                            notifyDataSetChanged();
                        }
                        String message = deleted ? "Successfully deleted" : "Failed to delete";
//                        Toast.makeText(viewPropertyList.this, message, Toast.LENGTH_SHORT).show();
                    }
                });


                return v;
            }


        };

    }


}