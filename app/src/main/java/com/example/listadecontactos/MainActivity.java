package com.example.listadecontactos;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Vibrator;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listaContactos;
    private TextView aviso;
    private SimpleAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        aviso = (TextView)findViewById(R.id.avisoNoHayContactos);
        listaContactos = (ListView)findViewById(R.id.listview);

        //Al tocar un contacto, se abre una pantalla para mostrar los detalles del contacto.
        listaContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Obtiene el objeto Contacto escogido.
                Contacto contacto = (Contacto) parent.getAdapter().getItem(position);
                Intent detallesContacto = new Intent (view.getContext(),
                        ActivityDetallesContacto.class);

                //Envía los datos a la otra pantalla y la muestra.
                detallesContacto.putExtra("Nombre", contacto.getNombre());
                detallesContacto.putExtra("Telefono", contacto.getTelefono());
                detallesContacto.putExtra("Correo", contacto.getCorreo());
                startActivity(detallesContacto);
            }
        });

        //Al mantener presionado un contacto, se elimina y se recarga la lista de contactos.
        listaContactos.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ListaContactos.getListaContactos().remove(position);
                //Vibra al eliminar un contacto.
                Vibrator vibe = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                vibe.vibrate(100);
                cargarListaDeContactos();
                Toast.makeText(MainActivity.this, "Contacto eliminado", Toast.LENGTH_LONG).show();
                return false;
            }
        });

        //Botón para ingresar al segundo Activity (añadir nuevo contacto).
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), ActivityNuevoContacto.class);
                startActivityForResult(intent, 0);
            }
        });

        cargarListaDeContactos();
    }

    //Recarga la lista de contactos.
    protected void onResume(){
        super.onResume();
        cargarListaDeContactos();
    }

    private void cargarListaDeContactos(){
        //Si la lista de contactos está vacía, muestra el TextView "No hay contactos en la lista."
        if (ListaContactos.getListaContactos().isEmpty()){
            this.aviso.setVisibility(View.VISIBLE);
        } else {
            this.aviso.setVisibility(View.GONE);
        }

        //Adaptador del ArrayList para el ListView.
        adapter = new SimpleAdapter(this,
                ListaContactos.getListaContactos(),
                R.layout.list_items,
                new String[]{"Primera linea", "Segunda linea"},
                new int[]{R.id.text1, R.id.text2}
        );

        //Se añade el adaptador al ListView.
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
