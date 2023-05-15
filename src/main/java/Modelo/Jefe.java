package Modelo;

public class Jefe {

    private int idJefe;
    private String nomJefe;
    private int numEmpleados;

    public Jefe() {
    }

    public Jefe(int idJefe, String nomJefe) {
        this.idJefe = idJefe;
        this.nomJefe = nomJefe;
    }

    public String getNomJefe() {
        return nomJefe;
    }

    public void setNomJefe(String nomJefe) {
        this.nomJefe = nomJefe;
    }

    public int getIdJefe() {
        return idJefe;
    }

    public void setIdJefe(int idJefe) {
        this.idJefe = idJefe;
    }

    public int getNumEmpleados() {
        return numEmpleados;
    }

    public void setNumEmpleados(int numEmpleados) {
        this.numEmpleados = numEmpleados;
    }

}
