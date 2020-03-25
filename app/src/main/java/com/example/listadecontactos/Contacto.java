package com.example.listadecontactos;

import java.util.HashMap;
import java.util.Map;

public class Contacto extends HashMap<String, String> {

    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.put("Primera linea", nombre);
        this.put("Segunda linea", telefono);
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
