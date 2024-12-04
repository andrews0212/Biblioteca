import controlador.Controlador;
import controlador.ControladorUsuarioAdmin;
import modelo.DTO.Usuario;
import modelo.Gestion.GestionEjemplar;
import modelo.Gestion.GestionLibro;
import modelo.Gestion.GestionPrestamo;
import modelo.Gestion.GestionUsuario;
import vista.Login;
import vista.MenuUsuarioAdmin;

public class Main {

    //1633

    public static void main(String[] args) {
//        GestionUsuario gestion = new GestionUsuario();
//        Login login = new Login();
//        Controlador controlador = new Controlador(gestion, login);
//        controlador.getLogin().setVisible(true);
        ControladorUsuarioAdmin controladorUsuarioAdmin = new ControladorUsuarioAdmin(new GestionUsuario(), new GestionPrestamo(), new GestionEjemplar(), new GestionLibro(), new Usuario(), new MenuUsuarioAdmin());
        controladorUsuarioAdmin.getMenuUsuarioAdmin().setVisible(true);
    }
}
