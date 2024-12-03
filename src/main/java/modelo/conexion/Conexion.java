package modelo.conexion;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

import javax.swing.text.html.parser.Entity;

public class Conexion {

    private static EntityManager em;
    private static EntityManagerFactory emf;

    public static EntityManager getEntityManager() {
        if (emf == null) {
            emf = Persistence.createEntityManagerFactory("miPersistencia");
        }
        if (em == null) {
            em = emf.createEntityManager();
        }
        return em;
    }
}
