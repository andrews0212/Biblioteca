package modelo.Gestion;

import modelo.DTO.Ejemplar;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.memoria.MemoriaGN;

import java.time.LocalDate;

public class GestionPrestamo {
    MemoriaGN<Prestamo, Integer> memoriaPrestamo;

    public GestionPrestamo() {
        this.memoriaPrestamo = new MemoriaGN<>(Prestamo.class);
    }
    private boolean comprobarPrestamosUsuarios(Usuario usuario) {
        int contador = 0;
        for(Prestamo p : memoriaPrestamo.findAll()){
            if (p.getUsuario().equals(usuario)){
                contador++;
            }
            if (contador == 3){
                return false;
            }
        }
        return true;
    }

    public void crearPrestamo(Usuario usuario, Ejemplar ejemplar) {
        if (comprobarPrestamosUsuarios(usuario) && (usuario.getPenalizacionHasta() == null)) {

            LocalDate fecha = LocalDate.now();
            LocalDate fechaFinal = LocalDate.now().plusDays(15);
            memoriaPrestamo.add(new Prestamo(usuario, ejemplar, fecha, fechaFinal));

        } else {
            System.out.println("No se puede crear el prestamo");
        }
    }

    public MemoriaGN<Prestamo, Integer> getMemoriaPrestamo() {
        return memoriaPrestamo;
    }

    public void setMemoriaPrestamo(MemoriaGN<Prestamo, Integer> memoriaPrestamo) {
        this.memoriaPrestamo = memoriaPrestamo;
    }
}
