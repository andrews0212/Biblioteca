package vista;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class VistaBuscar {
    private JPanel panelBusqueda;
    private JTextField textField1;
    private JButton buscarButton1;
    private JButton limpiarButton;
    private JTable table1;
    private JButton buscarTodoButton;

    public VistaBuscar() {
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Id Prestamo");
        model.addColumn("Id Usuario");
        model.addColumn("Id Ejemplar");
        model.addColumn("Fecha Inicio");
        model.addColumn("Fecha Fin");
        table1.setModel(model);
    }

    public JPanel getPanelBusqueda() {
        return panelBusqueda;
    }

    public void setPanelBusqueda(JPanel panelBusqueda) {
        this.panelBusqueda = panelBusqueda;
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JButton getBuscarButton1() {
        return buscarButton1;
    }

    public void setBuscarButton1(JButton buscarButton1) {
        this.buscarButton1 = buscarButton1;
    }

    public JButton getLimpiarButton() {
        return limpiarButton;
    }

    public void setLimpiarButton(JButton limpiarButton) {
        this.limpiarButton = limpiarButton;
    }

    public JTable getTable1() {
        return table1;
    }

    public void setTable1(JTable table1) {
        this.table1 = table1;
    }

    public JButton getBuscarTodoButton() {
        return buscarTodoButton;
    }

    public void setBuscarTodoButton(JButton buscarTodoButton) {
        this.buscarTodoButton = buscarTodoButton;
    }
}
