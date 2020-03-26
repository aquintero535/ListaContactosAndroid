package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityNuevoContacto extends AppCompatActivity {

    private EditText et_nombre, et_telefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);
        et_nombre = (EditText)findViewById(R.id.txt_nombre);
        et_telefono = (EditText)findViewById(R.id.txt_telefono);
        Button botonGuardar = (Button)findViewById(R.id.button);
        Button botonRegresar = (Button)findViewById(R.id.button2);
        botonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                guardar(v);
            }
        });
        botonRegresar.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                regresar(v);
            }
        });

    }

    //Crea un nuevo objeto Contacto (Hashmap) y lo guarda en el ArrayList de ListaContactos.
    //después, finaliza el Activity.
    public void guardar(View view){
        String nombre = et_nombre.getText().toString();
        String telefono = et_telefono.getText().toString();
        if (nombre.isEmpty() || telefono.isEmpty()){
            Toast.makeText(this, "Los campos no pueden estar vacíos.", Toast.LENGTH_LONG).show();
            return;
        }
        Contacto contacto = new Contacto(nombre, telefono);
        ListaContactos.aniadirContacto(contacto);
        /*
        //Crea un intent para regresar al ActivityPrincipal
        Intent intent2 = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent2, 0);*/

        this.finish();
        Toast.makeText(this, "El contacto ha sido guardado.", Toast.LENGTH_SHORT).show();
    }

    public void regresar(View view){
        /*Intent intent3 = new Intent(view.getContext(), MainActivity.class);
        startActivityForResult(intent3, 0);*/
        this.finish();
    }
}
