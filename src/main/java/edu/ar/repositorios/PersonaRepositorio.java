package edu.ar.repositorios;

import edu.ar.Persona;
import io.github.flbulgarelli.jpa.extras.simple.WithSimplePersistenceUnit;

import javax.persistence.EntityTransaction;
import java.util.List;

public class PersonaRepositorio implements WithSimplePersistenceUnit {

    public void guardar(Persona unaPersona) {
        EntityTransaction tx = entityManager().getTransaction();
        //tx.begin();
        entityManager().persist(unaPersona);
        tx.commit();
    }

    public void eliminar(Persona unaPersona) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().remove(unaPersona);
        tx.commit();
    }

    public void modificar(Persona unaPersona) {
        EntityTransaction tx = entityManager().getTransaction();
        tx.begin();
        entityManager().merge(unaPersona);
        tx.commit();
    }

    public Persona buscarPorId(Integer id) {
        return entityManager().find(Persona.class, id);
    }

    public List<Persona> buscarTodos() {
        return entityManager().createQuery("from " + Persona.class.getName()).getResultList();
    }
}
