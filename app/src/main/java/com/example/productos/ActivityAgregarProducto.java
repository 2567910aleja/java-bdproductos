package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.productos.Models.Articulos;
import com.example.productos.Models.Marcas;

public class ActivityAgregarProducto extends AppCompatActivity {
    EditText nombreP, precio;
    Button agregarProdu, volverInicio;
    Spinner listMarca;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_producto);

        nombreP=findViewById(R.id.nombreP);
        precio=findViewById(R.id.precio);
        agregarProdu=findViewById(R.id.agregarProdu);
        volverInicio=findViewById(R.id.volverInicio);
        listMarca=findViewById(R.id.listMarca);

        String [][] listaMarcas = Marcas.listarMarcas(this,null,null);
        String [] nMarcas = new String[listaMarcas.length+1];
        nMarcas[0]="";
        for (int i=0;i<listaMarcas.length;i++){
            nMarcas[i+1]=listaMarcas[i][1];
        }
        ArrayAdapter<String> adapterMarcas = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nMarcas);
        listMarca.setAdapter(adapterMarcas);
        agregarProdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombrePro=nombreP.getText().toString();
                String precioPro=precio.getText().toString();
                String nombreMarca=listMarca.getSelectedItem().toString();
                String idMarca=Marcas.listarMarcas(ActivityAgregarProducto.this,"nombre="+nombreMarca,null)[0][0];
                Articulos.crearMarca(ActivityAgregarProducto.this,nombrePro,Double.parseDouble(precioPro),Integer.parseInt(idMarca));
                Toast.makeText(ActivityAgregarProducto.this, "Producto "+nombrePro+" creado", Toast.LENGTH_SHORT).show();
                Intent intento=new Intent(ActivityAgregarProducto.this,ActivityListaProductos.class);
                startActivity(intento);
            }
        });
        volverInicio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento=new Intent(ActivityAgregarProducto.this,ActivityListaProductos.class);
                startActivity(intento);
            }
        });
    }
}