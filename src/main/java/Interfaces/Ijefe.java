package Interfaces;

import Modelo.Empleado;
import Modelo.Jefe;
import java.util.ArrayList;

public interface Ijefe {
    
    public ArrayList<Jefe>ListarJefe();
    public int AgregarJefe(Jefe x);
    public int ActualizarJefe(Jefe x);
    public int EliminarJefe(int id);
    public int RetornarCodigoJefe();
    public ArrayList<Empleado>VerEmpleados(int id);
    
}
