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
        this.menuUsuarioNormal.getEntregarEjemplarButton().addActionListener(this);
        this.menuUsuarioNormal.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.menuUsuarioNormal.setLocationRelativeTo(null);
        cargarUsuario();

    }


    public void cargarUsuario() {
        if (usuario == null) {
            JOptionPane.showMessageDialog(menuUsuarioNormal, "Usuario no inicializado", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Obtener préstamos del usuario
        List<Prestamo> prestamos = gestionPrestamo.getMemoriaPrestamo().findAll().stream()
                .filter(p -> p.getUsuario().getId().equals(usuario.getId()))
                .toList();

        // Limpiar el modelo
        DefaultTableModel defaultTableModel = (DefaultTableModel) menuUsuarioNormal.getTable1().getModel();
        defaultTableModel.setRowCount(0);

        // Agregar las filas actualizadas
        for (Prestamo prestamo : prestamos) {
            defaultTableModel.addRow(new Object[]{
                    prestamo.getEjemplar().getId(),
                    prestamo.getFechaInicio().toString(),
                    prestamo.getFechaDevolucion().toString()
            });
        }

        // Revalidar y repintar la tabla
        menuUsuarioNormal.getTable1().revalidate();
        menuUsuarioNormal.getTable1().repaint();
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
        if (e.getSource() == menuUsuarioNormal.getEntregarEjemplarButton()) {
            int numeroFila = menuUsuarioNormal.getTable1().getSelectedRow();
            if (numeroFila != -1) {
                int idEjemplar = Integer.parseInt(menuUsuarioNormal.getTable1().getValueAt(numeroFila, 0).toString());
                gestionUsuario.devolverEjemplar(gestionPrestamo,usuario, idEjemplar);

                // Mostrar mensaje de éxito
                JOptionPane.showMessageDialog(menuUsuarioNormal, "Ejemplar entregado correctamente.", "Éxito", JOptionPane.INFORMATION_MESSAGE);

                // Actualizar la tabla
                cargarUsuario();

            } else {
                JOptionPane.showMessageDialog(menuUsuarioNormal, "Por favor, seleccione una fila para continuar.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        }
    }



}
