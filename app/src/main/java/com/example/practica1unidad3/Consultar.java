package com.example.practica1unidad3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;
import java.sql.SQLInput;

public class Consultar extends AppCompatActivity {

    EditText codigo, Nombre, Precio, noPiezas, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_consultar);
        super.onCreate(savedInstanceState);
        codigo = (EditText)findViewById(R.id.id) ;
        Nombre = (EditText)findViewById(R.id.Nombre) ;
        Precio = (EditText)findViewById(R.id.Precio) ;
        noPiezas = (EditText)findViewById(R.id.Piezas) ;
        desc = (EditText)findViewById(R.id.desc) ;


    }

    public void consultar(View view) {
        BaseD bdd = new BaseD(this, "administracion", null,1);
        SQLiteDatabase db =  bdd.getWritableDatabase();


        String Codigo = codigo.getText().toString();

        if(!Codigo.isEmpty()){
    Cursor fila = db.rawQuery
            ("select nombre, precio, piezas, descr from productos where codigo ="+ Codigo,null);

    if (fila.moveToFirst()){

        Nombre.setText(fila.getString(0));
        Precio.setText(fila.getString(1));
        noPiezas.setText(fila.getString(2));
        desc.setText(fila.getString(3));
        db.close();
    }
    else{

        Toast.makeText(this,"No existe registro", Toast.LENGTH_SHORT).show();
        db.close();
    }



        }
        else{
            Toast.makeText(this,"Debes llenar el campo requerido", Toast.LENGTH_SHORT).show();
        }

    }
}