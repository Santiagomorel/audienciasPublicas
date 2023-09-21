package edu.ar;

import java.time.LocalDate;
import java.util.List;

public class PersonaJuridica extends Persona {
    private List<String> telefonosDeContacto;
    private List<String> emailsDeContacto;
    private String razonSocial;
    private LocalDate fechaConstitucion;

    @Override
    public String nombre() {
        return razonSocial;
    }

    @Override
    public String emailPreferido() {
        return emailsDeContacto.get(0);
    }

    @Override
    public String numeroPreferido() {
        return telefonosDeContacto.get(0);
    }
}
