/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudFac;
import Modelo.Factura;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alexander
 */
public class FacturaDAO implements crudFac{
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Factura fac = new Factura();

    //@Override
    public List listar() {
        ArrayList<Factura> list = new ArrayList<>();
        String sql = "select a.numero_fac, a.fecha_fac, b.nombre_ciu from FACTURA a, CIUDAD b WHERE b.ID_ciu = a.id_ciu";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Factura per = new Factura();
                //per.setId_fac(rs.getString("id_fac"));
                //per.setNumero_fac(rs.getString("numero_fac"));
               // per.setFecha_fac(rs.getString("fecha_fac"));
                //per.setId_ciu(rs.getString("id_ciu"));
                
                //per.setId_fac(rs.getString(1));
                per.setNumero_fac(rs.getString(1));
                per.setFecha_fac(rs.getString(2));
                per.setId_ciu(rs.getString(3));
                
                System.out.println(per);
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e+"ex");
        }
        return list;
    }

    //@Override
    public Factura list(int id) {
        String sql = "select * from FACTURA where id_fac=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                fac.setId_fac(rs.getString("id_fac"));
                fac.setNumero_fac(rs.getString("numero_fac"));
                fac.setFecha_fac(rs.getString("fecha_fac"));
                fac.setId_ciu(rs.getString("id_ciu"));

            }
        } catch (Exception e) {
        }
        return fac;
    }

    //@Override
    public boolean add(Factura fac) {
        String sql = "insert into FACTURA (numero_fac, fecha_fac, id_ciu)values('" + fac.getNumero_fac()+ "','" + fac.getFecha_fac()+ "','" + fac.getId_ciu()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql + "dao");
        } catch (Exception e) {
            System.out.println(e +sql +"dao");
        }
        return false;
    }

    //@Override
    public boolean edit(Factura cli) {
        String sql = "update FACTURA set numero_fac='" + cli.getNumero_fac()+ "',fecha_fac='" + cli.getFecha_fac()+ "',id_ciu='" + cli.getId_ciu()+ "'where id_fac=" + cli.getId_fac();
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
        String sql = "delete from FACTURA where id_fac=" + id;
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
