package controlador;

import modelo.DTO.Ejemplar;
import modelo.DTO.Prestamo;
import modelo.DTO.Usuario;
import modelo.Gestion.GestionEjemplar;
import modelo.Gestion.GestionLibro;
import modelo.Gestion.GestionPrestamo;
import modelo.Gestion.GestionUsuario;
import vista.MenuUsuarioAdmin;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;

public class ControladorUsuarioAdmin implements ActionListener {


    GestionUsuario gestionUsuario;
    GestionPrestamo gestionPrestamo;
    GestionEjemplar gestionEjemplar;
    GestionLibro gestionLibro;
    MenuUsuarioAdmin menuUsuarioAdmin;
    Usuario usuario;

    public ControladorUsuarioAdmin(GestionUsuario gestionUsuario, GestionPrestamo gestionPrestamo, GestionEjemplar gestionEjemplar, GestionLibro gestionLibro, Usuario usuario, MenuUsuarioAdmin menuUsuarioAdmin) {
        this.gestionUsuario = gestionUsuario;
        this.gestionPrestamo = gestionPrestamo;
        this.gestionEjemplar = gestionEjemplar;
        this.gestionLibro = gestionLibro;
        this.menuUsuarioAdmin = menuUsuarioAdmin;
        this.usuario = usuario;
        this.menuUsuarioAdmin.pack();
        this.menuUsuarioAdmin.setLocationRelativeTo(null);
        this.menuUsuarioAdmin.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        this.menuUsuarioAdmin.getCrearButton1().addActionListener(this);
        this.menuUsuarioAdmin.getBuscarButton().addActionListener(this);
        this.menuUsuarioAdmin.getModificarButton().addActionListener(this);
        this.menuUsuarioAdmin.getEliminarButton().addActionListener(this);

        this.menuUsuarioAdmin.getVistaBuscar().getBuscarTodoButton().addActionListener(this);
        this.menuUsuarioAdmin.getVistaBuscar().getBuscarButton1().addActionListener(this);
        this.menuUsuarioAdmin.getVistaBuscar().getLimpiarButton().addActionListener(this);

        this.menuUsuarioAdmin.getVistaCrear().getCrearButton().addActionListener(this);

        this.menuUsuarioAdmin.getVistaModificar().getModificarButton().addActionListener(this);
        this.menuUsuarioAdmin.getVistaEliminar().getEliminarButton().addActionListener(this);



    }

    private void barraHorizontal (ActionEvent e){
        if (e.getSource() == menuUsuarioAdmin.getCrearButton1()) {
            menuUsuarioAdmin.getJpanelEliminar().setVisible(false);
            menuUsuarioAdmin.getJpanelPrestamo().setVisible(false);
            menuUsuarioAdmin.getJpanelBuscar().setVisible(false);
            menuUsuarioAdmin.getJpanelCrear().setVisible(true);


        } else if (e.getSource() == menuUsuarioAdmin.getBuscarButton()) {
            menuUsuarioAdmin.getJpanelEliminar().setVisible(false);
            menuUsuarioAdmin.getJpanelPrestamo().setVisible(false);
            menuUsuarioAdmin.getJpanelCrear().setVisible(false);
            menuUsuarioAdmin.getJpanelBuscar().setVisible(true);


        } else if (e.getSource() == menuUsuarioAdmin.getModificarButton()) {
            menuUsuarioAdmin.getJpanelEliminar().setVisible(false);
            menuUsuarioAdmin.getJpanelCrear().setVisible(false);
            menuUsuarioAdmin.getJpanelBuscar().setVisible(false);
            menuUsuarioAdmin.getJpanelPrestamo().setVisible(true);

        } else if (e.getSource() == menuUsuarioAdmin.getJpanelPrestamo()) {
            menuUsuarioAdmin.getJpanelEliminar().setVisible(false);
            menuUsuarioAdmin.getJpanelPrestamo().setVisible(false);
            menuUsuarioAdmin.getJpanelBuscar().setVisible(false);
            menuUsuarioAdmin.getJpanelCrear().setVisible(true);

        } else if (e.getSource() == menuUsuarioAdmin.getEliminarButton()) {

            menuUsuarioAdmin.getJpanelPrestamo().setVisible(false);
            menuUsuarioAdmin.getJpanelBuscar().setVisible(false);
            menuUsuarioAdmin.getJpanelCrear().setVisible(false);
            menuUsuarioAdmin.getJpanelEliminar().setVisible(true);

        }
    }
    private void accionBusqueda (ActionEvent e){


        if (e.getSource() == menuUsuarioAdmin.getVistaBuscar().getBuscarTodoButton()) {

            DefaultTableModel defaultTableModel = (DefaultTableModel) menuUsuarioAdmin.getVistaBuscar().getTable1().getModel();
            defaultTableModel.setRowCount(0);
            for (Prestamo prestamo :  gestionPrestamo.getMemoriaPrestamo().findAll()) {
                defaultTableModel.addRow(new Object[]{prestamo.getId(), prestamo.getUsuario().getId(), prestamo.getEjemplar().getId(), prestamo.getFechaInicio().toString(), prestamo.getFechaDevolucion().toString()});
            }
            menuUsuarioAdmin.getVistaBuscar().getTable1().setModel(defaultTableModel);
        } else if (e.getSource() == menuUsuarioAdmin.getVistaBuscar().getLimpiarButton()) {
            DefaultTableModel defaultTableModel = (DefaultTableModel) menuUsuarioAdmin.getVistaBuscar().getTable1().getModel();
            defaultTableModel.setRowCount(0);
        } else if (e.getSource() == menuUsuarioAdmin.getVistaBuscar().getBuscarButton1()) {
            int id = Integer.parseInt(menuUsuarioAdmin.getVistaBuscar().getTextField1().getText());
            DefaultTableModel defaultTableModel = (DefaultTableModel) menuUsuarioAdmin.getVistaBuscar().getTable1().getModel();

            boolean existe = false;

            // Iterar sobre los préstamos y verificar si ya están en la tabla
            for (Prestamo prestamo : gestionPrestamo.getMemoriaPrestamo().findAll()) {
                if (prestamo.getId() == id) {
                    existe = false;

                    // Verificar si el ID ya existe en la tabla
                    for (int i = 0; i < defaultTableModel.getRowCount(); i++) {
                        if ((int) defaultTableModel.getValueAt(i, 0) == prestamo.getId()) {
                            existe = true;
                            break;
                        }
                    }

                    // Si no existe, agregarlo
                    if (!existe) {
                        defaultTableModel.addRow(new Object[]{
                                prestamo.getId(),
                                prestamo.getUsuario().getId(),
                                prestamo.getEjemplar().getId(),
                                prestamo.getFechaInicio().toString(),
                                prestamo.getFechaDevolucion().toString()
                        });
                    }
                }
            }
        }
    }


    private void accionCrear (ActionEvent e){
        if (e.getSource() == menuUsuarioAdmin.getVistaCrear().getCrearButton()) {
          int idUsuario = Integer.parseInt(menuUsuarioAdmin.getVistaCrear().getTextFieldUsuario().getText());
          int idEjemplar = Integer.parseInt(menuUsuarioAdmin.getVistaCrear().getTextFieldEjemplar().getText());


            // Convertir a LocalDate


            Usuario usuario = gestionUsuario.getMemoriaUsuario().findById(idUsuario);
            Ejemplar ejemplar = gestionEjemplar.getMemoriaEjemplar().findById(idEjemplar);

            if (usuario != null && ejemplar != null) {
                if (ejemplar.getEstado().equals("Disponible")){

                    try{
                        gestionPrestamo.crearPrestamo(usuario,ejemplar);
                        JOptionPane.showMessageDialog(null, "Si se ha podido crear el prestamo", "Información", JOptionPane.INFORMATION_MESSAGE);
                    }catch (Exception ex){
                        JOptionPane.showMessageDialog(null, ex.getMessage());
                    }


                } else{
                    JOptionPane.showMessageDialog(null, "El ejemplar no esta disponible", "Información", JOptionPane.INFORMATION_MESSAGE);
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se ha podido crear el prestamo", "Información", JOptionPane.INFORMATION_MESSAGE);
            }


        }
    }

    public void accionModificar(ActionEvent e){
        if (e.getSource() == menuUsuarioAdmin.getVistaModificar().getModificarButton()) {
          int idPrestamo = Integer.parseInt(menuUsuarioAdmin.getVistaModificar().getTextFieldPrestamos().getText());
          Prestamo p = gestionPrestamo.getMemoriaPrestamo().findById(idPrestamo);
          if (p != null) {
              if (!menuUsuarioAdmin.getVistaModificar().getTextFieldUsuario().getText().isBlank()){
                  Usuario usuario = gestionUsuario.getMemoriaUsuario().findById(idPrestamo);
                  if (usuario != null) {
                      p.setUsuario(usuario);
                  }

              }
              if (!menuUsuarioAdmin.getVistaModificar().getTextFieldEjemplar().getText().isBlank()){
                  Ejemplar ejemplar = gestionEjemplar.getMemoriaEjemplar().findById(idPrestamo);
                  if (ejemplar != null) {
                      p.setEjemplar(ejemplar);
                  }
              }
              if (menuUsuarioAdmin.getVistaModificar().getDateChooserInicio().isEnabled()){
                  LocalDate LocalDate = menuUsuarioAdmin.getVistaModificar().getDateChooserInicio().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  p.setFechaInicio(LocalDate);
              }
              if (menuUsuarioAdmin.getVistaModificar().getDateChooserFin().isEnabled()){
                  LocalDate LocalDate = menuUsuarioAdmin.getVistaModificar().getDateChooserFin().getDate().toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
                  p.setFechaDevolucion(LocalDate);
              }

              gestionPrestamo.getMemoriaPrestamo().update(p);
              JOptionPane.showMessageDialog(null, "se ha modificado Correctamente.", "Información", JOptionPane.INFORMATION_MESSAGE);

          } else{
              JOptionPane.showMessageDialog(null, "no se ha podido modificar.", "Información", JOptionPane.INFORMATION_MESSAGE);
          }
        }

    }

    public void accionEliminar(ActionEvent e){
        if (e.getSource() == menuUsuarioAdmin.getVistaEliminar().getEliminarButton()) {
            int idPrestamo = Integer.parseInt(menuUsuarioAdmin.getVistaEliminar().getTextFieldPrestamo().getText());
            Prestamo p = gestionPrestamo.getMemoriaPrestamo().findById(idPrestamo);
            if (p != null) {
                gestionPrestamo.getMemoriaPrestamo().remove(p);
                JOptionPane.showMessageDialog(null, "Se ha eliminado Correctamente", "Información", JOptionPane.INFORMATION_MESSAGE);
            } else{
                JOptionPane.showMessageDialog(null, "No hay prestamo", "Información", JOptionPane.INFORMATION_MESSAGE);
            }

        }
    }




    @Override
    public void actionPerformed(ActionEvent e) {
        barraHorizontal(e);
        accionBusqueda(e);
        accionCrear(e);
        accionModificar(e);
        accionEliminar(e);


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

    public GestionEjemplar getGestionEjemplar() {
        return gestionEjemplar;
    }

    public void setGestionEjemplar(GestionEjemplar gestionEjemplar) {
        this.gestionEjemplar = gestionEjemplar;
    }

    public GestionLibro getGestionLibro() {
        return gestionLibro;
    }

    public void setGestionLibro(GestionLibro gestionLibro) {
        this.gestionLibro = gestionLibro;
    }

    public MenuUsuarioAdmin getMenuUsuarioAdmin() {
        return menuUsuarioAdmin;
    }

    public void setMenuUsuarioAdmin(MenuUsuarioAdmin menuUsuarioAdmin) {
        this.menuUsuarioAdmin = menuUsuarioAdmin;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
}
