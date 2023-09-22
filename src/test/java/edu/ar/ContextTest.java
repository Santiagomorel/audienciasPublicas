package edu.ar;

import edu.ar.repositorios.PersonaRepositorio;
import io.github.flbulgarelli.jpa.extras.EntityManagerOps;
import io.github.flbulgarelli.jpa.extras.test.SimplePersistenceTest;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.transaction.Transaction;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

public class ContextTest implements SimplePersistenceTest {

    @Test
    void contextUp() {
        assertNotNull(entityManager());
    }

    @Test
    void contextUpWithTransaction() throws Exception {
        withTransaction(() -> {
        });
    }

    @Test
    void persistAPerson() {
        PersonaFisica persona = new PersonaFisica();
        persona.setNombre("Juan");
        persona.setApellido("Perez");
        persona.setTelefono("1234567890");
        persona.setEmail("hola@mail.com");
        persona.setCuitCuil("12345678");
        persona.setFechaNacimiento(LocalDate.now());
        Direccion dir = new Direccion(123, "Calle", "CABA", "CABA", "Argentina");
        persona.setDireccion(dir);
        persona.setMedioPreferido(new Email());
        System.out.println(persona);

        PersonaRepositorio repo = new PersonaRepositorio();
        repo.guardar(persona);
    }

    @Test
    void persistAPerson2() {
        PersonaJuridica persona = new PersonaJuridica();
        persona.setRazonSocial("JJ SRL");
        persona.setTelefonosDeContacto(List.of("1234567890", "0987654321", "123123123"));
        persona.setEmailsDeContacto(List.of("jj@jj.com", "pedro@mail.com"));
        persona.setFechaConstitucion(LocalDate.now());
        persona.setCuitCuil("12345678");
        Direccion dir = new Direccion(123, "Calle", "CABA", "CABA", "Argentina");
        persona.setDireccion(dir);
        persona.setMedioPreferido(new WhatsApp());
        System.out.println(persona);

        PersonaRepositorio repo = new PersonaRepositorio();
        repo.guardar(persona);
    }

}