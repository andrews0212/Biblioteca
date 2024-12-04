package vista;

import javax.swing.*;

public class VistaEliminar {
    private JTextField textFieldPrestamo;
    private JButton eliminarButton;
    private JPanel panel1;

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTextFieldPrestamo() {
        return textFieldPrestamo;
    }

    public void setTextFieldPrestamo(JTextField textFieldPrestamo) {
        this.textFieldPrestamo = textFieldPrestamo;
    }

    public JButton getEliminarButton() {
        return eliminarButton;
    }

    public void setEliminarButton(JButton eliminarButton) {
        this.eliminarButton = eliminarButton;
    }
}
