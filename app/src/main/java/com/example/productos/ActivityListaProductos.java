package com.example.productos;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.productos.Models.Articulos;
import com.example.productos.Models.Marcas;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class ActivityListaProductos extends AppCompatActivity {
    ListView ListaProdu;
    Button volver2;
    FloatingActionButton agregarP;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_productos);
        ListaProdu=findViewById(R.id.ListaProdu);
        volver2=findViewById(R.id.volver2);
        agregarP=findViewById(R.id.agregarP);

        agregarP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(ActivityListaProductos.this,ActivityAgregarProducto.class);
                startActivity(intento);
            }
        });

        volver2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intento = new Intent(ActivityListaProductos.this,MainActivity.class);
                startActivity(intento);
            }
        });

        String [][] articulosBd= Articulos.listarArticulos(this,null, null);
        String [] nombrearticulos=new String[articulosBd.length];
        String [] nombreMarcas = new String[articulosBd.length];
        String marca="";
        String precio="";
        for (int contador = 0; contador < nombrearticulos.length;contador++){
            nombrearticulos[contador]=articulosBd[contador][1];
            marca=Marcas.listarMarcas(this,"id ="+articulosBd[contador][3],null)[0][1];
            precio=articulosBd[contador][2];
            nombreMarcas[contador]=marca+" $"+precio;
        }

        ArrayAdapter<String> miAdaptador=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2,android.R.id.text1,nombrearticulos){
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

                View vista=super.getView(position, convertView, parent);
                TextView text1 = vista.findViewById(android.R.id.text1);
                TextView text2 = vista.findViewById(android.R.id.text2);

                text1.setText(nombrearticulos[position]);
                text2.setText(nombreMarcas[position]);
                return vista;
            }
        };

        ListaProdu.setAdapter(miAdaptador);
    }
}


