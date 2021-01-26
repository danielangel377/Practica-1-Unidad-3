package com.example.practica1unidad3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.ContentObservable;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.sql.SQLInput;

public class Agregar extends AppCompatActivity {

  EditText codigo, Nombre, Precio, noPiezas, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
        codigo = (EditText)findViewById(R.id.id) ;
        Nombre = (EditText)findViewById(R.id.Nombre) ;
        Precio = (EditText)findViewById(R.id.Precio) ;
        noPiezas = (EditText)findViewById(R.id.Piezas) ;
        desc = (EditText)findViewById(R.id.desc) ;
    }

    public void Cargar(View view) {
    BaseD bdd = new BaseD(this, "adinistracion", null,1);
        SQLiteDatabase bd =  bdd.getWritableDatabase();

        String Codigo = codigo.getText().toString();
        String nombre = Nombre.getText().toString();
        String precio = Precio.getText().toString();
        String Piezas = noPiezas.getText().toString();
        String descc = desc.getText().toString();


        if(!Codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty() && !Piezas.isEmpty() && !descc.isEmpty()){
            ContentValues registro  = new ContentValues();

            registro.put("codigo", Codigo);
            registro.put("nombre", nombre);
            registro.put("precio",  precio );
            registro.put("piezas", Piezas);
            registro.put("descr", descc);
            bd.insert("productos",null, registro);
            bd.close();
            Toast.makeText(this, "Cargado", Toast.LENGTH_SHORT).show();


        }

        else{
        Toast.makeText(this,"Debes llenar todo los campos", Toast.LENGTH_SHORT).show();

        }






    }
}