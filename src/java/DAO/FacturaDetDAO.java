/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudDetf;
import Modelo.Factura_detalle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class FacturaDetDAO implements crudDetf{

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Factura_detalle cli = new Factura_detalle();

    //@Override
    public List listar() {
        ArrayList<Factura_detalle> list = new ArrayList<>();
        String sql = "select a.nombre_art, b.CANTIDAD_FACDET, b.PRECIO_FACDET from ARTICULO a, FACTURA_DETALLE b WHERE b.ID_art = a.id_art";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura_detalle per = new Factura_detalle();
                //per.setId_fac(rs.getString("id_facdet"));
                //per.setId_art(rs.getString("id_art"));
                //per.setCantidad_facdet(rs.getString("cantidad_facdet"));
                //per.setPrecio_facdet(rs.getString("precio_facdet"));
                
                per.setId_art(rs.getString(1));
                per.setCantidad_facdet(rs.getString(2));
                per.setPrecio_facdet(rs.getString(3));
                
                System.out.println(per);
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e + "ex");
        }
        return list;
    }

    //@Override
    public Factura_detalle list(int id) {
        String sql = "select * from FACTURA_DETALLE where id_facdet=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId_facdet(rs.getString("id_cli"));
                cli.setId_art(rs.getString("id_art"));
                cli.setCantidad_facdet(rs.getString("cantidad_facdet"));
                cli.setPrecio_facdet(rs.getString("precio_facdet"));

            }
        } catch (Exception e) {
        }
        return cli;
    }

    //@Override
    public boolean add(Factura_detalle cli) {
        String sql = "insert into FACTURA_DETALLE(id_art, cantidad_facdet, precio_facdet)values('" + cli.getId_art()+ "','" + cli.getCantidad_facdet() + "','" + cli.getPrecio_facdet()+ "')";
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

    //@Override
    public boolean edit(Factura_detalle cli) {
        String sql = "update FACTURA_DETALLE set id_art='" + cli.getId_art()+ "',cantidad_facdet='" + cli.getCantidad_facdet()+ "',precio_facdet='" + cli.getPrecio_facdet()+ "'where id_facdet=" + cli.getId_facdet();
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

    //@Override
    public boolean eliminar(int id) {
        String sql = "delete from FACTURA_DETALLE where id_facdet=" + id;
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
