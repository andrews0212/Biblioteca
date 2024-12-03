package controlador;

import modelo.DTO.Usuario;
import modelo.Gestion.GestionEjemplar;
import modelo.Gestion.GestionLibro;
import modelo.Gestion.GestionPrestamo;
import modelo.Gestion.GestionUsuario;
import vista.Login;
import vista.MenuUsuarioAdmin;
import vista.MenuUsuarioNormal;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controlador implements ActionListener {

    GestionUsuario gestion;
    Login login;

    public Controlador(GestionUsuario gestion, Login login) {
        this.gestion = gestion;
        this.login = login;
        this.login.pack();
        this.login.setLocationRelativeTo(null);
        this.login.getLoginButton().addActionListener(this);
    }

    public GestionUsuario getGestion() {
        return gestion;
    }

    public void setGestion(GestionUsuario gestion) {
        this.gestion = gestion;
    }

    public Login getLogin() {
        return login;
    }

    public void setLogin(Login login) {
        this.login = login;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == this.login.getLoginButton()) {
            String correo = this.getLogin().getTextField1().getText();
            String contraseña = this.getLogin().getPasswordField1().getText();
            Usuario usuario = gestion.getMemoriaUsuario().findAll().stream().filter(p -> p.getEmail().equals(correo) && p.getPassword().equals(contraseña)).findFirst().get();
            if (usuario != null) {
                if (usuario.getTipo().equals("normal")) {
                    this.login.dispose();
                    ControlUsuarioNormal controlUsuarioNormal = new ControlUsuarioNormal(new GestionUsuario(),new GestionPrestamo(),new MenuUsuarioNormal(), usuario);
                    controlUsuarioNormal.getMenuUsuarioNormal().setVisible(true);

                }else if (usuario.getTipo().equals("administrador")) {
                    this.login.dispose();
                    ControladorUsuarioAdmin controladorUsuarioAdmin = new ControladorUsuarioAdmin(new GestionUsuario()  ,new GestionPrestamo(), new GestionEjemplar(),new GestionLibro(), usuario, new MenuUsuarioAdmin());
                    controladorUsuarioAdmin.getMenuUsuarioAdmin().setVisible(true);
                }
            }
        }
    }
}
