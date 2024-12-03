package vista;

import javax.swing.*;

public class MenuUsuarioAdmin extends JDialog {
    private JPanel contentPane;
    private JButton buscarButton;
    private JButton crearButton1;
    private JButton modificarButton;
    private JButton eliminarButton;
    private JPanel jPanelContaint;
    private VistaCrear vistaCrear;
    private VistaBuscar vistaBuscar;
    private JPanel pbusquedad;
    private JPanel panelCrear;


    public MenuUsuarioAdmin() {
        setContentPane(contentPane);
        setModal(true);
        vistaCrear = new VistaCrear();
        vistaBuscar = new VistaBuscar();
        pbusquedad = vistaBuscar.getPanelBusqueda();
        panelCrear = vistaCrear.getPanelCrear();

        jPanelContaint.add(pbusquedad);

    }

    public JPanel getPbusquedad() {
        return pbusquedad;
    }

    public void setPbusquedad(JPanel pbusquedad) {
        this.pbusquedad = pbusquedad;
    }

    public JPanel getjPanelContaint() {
        return jPanelContaint;
    }

    public void setjPanelContaint(JPanel jPanelContaint) {
        this.jPanelContaint = jPanelContaint;
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

    public JPanel getPanelCrear() {
        return panelCrear;
    }

    public void setPanelCrear(JPanel panelCrear) {
        this.panelCrear = panelCrear;
    }

    public static void main(String[] args) {
        MenuUsuarioAdmin dialog = new MenuUsuarioAdmin();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
