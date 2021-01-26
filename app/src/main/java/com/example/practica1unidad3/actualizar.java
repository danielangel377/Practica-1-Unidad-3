package com.example.practica1unidad3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class actualizar extends AppCompatActivity {
    EditText codigo, Nombre, Precio, noPiezas, desc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actualizar);
        codigo = (EditText)findViewById(R.id.id) ;
        Nombre = (EditText)findViewById(R.id.Nombre) ;
        Precio = (EditText)findViewById(R.id.Precio) ;
        noPiezas = (EditText)findViewById(R.id.Piezas) ;
        desc = (EditText)findViewById(R.id.desc) ;

    }


    public void buscar(View view) {
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

    public void actualizar(View view) {
        BaseD admin = new BaseD(this, "administracion", null, 1);
        SQLiteDatabase BaseDatabase = admin.getWritableDatabase();

        String Codigo = codigo.getText().toString();
        String nombre = Nombre.getText().toString();
        String precio = Precio.getText().toString();
        String Piezas = noPiezas.getText().toString();
        String descc = desc.getText().toString();

        if(!Codigo.isEmpty() && !nombre.isEmpty() && !precio.isEmpty() && !Piezas.isEmpty() && !descc.isEmpty()) {
            ContentValues registro = new ContentValues();
            {

                registro.put("codigo", Codigo);
                registro.put("nombre", nombre);
                registro.put("precio", precio);
                registro.put("piezas", Piezas);
                registro.put("descr", descc);

                int cantidad = BaseDatabase.update("productos", registro, "codigo=" + codigo, null);
                BaseDatabase.close();

                if (cantidad == 1) {
                    Toast.makeText(this, "Artículo modificado correctamente", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "El artículo no existe", Toast.LENGTH_SHORT).show();
                }

            }
        } else {
            Toast.makeText(this, "Debes llenar todos los campos", Toast.LENGTH_SHORT).show();
        }
    }
    }
