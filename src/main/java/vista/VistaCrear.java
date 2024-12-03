package vista;

import com.toedter.calendar.JDateChooser;

import javax.swing.*;

public class VistaCrear {
    private JTextField textField1;
    private JTextField textField2;
    private JPanel panelCalendar;
    private JPanel PanelCrear;

    public VistaCrear() {
    panelCalendar.add(new JDateChooser());
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public void setTextField1(JTextField textField1) {
        this.textField1 = textField1;
    }

    public JTextField getTextField2() {
        return textField2;
    }

    public void setTextField2(JTextField textField2) {
        this.textField2 = textField2;
    }

    public JPanel getPanelCalendar() {
        return panelCalendar;
    }

    public void setPanelCalendar(JPanel panelCalendar) {
        this.panelCalendar = panelCalendar;
    }

    public JPanel getPanelCrear() {
        return PanelCrear;
    }

    public void setPanelCrear(JPanel panelCrear) {
        PanelCrear = panelCrear;
    }
}
