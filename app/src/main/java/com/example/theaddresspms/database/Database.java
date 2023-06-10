package com.example.theaddresspms.database;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.theaddresspms.entity.Property;

import java.util.ArrayList;
import java.util.HashMap;

public class Database extends SQLiteOpenHelper {
    public Database(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {


        String query = "Create Table Property (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, AREA TEXT,ADDRESS TEXT,PRICE INTEGER ,TYPE TEXT)";



        db.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public  void addNewProperty(Property pro){
        SQLiteDatabase DB= this.getReadableDatabase();


        ContentValues values= new ContentValues();
        values.put("NAME",pro.getName());
        values.put("AREA",pro.getArea());
        values.put("ADDRESS",pro.getAddress());
        values.put("PRICE",pro.getPrice());
        values.put("Type",pro.getType());

        DB.insert("Property",null,values);
        DB.close();
    }

    public ArrayList<HashMap<String, String>> getAllProperty() {

        SQLiteDatabase db = this.getWritableDatabase();
        @SuppressLint("Recycle") Cursor c = db.rawQuery("select * from PROPERTY ", null);

        ArrayList<HashMap<String, String>>  viewPropertyList = new ArrayList<>(c.getCount());
        HashMap<String, String> property;
        if (c.moveToFirst()) {

            do {
                property= new HashMap<>();
                property.put("ID", c.getString(0));
                property.put("NAME", c.getString(1));
                property.put("AREA", c.getString(2));
                property.put("ADDRESS", c.getString(3));
                property.put("PRICE", c.getString(4));
                property.put("TYPE", c.getString(5));

                viewPropertyList.add(property);

            } while (c.moveToNext());

        }
        db.close();
        return  viewPropertyList;
    }

    public boolean updateProperty(Property pro) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("ID",pro.getId());
        values.put("NAME", pro.getName());
        values.put("AREA", pro.getArea());
        values.put("ADDRESS", pro.getAddress());
        values.put("PRICE",pro.getPrice());

        values.put("TYPE", pro.getType());
        int result = db.update("PROPERTY", values, "id = ?", new String[]{pro.getId() + ""});
        db.close();

        return result > 0;
    };

    public boolean deleteProperty(int id) {
        SQLiteDatabase db = this.getWritableDatabase();
        int rowCount = db.delete("PROPERTY", "id = ?", new String[]{id + ""});
        db.close();
        return rowCount > 0;
    }


}
