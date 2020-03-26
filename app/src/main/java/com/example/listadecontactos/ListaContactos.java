package com.example.listadecontactos;

import java.util.ArrayList;
import java.util.List;

public class ListaContactos {

    private static List<Contacto> listaContactos = new ArrayList<>();;

    public ListaContactos(){
    }

    public static void aniadirContacto(Contacto nuevoContacto){
        listaContactos.add(nuevoContacto);
    }

    public static List<Contacto> getListaContactos(){
        return listaContactos;
    }

}
