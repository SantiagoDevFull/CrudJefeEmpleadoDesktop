package Controlador;

import Config.MySQLConexion;
import Interfaces.Iempleado;
import Modelo.Empleado;
import Modelo.Jefe;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControlEmpleado implements Iempleado {

    private Connection cn = null;
    private PreparedStatement st = null;
    private ResultSet rs = null;

    @Override
    public ArrayList<Empleado> ListarEmpleado() {

        ArrayList<Empleado> lista = new ArrayList();

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT e.idEmp,e.nomEmp,e.fnEmp,e.idJefe,j.nomJefe FROM empleado e\n"
                + "INNER JOIN jefe j ON (e.idJefe=j.idJefe)";
        try {
            st = cn.prepareStatement(consulta);
            rs = st.executeQuery();

            while (rs.next()) {
                Empleado e = new Empleado();
                e.setIdEmp(rs.getInt(1));
                e.setNomEmp(rs.getString(2));
                e.setFnEmp(rs.getDate(3));

                Jefe j = new Jefe();
                j.setIdJefe(rs.getInt(4));
                j.setNomJefe(rs.getString(5));

                e.setJefe(j);

                lista.add(e);
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
    public int AgregarEmpleado(Empleado x) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "INSERT INTO empleado(nomEmp,fnEmp,idJefe) VALUES (?,?,?)";
        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, x.getNomEmp());
            st.setDate(2, x.getFnEmp());
            st.setInt(3, x.getJefe().getIdJefe());
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
    public int ActualizarEmpleado(Empleado x) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "UPDATE empleado SET nomEmp=?,fnEmp=?,idJefe=? WHERE idEmp=?";
        try {
            st = cn.prepareStatement(consulta);
            st.setString(1, x.getNomEmp());
            st.setDate(2, x.getFnEmp());
            st.setInt(3, x.getJefe().getIdJefe());
            st.setInt(4, x.getIdEmp());
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
    public int EliminarEmpleado(int id) {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "DELETE FROM empleado WHERE idEmp=?";
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
    public int RetornarCodigoEmpleado() {

        int res = 0;

        cn = MySQLConexion.getConexion();
        String consulta = "SELECT AUTO_INCREMENT\n"
                + "FROM  INFORMATION_SCHEMA.TABLES\n"
                + "WHERE TABLE_SCHEMA = 'bdjefe'\n"
                + "AND   TABLE_NAME   = 'empleado';";
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

}
