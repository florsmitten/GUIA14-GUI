import Controlador.Conexion;
import Controlador.ControladorFrameSesion;
import Vista.FrameSesion;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) {

        try {
            Conexion.getConnection();
        } catch (SQLException var4) {
            var4.printStackTrace();
        }

        ControladorFrameSesion controladorFrameSesion = new ControladorFrameSesion();
        new FrameSesion(controladorFrameSesion);
    }
}
