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

        String query2 =  "Create Table User (ID INTEGER PRIMARY KEY AUTOINCREMENT, NAME TEXT, GENDER TEXT, EMAIL TEXT, " +
                "PASSWORD TEXT,CONTACT INTEGER)";

        db.execSQL(query);
        db.execSQL(query2);

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

    public int logInActivity(String userName,String password){
        int result=0;
        String []arr= new String[2];

        arr[0]=userName;
        arr[1]=password;

        SQLiteDatabase DB= this.getWritableDatabase();

        Cursor c=DB.rawQuery("seLect * from User where NAME=? and PASSWORD =?" ,arr);

        ;if(c.moveToFirst()){
            return  1;
        }else  return  0;
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

    public  void addNewUser(String userName, String email, String password,Integer contact){
        SQLiteDatabase DB= this.getReadableDatabase();


        ContentValues values= new ContentValues();
        values.put("Name",userName);
        values.put("Email",email);
        values.put("Password",password);
        values.put("Contact",contact);

        DB.insert("User",null,values);
        DB.close();
    }



}
