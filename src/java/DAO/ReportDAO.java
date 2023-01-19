/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.report;
import Modelo.DetalleInv;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liiz
 */
public class ReportDAO implements report {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DetalleInv art = new DetalleInv();

    @Override
    public List listar() {
        ArrayList<DetalleInv> list = new ArrayList<>();
        String sql = "SELECT a.NOMBRE_ART , b.CANTIDAD_INVDET FROM ARTICULO a, INVENTARIO_DETALLE b, INVENTARIO c WHERE a.id_art =  b.id_art AND c.ID_INV = b.ID_INV AND c.FECHA_INV = ;";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                DetalleInv per = new DetalleInv();
                per.setId_detI(rs.getString(1));
                per.setId_inv(rs.getString(2));
                per.setId_art(rs.getString(3));
                per.setCantidad(rs.getString(4));
                per.setPrecio(rs.getString(5));
                //System.out.println(rs.getString(3) + "22");
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e + "error");
        }
        return list;
    }

    @Override
    public DetalleInv list(String id) {
        String sql = "select * from INVENTARIO_DETALLE where id_invdet=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setId_art(rs.getString("id_art"));
                art.setCantidad(rs.getString("cantidad_invdet"));
                //art.setPrecio(rs.getString("precio_invdet"));

            }
        } catch (Exception e) {
        }
        System.out.println(art);
        return art;
    }

    @Override
    public List buscar(String texto) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }




}
