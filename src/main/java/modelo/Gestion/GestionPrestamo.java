package modelo.Gestion;

import modelo.DTO.Ejemplar;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.memoria.MemoriaGN;

import javax.swing.*;
import java.time.LocalDate;

public class GestionPrestamo {
    MemoriaGN<Prestamo, Integer> memoriaPrestamo;
    GestionEjemplar gestionEjemplar;
    public GestionPrestamo() {
        this.memoriaPrestamo = new MemoriaGN<>(Prestamo.class);
        gestionEjemplar = new GestionEjemplar();
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

    public void crearPrestamo(Usuario usuario, Ejemplar ejemplar) throws IllegalArgumentException {
        if (comprobarPrestamosUsuarios(usuario)){
            if(usuario.getPenalizacionHasta() == null) {

                LocalDate fecha = LocalDate.now();
                LocalDate fechaFinal = LocalDate.now().plusDays(15);
                ejemplar.setEstado("Prestado");
                gestionEjemplar.getMemoriaEjemplar().update(ejemplar);
                memoriaPrestamo.add(new Prestamo(usuario, ejemplar, fecha, fechaFinal));

            } else {
                System.out.println("No se puede crear el prestamo");
            }
        }else {

            throw new IllegalArgumentException("ha agotado la cantidad de prestamos");
        }
    }

    public MemoriaGN<Prestamo, Integer> getMemoriaPrestamo() {
        return memoriaPrestamo;
    }

    public void setMemoriaPrestamo(MemoriaGN<Prestamo, Integer> memoriaPrestamo) {
        this.memoriaPrestamo = memoriaPrestamo;
    }
}
