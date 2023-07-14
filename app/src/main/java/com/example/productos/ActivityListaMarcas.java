package com.example.productos;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.productos.Models.Marcas;

public class ActivityListaMarcas extends AppCompatActivity {
    ListView listaMarcasView;
    Button btnVolver;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_marcas);
        listaMarcasView=findViewById(R.id.listaMarcas);
        btnVolver=findViewById(R.id.btnVolver);

        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(ActivityListaMarcas.this,MainActivity.class);
                startActivity(intento);
            }
        });

        String [][] marcasBd= Marcas.listarMarcas(this,null, null);
        String [] nombreMarcas=new String[marcasBd.length];
        for (int contador = 0; contador < nombreMarcas.length;contador++){
            nombreMarcas[contador]=marcasBd[contador][1];
        }
        ArrayAdapter miAdaptador=new ArrayAdapter<>(this, android.R.layout.simple_list_item_1,nombreMarcas);
        listaMarcasView.setAdapter(miAdaptador);
    }
}