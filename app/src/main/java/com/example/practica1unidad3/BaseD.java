package com.example.practica1unidad3;
import android.content.Context;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase;

public class BaseD  extends SQLiteOpenHelper{

    public BaseD( Context context,  String name,
                  SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);

    }

    @Override
    public void onCreate(SQLiteDatabase db) {
             db.execSQL("create table productos(codigo int primary key, nombre  text, precio text, piezas text, descr text)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int il) {
         }

}
