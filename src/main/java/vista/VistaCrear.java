package vista;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class VistaCrear {
    private JPanel panel1;
    private JTextField textFieldUsuario;
    private JTextField textFieldEjemplar;
    private JButton crearButton;
    private JPanel JpanelCalendar;
    private JDateChooser dateChooser;


    public VistaCrear() {
        dateChooser = new JDateChooser();
        JpanelCalendar.add(dateChooser);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTextFieldUsuario() {
        return textFieldUsuario;
    }

    public void setTextFieldUsuario(JTextField textFieldUsuario) {
        this.textFieldUsuario = textFieldUsuario;
    }

    public JTextField getTextFieldEjemplar() {
        return textFieldEjemplar;
    }

    public void setTextFieldEjemplar(JTextField textFieldEjemplar) {
        this.textFieldEjemplar = textFieldEjemplar;
    }

    public JButton getCrearButton() {
        return crearButton;
    }

    public void setCrearButton(JButton crearButton) {
        this.crearButton = crearButton;
    }

    public JPanel getJpanelCalendar() {
        return JpanelCalendar;
    }

    public void setJpanelCalendar(JPanel jpanelCalendar) {
        JpanelCalendar = jpanelCalendar;
    }

    public JDateChooser getDateChooser() {
        return dateChooser;
    }

    public void setDateChooser(JDateChooser dateChooser) {
        this.dateChooser = dateChooser;
    }
}
