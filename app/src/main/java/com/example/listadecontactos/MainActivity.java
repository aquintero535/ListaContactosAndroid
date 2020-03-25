package com.example.listadecontactos;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.SimpleCursorAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;
    private HashMap<String, String> contactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), CrearContacto.class);
                startActivityForResult(intent, 0);
            }
        });

        listaContactos = (ListView)findViewById(R.id.listview);

        Contacto con1 = new Contacto("Adrian", "6849-5334");
        Contacto con2 = new Contacto("Fulanito", "68739-376");

        List<Contacto> lista = new ArrayList<>();

        lista.add(con1);
        lista.add(con2);
        try{
            String nombre = getIntent().getStringExtra("Nombre");
            String telefono = getIntent().getStringExtra("Telefono");
            Contacto con3 = new Contacto(nombre, telefono);
            lista.add(con3);
        } catch (Exception e){
            System.out.println(e.getMessage());
        };


        HashMap<String, String> mapasLista = new HashMap<>();

        SimpleAdapter adapter = new SimpleAdapter(this,
                lista,
                R.layout.list_items,
                new String[]{"Primera linea", "Segunda linea"},
                new int[]{R.id.text1, R.id.text2}
                );

        listaContactos.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
