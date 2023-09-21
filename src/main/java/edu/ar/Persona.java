package edu.ar;

public abstract class Persona implements Contactable {

    private String cuitCuil;
    private Direccion direccion;
    private MedioDeComunicacion medioPreferido;

    public abstract String nombre();
}
