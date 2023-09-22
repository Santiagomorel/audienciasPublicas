package edu.ar;

import edu.ar.converters.LocalDateConverter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Setter
@Entity
@DiscriminatorValue(value = "juridica")
public class PersonaJuridica extends Persona {
    @ElementCollection
    private List<String> telefonosDeContacto;

    @ElementCollection
    private List<String> emailsDeContacto;

    @Column(name = "razon_social")
    private String razonSocial;

    @Column(name = "fechaDeConstitucion")
    @Convert(converter = LocalDateConverter.class)
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
