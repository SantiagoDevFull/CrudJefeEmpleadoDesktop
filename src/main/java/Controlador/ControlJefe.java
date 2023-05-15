package Controlador;

import Config.MySQLConexion;
import Interfaces.Ijefe;
import Modelo.Empleado;
import Modelo.Jefe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlJefe implements Ijefe {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Jefe> ListarJefe() {

        ArrayList<Jefe> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT *,"
                + "(SELECT count(*) FROM empleado e WHERE e.idJefe=j.idJefe) as num_empleados "
                + "FROM jefe j order by j.idJefe;";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Jefe x = new Jefe();
                x.setIdJefe(rs.getInt(1));
                x.setNomJefe(rs.getString(2));
                x.setNumEmpleados(rs.getInt(3));
                lista.add(x);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

    @Override
    public int AgregarJefe(Jefe x) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO jefe(nomJefe) VALUES (?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, x.getNomJefe());
            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int ActualizarJefe(Jefe x) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE jefe SET nomJefe=? WHERE idJefe=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, x.getNomJefe());
            st.setInt(2, x.getIdJefe());
            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int EliminarJefe(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM jefe WHERE idJefe=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, id);
            res = st.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public int RetornarCodigoJefe() {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'bdjefe'\n"
                + "AND   TABLE_NAME   = 'jefe';";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            res = rs.next() ? rs.getInt(1) : 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return res;
    }

    @Override
    public ArrayList<Empleado> VerEmpleados(int id) {

        ArrayList<Empleado> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT e.idEmp,e.nomEmp,e.fnEmp FROM empleado e\n"
                + "INNER JOIN jefe j ON (e.idJefe=j.idJefe)\n"
                + "WHERE e.idJefe=?\n"
                + "order by 1";
        try {
            st = cn.prepareStatement(consulta);
            st.setInt(1, id);
            rs = st.executeQuery();

            while (rs.next()) {
                Empleado p = new Empleado();
                p.setIdEmp(rs.getInt(1));
                p.setNomEmp(rs.getString(2));
                p.setFnEmp(rs.getDate(3));
                lista.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        } finally {
            try {
                cn.close();
                st.close();
                rs.close();
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
        return lista;
    }

}
