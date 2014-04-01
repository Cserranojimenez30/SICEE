/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Bean;

import Utilerias.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 *
 * @author aya
 */
public class PagoBean {

    // Atributos con esteroides
    private String folio;
    private String fecha;
    private int periodo;

    // Atributos compuestos (?)
    private AlumnoBean alumno;
    private AsignaturaBean materia;

    // Mas esteroides (Pero ocultos)
    private int costo;

    public PagoBean() {
        this.setFolio();
        this.setFecha();
        this.setPeriodo();
    }

    public String getFolio() {
        return folio;
    }

    private void setFolio() {
        try {
            Connection con = DataBase.ESCOLAR.getConnection();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM folio JOIN costo");
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                Calendar cal = new GregorianCalendar();

                String anio = rs.getString(1);
                int num = rs.getInt(2) + 1;
                String anio_actual = cal.get(Calendar.YEAR) + "";

                if (anio.compareTo(anio_actual) == 0) {
                    this.folio = String.format("%s-%03d", anio, num);
                    this.costo = rs.getInt(3);

                    ps = con.prepareStatement(
                            "UPDATE folio SET num = ?;");
                    ps.setInt(1, num);
                    ps.execute();
                } else {
                    System.out.println("Reiniciando folio...");

                    ps = con.prepareStatement(
                            "UPDATE folio SET anio = ?, num = 0;");
                    ps.setString(1, anio_actual);
                    ps.execute();

                    this.setFolio();
                }
            }

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("DAO/generarFolio(): " + ex);
        }
    }

    public String getFecha() {
        return fecha;
    }

    private void setFecha() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

        this.fecha = sdf.format(date);
    }

    public int getPeriodo() {
        return periodo;
    }

    private void setPeriodo() {
        int periodoN;

        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(new Date()));

        switch (mes) {
            case 1:
            case 2:
            case 3:
            case 4:
                periodoN = 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                periodoN = 2;
                break;
            default:
                periodoN = 3;
        }

        this.periodo = periodoN;
    }

    public int getCosto() {
        return costo;
    }

    public AlumnoBean getAlumno() {
        return alumno;
    }

    public void setAlumno(AlumnoBean alumno) {
        this.alumno = alumno;
    }

    public AsignaturaBean getMateria() {
        return materia;
    }

    public void setMateria(AsignaturaBean materia) {
        this.materia = materia;
    }

    @Override
    public String toString() {
        return String.format("Folio: %s\n"
                + "Fecha: %s\n"
                + "Periodo: %d\n"
                + alumno + "\n"
                + materia
                + "\nCosto: %d",
                folio, fecha, periodo, costo);
    }

    public static void main(String[] args) {
        PagoBean bean = new PagoBean();

        System.out.println(bean);
    }
}
