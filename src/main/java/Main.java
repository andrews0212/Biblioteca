import controlador.Controlador;
import modelo.Gestion.GestionUsuario;
import vista.Login;

public class Main {

    public static void main(String[] args) {
        GestionUsuario gestion = new GestionUsuario();
        Login login = new Login();
        Controlador controlador = new Controlador(gestion, login);
        controlador.getLogin().setVisible(true);
    }
}
