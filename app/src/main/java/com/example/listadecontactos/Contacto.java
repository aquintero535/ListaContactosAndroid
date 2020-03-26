package com.example.listadecontactos;

import java.util.HashMap;


public class Contacto extends HashMap<String, String> {
    //Cada objeto contacto es un HashMap.

    private String nombre;
    private String telefono;

    public Contacto(String nombre, String telefono) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.put("Primera linea", nombre); //La primera línea que corresponde al nombre
        this.put("Segunda linea", telefono); //La segunda línea que corresponde al num. de teléfono
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }
}
