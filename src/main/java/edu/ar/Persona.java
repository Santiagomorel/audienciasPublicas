package edu.ar;

import edu.ar.converters.MedioDeComunicacionConverter;
import lombok.Setter;

import javax.persistence.*;

@Setter
@Entity
@Table(name = "persona")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "tipo_persona")
public abstract class Persona implements Contactable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cuit_cuil")
    private String cuitCuil;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "direccion_id", referencedColumnName = "id")
    private Direccion direccion;

    @Column(name = "medioPreferido")
    @Convert(converter = MedioDeComunicacionConverter.class)
    private MedioDeComunicacion medioPreferido;

    public abstract String nombre();
}
