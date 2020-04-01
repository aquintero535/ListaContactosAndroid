package com.example.listadecontactos;

import java.util.HashMap;


public class Contacto extends HashMap<String, String> {
    //Cada objeto contacto es un HashMap.

    private String nombre;
    private String telefono;
    private String correo;

    public Contacto(String nombre, String telefono, String correo) {
        this.nombre = nombre;
        this.telefono = telefono;
        this.correo = correo;
        this.put("Primera linea", nombre); //La primera línea que corresponde al nombre
        this.put("Segunda linea", telefono); //La segunda línea que corresponde al num. de teléfono
    }

    public String getNombre() {
        return nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public String getCorreo() { return correo; }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
}
