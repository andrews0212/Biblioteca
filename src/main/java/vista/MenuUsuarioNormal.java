package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class MenuUsuarioNormal extends JDialog {
    private JPanel contentPane;
    private JScrollPane jScrollPane;
    private JTable table1;
    private JPanel jPanelContain;
    private JButton verPrestamosButton;
    private JButton entregarEjemplarButton;


    public MenuUsuarioNormal() {
        setContentPane(contentPane);
        setModal(true);
        table1.setModel(creacionTabla());

    }

    public JButton getVerPrestamosButton() {
        return verPrestamosButton;
    }

    public void setVerPrestamosButton(JButton verPrestamosButton) {
        this.verPrestamosButton = verPrestamosButton;
    }

    public DefaultTableModel creacionTabla(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Ejemplar");
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha Fin");
        return model;
    }

    public JButton getEntregarEjemplarButton() {
        return entregarEjemplarButton;
    }

    public void setEntregarEjemplarButton(JButton entregarEjemplarButton) {
        this.entregarEjemplarButton = entregarEjemplarButton;
    }

    public JScrollPane getjScrollPane() {
        return jScrollPane;
    }

    public void setjScrollPane(JScrollPane jScrollPane) {
        this.jScrollPane = jScrollPane;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }


}
