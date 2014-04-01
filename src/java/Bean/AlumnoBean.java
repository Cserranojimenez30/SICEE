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
public class AlumnoBean {

    private String alumnoID;
    private String nombre;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String correo;
    private String estado;

    public String getAlumnoID() {
        return alumnoID;
    }

    public void setAlumnoID(String alumnoID) {
        this.alumnoID = alumnoID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoPaterno() {
        return apellidoPaterno;
    }

    public void setApellidoPaterno(String apellidoPaterno) {
        this.apellidoPaterno = apellidoPaterno;
    }

    public String getApellidoMaterno() {
        return apellidoMaterno;
    }

    public void setApellidoMaterno(String apellidoMaterno) {
        this.apellidoMaterno = apellidoMaterno;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s, %s, %s",
                alumnoID, nombre, apellidoPaterno, apellidoMaterno, correo, estado);
    }
}
