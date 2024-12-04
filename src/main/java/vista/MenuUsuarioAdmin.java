package vista;

import javax.swing.*;

public class MenuUsuarioAdmin extends JDialog {
    private JPanel contentPane;
    private JButton buscarButton;
    private JButton crearButton1;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JPanel jPanelContaint;
    private VistaBuscar vistaBuscar;
    private JPanel jpanelBuscar;
    private VistaCrear vistaCrear;
    private JPanel jpanelCrear;
    private VistaModificar vistaPrestamo;
    private JPanel jpanelPrestamo;
    private VistaEliminar vistaEliminar;
    private JPanel jpanelEliminar;


    public MenuUsuarioAdmin() {
        setContentPane(contentPane);
        setModal(true);
        vistaBuscar = new VistaBuscar();
        vistaCrear = new VistaCrear();
        vistaPrestamo = new VistaModificar();
        vistaEliminar = new VistaEliminar();

        jpanelCrear = vistaCrear.getPanel1();
        jpanelBuscar = vistaBuscar.getPanelBusqueda();
        jpanelPrestamo = vistaPrestamo.getPanel1();
        jpanelEliminar = vistaEliminar.getPanel1();


        jPanelContaint.add(jpanelBuscar);
        jPanelContaint.add(jpanelCrear);
        jPanelContaint.add(jpanelPrestamo);
        jPanelContaint.add(jpanelEliminar);



    }

    public VistaEliminar getVistaEliminar() {
        return vistaEliminar;
    }

    public void setVistaEliminar(VistaEliminar vistaEliminar) {
        this.vistaEliminar = vistaEliminar;
    }

    public JPanel getJpanelEliminar() {
        return jpanelEliminar;
    }

    public void setJpanelEliminar(JPanel jpanelEliminar) {
        this.jpanelEliminar = jpanelEliminar;
    }

    public VistaModificar getVistaModificar() {
        return vistaPrestamo;
    }

    public void setVistaPrestamo(VistaModificar vistaPrestamo) {
        this.vistaPrestamo = vistaPrestamo;
    }

    public JPanel getJpanelPrestamo() {
        return jpanelPrestamo;
    }

    public void setJpanelPrestamo(JPanel jpanelPrestamo) {
        this.jpanelPrestamo = jpanelPrestamo;
    }

    public JButton getBuscarButton() {
        return buscarButton;
    }

    public void setBuscarButton(JButton buscarButton) {
        this.buscarButton = buscarButton;
    }

    public JButton getCrearButton1() {
        return crearButton1;
    }

    public void setCrearButton1(JButton crearButton1) {
        this.crearButton1 = crearButton1;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public void setModificarButton(JButton modificarButton) {
        this.modificarButton = modificarButton;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }

    public JPanel getjPanelContaint() {
        return jPanelContaint;
    }

    public void setjPanelContaint(JPanel jPanelContaint) {
        this.jPanelContaint = jPanelContaint;
    }

    public VistaBuscar getVistaBuscar() {
        return vistaBuscar;
    }

    public void setVistaBuscar(VistaBuscar vistaBuscar) {
        this.vistaBuscar = vistaBuscar;
    }

    public JPanel getJpanelBuscar() {
        return jpanelBuscar;
    }

    public void setJpanelBuscar(JPanel jpanelBuscar) {
        this.jpanelBuscar = jpanelBuscar;
    }

    public VistaCrear getVistaCrear() {
        return vistaCrear;
    }

    public void setVistaCrear(VistaCrear vistaCrear) {
        this.vistaCrear = vistaCrear;
    }

    public JPanel getJpanelCrear() {
        return jpanelCrear;
    }

    public void setJpanelCrear(JPanel jpanelCrear) {
        this.jpanelCrear = jpanelCrear;
    }
}



