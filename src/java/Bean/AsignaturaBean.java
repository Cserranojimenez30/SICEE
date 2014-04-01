/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

/**
 *
 * @author aya
 */
public class AsignaturaBean {

    private String materiaID;
    private String nombre;
    private String descripcion;
    private String creditos;

    public String getMateriaID() {
        return materiaID;
    }

    public void setMateriaID(String materiaID) {
        this.materiaID = materiaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getCreditos() {
        return creditos;
    }

    public void setCreditos(String creditos) {
        this.creditos = creditos;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s",
                materiaID, nombre, descripcion, creditos);
    }
}
