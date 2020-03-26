package com.example.listadecontactos;

import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        TextView aviso = (TextView)findViewById(R.id.avisoNoHayContactos);
        listaContactos = (ListView)findViewById(R.id.listview);

        //Si la lista de contactos no está vacía, elimina el TextView "No ha añadido ningun contacto"
        if (!ListaContactos.getListaContactos().isEmpty()){
            aviso.setVisibility(View.GONE);
        }

        //Adaptador del ArrayList para el ListView.
        SimpleAdapter adapter = new SimpleAdapter(this,
                (ArrayList<Contacto>)ListaContactos.getListaContactos(),
                R.layout.list_items,
                new String[]{"Primera linea", "Segunda linea"},
                new int[]{R.id.text1, R.id.text2}
                );

        //Se añade el adaptador al ListView.
        listaContactos.setAdapter(adapter);

        //Botón para ingresar al segundo Activity (añadir nuevo contacto).
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityNuevoContacto.class);
                startActivityForResult(intent, 0);
            }
        });
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
