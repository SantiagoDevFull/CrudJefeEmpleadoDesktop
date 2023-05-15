package Modelo;

import java.sql.Date;

public class Empleado {

    private int idEmp;
    private String nomEmp;
    private Date fnEmp;
    private Jefe jefe;

    public Empleado() {
    }

    public Empleado(int idEmp, String nomEmp, Date fnEmp, Jefe jefe) {
        this.idEmp = idEmp;
        this.nomEmp = nomEmp;
        this.fnEmp = fnEmp;
        this.jefe = jefe;
    }

    public Jefe getJefe() {
        return jefe;
    }

    public void setJefe(Jefe jefe) {
        this.jefe = jefe;
    }

    public int getIdEmp() {
        return idEmp;
    }

    public void setIdEmp(int idEmp) {
        this.idEmp = idEmp;
    }

    public String getNomEmp() {
        return nomEmp;
    }

    public void setNomEmp(String nomEmp) {
        this.nomEmp = nomEmp;
    }

    public Date getFnEmp() {
        return fnEmp;
    }

    public void setFnEmp(Date fnEmp) {
        this.fnEmp = fnEmp;
    }

}
