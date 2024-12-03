package controlador;

import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.Gestion.GestionPrestamo;
import modelo.Gestion.GestionUsuario;
import vista.MenuUsuarioNormal;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class ControlUsuarioNormal implements ActionListener {

    GestionUsuario gestionUsuario;
    GestionPrestamo gestionPrestamo;
    MenuUsuarioNormal menuUsuarioNormal;
    Usuario usuario;

    public ControlUsuarioNormal(GestionUsuario gestionUsuario, GestionPrestamo gestionPrestamo, MenuUsuarioNormal menuUsuarioNormal, Usuario usuario) {
        this.gestionUsuario = gestionUsuario;
        this.gestionPrestamo = gestionPrestamo;
        this.usuario = usuario;
        this.menuUsuarioNormal = menuUsuarioNormal;
        this.menuUsuarioNormal.pack();
        this.menuUsuarioNormal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.menuUsuarioNormal.setLocationRelativeTo(null);
        cargarUsuario();
        this.menuUsuarioNormal.getTable1().repaint();
    }

    public ControlUsuarioNormal(GestionUsuario gestionUsuario, GestionPrestamo gestionPrestamo, MenuUsuarioNormal menuUsuarioNormal) {
        this.gestionUsuario = gestionUsuario;
        this.gestionPrestamo = gestionPrestamo;
        this.menuUsuarioNormal = menuUsuarioNormal;
        this.menuUsuarioNormal.pack();
        this.menuUsuarioNormal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.menuUsuarioNormal.setLocationRelativeTo(null);
        cargarUsuario();
        menuUsuarioNormal.getTable1().revalidate();  // Esto valida de nuevo la tabla y asegura que se actualice
        menuUsuarioNormal.getTable1().repaint();     // Esto vuelve a dibujar la tabla

    }

    public void cargarUsuario() {
        List<Prestamo> prestamos = gestionPrestamo.getMemoriaPrestamo().findAll().stream().filter(p -> p.getUsuario().getId().equals(usuario.getId())).toList();
        DefaultTableModel defaultTableModel = (DefaultTableModel) menuUsuarioNormal.getTable1().getModel();
        for (Prestamo prestamo : prestamos) {
            defaultTableModel.addRow(new Object[]{prestamo.getEjemplar().getId(), prestamo.getFechaInicio().toString(), prestamo.getFechaDevolucion().toString()});
        }
        menuUsuarioNormal.getTable1().setModel(defaultTableModel);
    }

    public GestionUsuario getGestionUsuario() {
        return gestionUsuario;
    }

    public void setGestionUsuario(GestionUsuario gestionUsuario) {
        this.gestionUsuario = gestionUsuario;
    }

    public GestionPrestamo getGestionPrestamo() {
        return gestionPrestamo;
    }

    public void setGestionPrestamo(GestionPrestamo gestionPrestamo) {
        this.gestionPrestamo = gestionPrestamo;
    }

    public MenuUsuarioNormal getMenuUsuarioNormal() {
        return menuUsuarioNormal;
    }

    public void setMenuUsuarioNormal(MenuUsuarioNormal menuUsuarioNormal) {
        this.menuUsuarioNormal = menuUsuarioNormal;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

    }

    public static void main(String[] args) {
        ControlUsuarioNormal controlUsuarioNormal = new ControlUsuarioNormal(new GestionUsuario(),new GestionPrestamo(),new MenuUsuarioNormal());
        controlUsuarioNormal.getMenuUsuarioNormal().setVisible(true);
    }
}
