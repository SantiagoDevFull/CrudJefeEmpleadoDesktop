package Interfaces;

import Modelo.Empleado;
import java.util.ArrayList;

public interface Iempleado {
    
    public ArrayList<Empleado>ListarEmpleado();
    public int AgregarEmpleado(Empleado x);
    public int ActualizarEmpleado(Empleado x);
    public int EliminarEmpleado(int id);
    public int RetornarCodigoEmpleado();
    
}
