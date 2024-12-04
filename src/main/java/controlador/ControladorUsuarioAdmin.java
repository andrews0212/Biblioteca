package controlador;

import modelo.DTO.Usuario;
import modelo.Gestion.GestionEjemplar;
import modelo.Gestion.GestionLibro;
import modelo.Gestion.GestionPrestamo;
import modelo.Gestion.GestionUsuario;
import vista.MenuUsuarioAdmin;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
    private void AccionBusqueda (ActionEvent e){
        if (e.getSource() == menuUsuarioAdmin.getVistaBuscar().getBuscarTodoButton()) {
            gestionPrestamo.getMemoriaPrestamo().findAll();

        }
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        barraHorizontal(e);



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
