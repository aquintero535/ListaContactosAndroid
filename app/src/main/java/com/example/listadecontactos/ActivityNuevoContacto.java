package com.example.listadecontactos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.HashMap;
import java.util.Map;

public class ActivityNuevoContacto extends AppCompatActivity {

    private EditText et_nombre, et_telefono, et_Correo;
    private FirebaseFirestore db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nuevo_contacto);
        et_nombre = (EditText)findViewById(R.id.campoNombre);
        et_telefono = (EditText)findViewById(R.id.campoTelefono);
        et_Correo = (EditText)findViewById(R.id.campoCorreo);
        Button botonGuardar = (Button)findViewById(R.id.button);
        Button botonRegresar = (Button)findViewById(R.id.button2);
        db = FirebaseFirestore.getInstance();
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
        Map<String, String> nuevoContacto = new HashMap<>();
        nuevoContacto.put("nombre", nombre);
        nuevoContacto.put("telefono", telefono);
        nuevoContacto.put("correo", correo);

        db.collection("contactos").add(nuevoContacto)
                .addOnCompleteListener(new OnCompleteListener<DocumentReference>() {
                    @Override
                    public void onComplete(@NonNull Task<DocumentReference> task) {
                        Toast.makeText(ActivityNuevoContacto.this,
                                "El contacto ha sido guardado.",
                                Toast.LENGTH_SHORT)
                                .show();
                        ActivityNuevoContacto.this.finish();
                    }
                });
        //ListaContactos.aniadirContacto(new Contacto(nombre, telefono, correo));
    }

    public void regresar(View view){
        this.finish();
    }
}
