package vista;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class ModificarPrestamo {
    private JPanel panel1;
    private JTextField textFieldPrestamos;
    private JTextField textFieldUsuario;
    private JTextField textFieldEjemplar;
    private JTextField textField4;
    private JTextField textField5;
    private JButton modificarButton;
    private JPanel jpanelCalendar1;
    private JPanel jpanelCalendar2;
    private JDateChooser dateChooserInicio;
    private JDateChooser dateChooserFin;

    public ModificarPrestamo() {
        dateChooserInicio = new JDateChooser();
        dateChooserFin = new JDateChooser();
        dateChooserInicio.setDateFormatString("dd/MM/yyyy");
        dateChooserFin.setDateFormatString("dd/MM/yyyy");
        jpanelCalendar1.add(dateChooserInicio);
        jpanelCalendar2.add(dateChooserFin);
    }

    public JPanel getPanel1() {
        return panel1;
    }

    public void setPanel1(JPanel panel1) {
        this.panel1 = panel1;
    }

    public JTextField getTextFieldPrestamos() {
        return textFieldPrestamos;
    }

    public void setTextFieldPrestamos(JTextField textFieldPrestamos) {
        this.textFieldPrestamos = textFieldPrestamos;
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

    public JTextField getTextField4() {
        return textField4;
    }

    public void setTextField4(JTextField textField4) {
        this.textField4 = textField4;
    }

    public JTextField getTextField5() {
        return textField5;
    }

    public void setTextField5(JTextField textField5) {
        this.textField5 = textField5;
    }

    public JButton getModificarButton() {
        return modificarButton;
    }

    public void setModificarButton(JButton modificarButton) {
        this.modificarButton = modificarButton;
    }

    public JPanel getJpanelCalendar1() {
        return jpanelCalendar1;
    }

    public void setJpanelCalendar1(JPanel jpanelCalendar1) {
        this.jpanelCalendar1 = jpanelCalendar1;
    }

    public JPanel getJpanelCalendar2() {
        return jpanelCalendar2;
    }

    public void setJpanelCalendar2(JPanel jpanelCalendar2) {
        this.jpanelCalendar2 = jpanelCalendar2;
    }

    public JDateChooser getDateChooserInicio() {
        return dateChooserInicio;
    }

    public void setDateChooserInicio(JDateChooser dateChooserInicio) {
        this.dateChooserInicio = dateChooserInicio;
    }

    public JDateChooser getDateChooserFin() {
        return dateChooserFin;
    }

    public void setDateChooserFin(JDateChooser dateChooserFin) {
        this.dateChooserFin = dateChooserFin;
    }
}
