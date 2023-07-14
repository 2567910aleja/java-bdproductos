package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.productos.Models.Marcas;

public class ActivityIngresarMarca extends AppCompatActivity {
    Button btnGuardar,btnListar, cancelar;
    EditText nombre,desc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar_marca);
        btnGuardar=findViewById(R.id.btnGuardar);
        btnListar=findViewById(R.id.btnListar);
        nombre=findViewById(R.id.nombre);
        desc=findViewById(R.id.descripcion);
        cancelar=findViewById(R.id.cancelar);

        cancelar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(ActivityIngresarMarca.this,MainActivity.class);
                startActivity(intento);
            }
        });

        //funcion del boton listar
        btnListar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(ActivityIngresarMarca.this,ActivityListaMarcas.class);
                startActivity(intento);
            }
        });
        btnGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String nombreV=nombre.getText().toString();
                String descV=desc.getText().toString();

                // Creo un objeto de tipo marca
                Marcas marcaobj=new Marcas();
                marcaobj.setDescripcion(descV);
                marcaobj.setNombre(nombreV);
                marcaobj.crearMarca(ActivityIngresarMarca.this);
                Toast.makeText(ActivityIngresarMarca.this, "SE CREO LA MARCA: "+nombreV, Toast.LENGTH_SHORT).show();
                nombre.setText("");
                desc.setText("");
            }
        });
    }
}