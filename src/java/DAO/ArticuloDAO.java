/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudArt;
import Modelo.Articulo;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liiz
 */
public class ArticuloDAO implements crudArt {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Articulo art = new Articulo();

    @Override
    public List listar() {
        ArrayList<Articulo> list = new ArrayList<>();
        String sql = "select*from proyecto.articulo";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Articulo per = new Articulo();
                per.setCodigo_Articulo(rs.getString("id_art"));
                per.setNombre_Articulo(rs.getString("nombre_art"));
                per.setPrecio_Articulo(rs.getString("precio_art"));
                per.setStock_Articulo(rs.getString("stock_art"));

                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Articulo list(int id) {
        String sql = "select * from proyecto.articulo where id_art=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setCodigo_Articulo(rs.getString("id_art"));
                art.setNombre_Articulo(rs.getString("nombre_art"));
                art.setPrecio_Articulo(rs.getString("precio_art"));
                art.setStock_Articulo(rs.getString("stock_art"));

            }
        } catch (Exception e) {
        }
        return art;
    }

    @Override
    public boolean add(Articulo art) {
        String sql = "insert into proyecto.articulo(nombre_art, precio_art, stock_art)values('" + art.getNombre_Articulo() + "','" + art.getPrecio_Articulo() + "','" + art.getStock_Articulo() + "')";
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

    @Override
    public boolean edit(Articulo art) {
        String sql = "update proyecto.articulo set nombre_art='" + art.getNombre_Articulo() + "',precio_art='" + art.getPrecio_Articulo() + "',stock_art='" + art.getStock_Articulo() + "'where id_art=" + art.getCodigo_Articulo();
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
        String sql = "delete from proyecto.articulo where id_art=" + id;
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
