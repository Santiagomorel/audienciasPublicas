package edu.ar;

import java.time.LocalDate;

public class PersonaFisica extends Persona {
    private String apellido;
    private String email;
    private String nombre;
    private String telefono;
    private LocalDate fechaNacimiento;

    @Override
    public String nombre() {
        return nombre;
    }

    @Override
    public String emailPreferido() {
        return email;
    }

    @Override
    public String numeroPreferido() {
        return telefono;
    }
}
