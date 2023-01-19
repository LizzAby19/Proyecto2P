/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Modelo.Ciudad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.crudCiu;

/**
 *
 * @author Liiz
 */
public class CiudadDAO implements crudCiu {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Ciudad ciu = new Ciudad();

    @Override
    public List listar() {
        ArrayList<Ciudad> list = new ArrayList<>();
        String sql = "select*from CIUDAD";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Ciudad per = new Ciudad();
                per.setId_ciu(rs.getString("id_ciu"));
                per.setCodigo_ciu(rs.getString("codigo_ciu"));
                per.setNombre_ciu(rs.getString("nombre_ciu"));
                System.out.println(per);
                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Ciudad list(int id) {
        String sql = "select * from CIUDAD where id_ciu=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                ciu.setId_ciu(rs.getString("id_ciu"));
                ciu.setCodigo_ciu(rs.getString("codigo_ciu"));
                ciu.setNombre_ciu(rs.getString("nombre_ciu"));
                

            }
        } catch (Exception e) {
        }
        return ciu;
    }

    @Override
    public boolean add(Ciudad ciu) {
        String sql = "insert into CIUDAD(codigo_ciu, nombre_ciu)values('" + ciu.getCodigo_ciu() + "','" + ciu.getNombre_ciu() + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql + "dao");
        } catch (Exception e) {
            System.out.println(e + sql + "dao");
        }
        return false;
    }

    @Override
    public boolean edit(Ciudad ciu) {
        String sql = "update CIUDAD set codigo_ciu='" +ciu.getCodigo_ciu() + "',nombre_ciu='" + ciu.getNombre_ciu() + "'where id_ciu=" + ciu.getId_ciu();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
            System.out.println(e + "editDAO");
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from CIUDAD where id_ciu=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
        } catch (Exception e) {
            System.out.println(e + "delDAO");
        }
        return false;
    }
}
