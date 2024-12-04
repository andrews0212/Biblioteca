package modelo.Gestion;

import modelo.DTO.Ejemplar;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.memoria.MemoriaGN;

import java.time.LocalDate;
import java.util.Locale;
import java.util.Optional;

public class GestionUsuario {

    private MemoriaGN<Usuario, Integer> memoriaUsuario;
    private GestionPrestamo gestionPrestamo;

    public GestionUsuario() {
        memoriaUsuario = new MemoriaGN<>(Usuario.class);

    }


    public MemoriaGN<Usuario, Integer> getMemoriaUsuario() {
        return memoriaUsuario;
    }

    public void setMemoriaUsuario(MemoriaGN<Usuario, Integer> memoriaUsuario) {
        this.memoriaUsuario = memoriaUsuario;
    }
    public void devolverEjemplar(GestionPrestamo gestionPrestamo, Usuario usuario, int idEjemplar) {
        Prestamo prestamo = gestionPrestamo.getMemoriaPrestamo().findAll().stream()
                .filter(p -> p.getEjemplar().getId() == idEjemplar && p.getUsuario().getId().equals(usuario.getId()))
                .findFirst()
                .orElse(null);

        if (prestamo != null) {
            // Eliminar préstamo de la base de datos
            gestionPrestamo.getMemoriaPrestamo().remove(prestamo);

            // Eliminar también de la lista en memoria
            gestionPrestamo.getMemoriaPrestamo().findAll().remove(prestamo);
        }
    }



}

