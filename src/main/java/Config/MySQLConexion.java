package Config;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MySQLConexion {

    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost/bdjefe";
            String user = "root";
            String pass = "";
            cn = DriverManager.getConnection(url, user, pass);
            System.out.println("Conexion ok");
        } catch (ClassNotFoundException ex) {
            System.out.println("No hay driver");
        } catch (SQLException ex) {
            System.out.println("Error con la bd");
        }
        return cn;
    }

}
