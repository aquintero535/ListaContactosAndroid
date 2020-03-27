package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ActivityNuevoContacto extends AppCompatActivity {

    private EditText et_nombre, et_telefono, et_Correo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);
        et_nombre = (EditText)findViewById(R.id.campoNombre);
        et_telefono = (EditText)findViewById(R.id.campoTelefono);
        et_Correo = (EditText)findViewById(R.id.campoCorreo);
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
        String correo = et_Correo.getText().toString();
        if (nombre.isEmpty() || telefono.isEmpty()){
            Toast.makeText(this, "Los campos de nombre y número de teléfono no pueden estar vacíos.", Toast.LENGTH_LONG).show();
            return;
        }
        ListaContactos.aniadirContacto(new Contacto(nombre, telefono, correo));
        Toast.makeText(this, "El contacto ha sido guardado.", Toast.LENGTH_SHORT).show();
        this.finish();
    }

    public void regresar(View view){
        this.finish();
    }
}
