package empresacashescritorio.capa4_persistencia;

import empresacashescritorio.capa1_presentacion.util.Mensaje;
import java.sql.DriverManager;

import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author FiveCod Software
 */
public class GestorJDBCMySQL extends GestorJDBC {

    @Override
    public void abrirConexion() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conexion = DriverManager.getConnection("jdbc:mysql://localhost/dbempresacashescritorio", "levi", "levi");
        } catch (Exception e) {
        
            Mensaje.mostrarErrorJDBC(e.getMessage());
        }
    }

}
