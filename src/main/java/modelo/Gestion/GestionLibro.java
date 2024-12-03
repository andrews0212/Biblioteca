package modelo.Gestion;

import modelo.DAO.DAOGN;
import modelo.DTO.Libro;
import modelo.memoria.MemoriaGN;

import java.util.ArrayList;

public class GestionLibro {

    MemoriaGN<Libro, String> memoriaLibros;

    public GestionLibro() {
        memoriaLibros = new MemoriaGN<>(Libro.class);
    }

    public void añadirLibro(Libro libro) {
        memoriaLibros.add(libro);
    }


}
