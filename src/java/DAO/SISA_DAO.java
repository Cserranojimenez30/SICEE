/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Bean.AlumnoBean;
import Bean.AsignaturaBean;
import Utilerias.DataBase;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author aya
 */
public class SISA_DAO {

    /**
     *
     * @param matricula
     * @return Una lista con todas las materias reprobadas
     */
    public List<AsignaturaBean> obtenerAsignaturasReprobadas(String matricula) {
        List<AsignaturaBean> ls = new ArrayList<>();

        try {
            Connection con = DataBase.SISA.getConnection();
            CallableStatement call = con.prepareCall("{CALL obtenerasignaturasreprobadas(?)}");

            call.setString(1, matricula);

            ResultSet rs = call.executeQuery();

            while (rs.next()) {
                AsignaturaBean bean = new AsignaturaBean();

                bean.setMateriaID(rs.getString(1));
                bean.setNombre(rs.getString(2));

                ls.add(bean);
            }

            rs.close();
            call.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("DAO/obtenerAsignaturasReprobadas(): " + ex);
        }

        return ls;
    }

    /**
     *
     * @param matricula
     * @return Un bean con los datos del alumno
     */
    public AlumnoBean obtenerDatosAlumno(String matricula) {
        AlumnoBean bean = null;

        try {
            Connection con = DataBase.SISA.getConnection();
            CallableStatement call = con.prepareCall("{CALL obtenerdatosalumno(?)}");

            call.setString(1, matricula);

            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                bean = new AlumnoBean();

                bean.setAlumnoID(rs.getString(1));
                bean.setNombre(rs.getString(2));
                bean.setApellidoPaterno(rs.getString(3));
                bean.setApellidoMaterno(rs.getString(4));
                bean.setCorreo(rs.getString(5));
                bean.setEstado(rs.getString(6));
            }

            rs.close();
            call.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("DAO/obtenerdatosalumno(): " + ex);
        }

        return bean;
    }

    /**
     *
     * @param MateriaID
     * @return Un bean con los datos de la materia dada
     */
    public AsignaturaBean obtenerDatosMateria(String MateriaID) {
        AsignaturaBean bean = null;

        try {
            Connection con = DataBase.SISA.getConnection();
            CallableStatement call = con.prepareCall("{CALL ObtenerDatosMateria(?)}");

            call.setString(1, MateriaID);

            ResultSet rs = call.executeQuery();

            if (rs.next()) {
                bean = new AsignaturaBean();

                bean.setMateriaID(rs.getString(1));
                bean.setNombre(rs.getString(2));
                bean.setDescripcion(rs.getString(3));
                bean.setCreditos(rs.getString(4));
            }

            rs.close();
            call.close();
            con.close();
        } catch (SQLException ex) {
            System.out.println("DAO/obtenerDatosMateria(): " + ex);
        }

        return bean;
    }

    public static void main(String[] args) {
        SISA_DAO obj = new SISA_DAO();

        System.out.println(obj.obtenerAsignaturasReprobadas("20131TI011"));
        System.out.println(obj.obtenerDatosAlumno("20131TI011"));
        System.out.println(obj.obtenerDatosMateria("TICS1024"));
    }
}
