package vista;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuUsuarioAdmin extends JDialog {
    private JPanel contentPane;
    private JButton buscarButton;
    private JButton crearButton1;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JPanel jPanelContaint;
    private VistaCrear vistaCrear;
    private VistaBuscar vistaBuscar;
    private JPanel jpanelBuscar;
    private JPanel jpanelCrear;


    public MenuUsuarioAdmin() {
        setContentPane(contentPane);
        setModal(true);
        vistaCrear = new VistaCrear();
        vistaBuscar = new VistaBuscar();


        jpanelBuscar = vistaBuscar.getPanelBusqueda();
        jpanelCrear = vistaCrear.getPanelCrear();

        jPanelContaint.add(jpanelCrear);
        jPanelContaint.add(jpanelBuscar);



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



    public VistaCrear getVistaCrear() {
        return vistaCrear;
    }

    public void setVistaCrear(VistaCrear vistaCrear) {
        this.vistaCrear = vistaCrear;
    }



    public static void main(String[] args) {
        MenuUsuarioAdmin dialog = new MenuUsuarioAdmin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        // TODO: place custom component creation code here
    }
}
