package modelo.Gestion;

import modelo.DTO.Ejemplar;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.memoria.MemoriaGN;

import java.time.LocalDate;
import java.util.Locale;

public class GestionUsuario {

    private MemoriaGN<Usuario, Integer> memoriaUsuario;
    private MemoriaGN<Ejemplar, Integer> memoriaEjemplar;
    private MemoriaGN<Prestamo, Integer> memoriaPrestamo;

    public GestionUsuario() {
        memoriaUsuario = new MemoriaGN<>(Usuario.class);
        memoriaEjemplar = new MemoriaGN<>(Ejemplar.class);
        memoriaPrestamo = new MemoriaGN<>(Prestamo.class);
    }


    public MemoriaGN<Usuario, Integer> getMemoriaUsuario() {
        return memoriaUsuario;
    }

    public void setMemoriaUsuario(MemoriaGN<Usuario, Integer> memoriaUsuario) {
        this.memoriaUsuario = memoriaUsuario;
    }
    public void devolverEjemplar(Usuario usuario, int idEjemplar, LocalDate localeDate){
            Ejemplar ejemplar = memoriaEjemplar.findById(idEjemplar);
            if (ejemplar != null){
                Prestamo prestamo = memoriaPrestamo.findAll().stream().filter(p -> p.getEjemplar().equals(ejemplar.getId()) && p.getUsuario().equals(usuario)).findFirst().get();
                if (prestamo != null){
                    if (prestamo.getFechaDevolucion().isAfter(localeDate)){
                        if (usuario.getPenalizacionHasta() != null){
                            usuario.setPenalizacionHasta(usuario.getPenalizacionHasta().plusDays(15));
                        }else{
                            usuario.setPenalizacionHasta(localeDate.plusDays(15));
                        }
                    }
                    ejemplar.setEstado("Disponible");
                    memoriaEjemplar.update(ejemplar);
                }

            }

    }
}
