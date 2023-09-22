package edu.ar;

import javax.persistence.*;

@Entity
@Table(name = "direccion")
public class Direccion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "altura")
    private Integer altura;

    @Column(name = "calle")
    private String calle;

    @Column(name = "localidadBarrio")
    private String localidadBarrio;

    @Column(name = "municipio_comuna")
    private String municipioComuna;

    @Column(name = "provincia")
    private String provincia;

    public Direccion(Integer altura, String calle, String localidadBarrio, String municipioComuna, String provincia) {
        this.altura = altura;
        this.calle = calle;
        this.localidadBarrio = localidadBarrio;
        this.municipioComuna = municipioComuna;
        this.provincia = provincia;
    }

    public Direccion() {

    }

    public String leyendaCompleta(){
        //TODO
        return "holis";
    }
}
