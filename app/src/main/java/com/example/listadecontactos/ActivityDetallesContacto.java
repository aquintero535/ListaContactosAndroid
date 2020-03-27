package com.example.listadecontactos;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ActivityDetallesContacto extends AppCompatActivity {

    private TextView dtNombreContacto;
    private TextView dtTelefonoContacto;
    private TextView dtCorreoContacto;
    private Button botonRegresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalles_contacto);
        dtNombreContacto = (TextView)findViewById(R.id.txtDetNombreContacto);
        dtTelefonoContacto = (TextView)findViewById(R.id.dtTelefonoContacto);
        dtCorreoContacto = (TextView)findViewById(R.id.dtCorreoContacto);
        dtNombreContacto.setText(this.getIntent().getCharSequenceExtra("Nombre"));
        dtTelefonoContacto.setText(this.getIntent().getCharSequenceExtra("Telefono"));
        dtCorreoContacto.setText(this.getIntent().getCharSequenceExtra("Correo"));
        botonRegresar = (Button)findViewById(R.id.detalles_boton_regresar);
        botonRegresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
