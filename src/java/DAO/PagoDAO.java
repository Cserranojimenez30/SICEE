/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.PagoBean;
import Utilerias.DataBase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author aya
 */
public class PagoDAO {

    private final String registrar
            = "INSERT INTO pago VALUES(?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

    public boolean registrarPago(PagoBean bean) {
        boolean result = false;

        try {
            Connection con = DataBase.ESCOLAR.getConnection();
            PreparedStatement ps = con.prepareStatement(registrar);

            ps.setString(1, bean.getFolio());
            ps.setString(2, bean.getFecha());
            ps.setInt(3, bean.getPeriodo());

            ps.setString(4, bean.getAlumno().getAlumnoID());
            ps.setString(5, bean.getAlumno().getNombre());
            ps.setString(6, bean.getAlumno().getApellidoPaterno());
            ps.setString(7, bean.getAlumno().getApellidoMaterno());

            ps.setString(8, bean.getMateria().getMateriaID());
            ps.setString(9, bean.getMateria().getNombre());

            ps.setInt(10, bean.getCosto());

            result = ps.execute();

            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("DAO/registrarPago(): " + ex);
        }

        return result;
    }

    /**
     * Verifica si ya se ha realizado un pago
     *
     * @param matricula
     * @param materiaID
     * @return
     */
    public boolean validarPago(String matricula, String materiaID) {
        boolean status = false;

        try {
            Connection con = DataBase.ESCOLAR.getConnection();

            Calendar cal = new GregorianCalendar();
            int anio = cal.get(Calendar.YEAR);

            PreparedStatement ps = con.prepareStatement(
                    "SELECT folio FROM pago WHERE folio LIKE '" + anio + "%'"
                    + " AND periodo = ?"
                    + " AND matricula = ?"
                    + " AND materiaID = ?");

            ps.setInt(1, getPeriodo());
            ps.setString(2, matricula);
            ps.setString(3, materiaID);

            ResultSet rs = ps.executeQuery();

            status = rs.next();

            rs.close();
            ps.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("PagoDAO/validarPago: " + ex);
        }

        return status;
    }

    // Funcion auxiliar
    private int getPeriodo() {
        int periodo;

        SimpleDateFormat sdf = new SimpleDateFormat("MM");
        int mes = Integer.parseInt(sdf.format(new Date()));

        switch (mes) {
            case 1:
            case 2:
            case 3:
            case 4:
                periodo = 1;
                break;
            case 5:
            case 6:
            case 7:
            case 8:
                periodo = 2;
                break;
            default:
                periodo = 3;
        }

        return periodo;
    }

    public static void main(String[] args) {
        PagoDAO dao = new PagoDAO();

        System.out.println(dao.validarPago("20131TI004", "TICS1024"));
    }
}
