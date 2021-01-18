package com.example.practica1unidad3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }




    public void actualizar(View view) {
        Intent actualizar = new Intent(this, actualizar.class);
        startActivity(actualizar);
    }

    public void consulta(View view) {
        Intent actualizar = new Intent(this, Consultar.class);
        startActivity(actualizar);
    }

    public void cargar(View view) {
        Intent actualizar = new Intent(this, Agregar.class);
        startActivity(actualizar);
    }

    public void eliminar(View view) {
        Intent actualizar = new Intent(this, eliminar.class);
        startActivity(actualizar);
    }
}