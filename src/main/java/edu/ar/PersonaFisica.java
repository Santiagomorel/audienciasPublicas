package edu.ar;

import edu.ar.converters.LocalDateConverter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.sql.Date;
import java.time.LocalDate;

@Setter
@Entity
@DiscriminatorValue("fisica")
public class PersonaFisica extends Persona {

    @Column(name = "apellido")
    private String apellido;

    @Column(name = "email")
    private String email;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "telefono")
    private String telefono;

    @Column(name = "fechaDeNacimiento")
    @Convert(converter = LocalDateConverter.class)
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
