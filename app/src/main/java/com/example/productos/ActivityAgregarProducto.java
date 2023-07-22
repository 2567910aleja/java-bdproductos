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

import java.util.List;

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

        List<Marcas> listaMarcas = Marcas.listarMArcasObj(this,null,null);

        ArrayAdapter<Marcas> adapterMarcas = new ArrayAdapter<Marcas>(this,android.R.layout.simple_list_item_1,listaMarcas);
        listMarca.setAdapter(adapterMarcas);
        agregarProdu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String nombrePro=nombreP.getText().toString();
                String precioPro=precio.getText().toString();
                Marcas marca=(Marcas) listMarca.getSelectedItem();

                Articulos articulo=new Articulos();
                articulo.setNombre(nombrePro);
                articulo.setPrecio(Double.parseDouble(precioPro));
                articulo.setIdMarca(marca.getId());
                articulo.crearArti(ActivityAgregarProducto.this);

                Toast.makeText(ActivityAgregarProducto.this, "Producto "+articulo.getNombre()+" creado", Toast.LENGTH_SHORT).show();
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