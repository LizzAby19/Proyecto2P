/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudInvD;
import Modelo.Articulo;
import Modelo.CabeceraInventario;
import Modelo.DetalleInv;
import Modelo.Movimiento;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liiz
 */
public class InventarioDDAO implements crudInvD {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    DetalleInv art = new DetalleInv();

    @Override
    public List listar() {

        ArrayList<DetalleInv> list = new ArrayList<>();
        String sql = "select b.id_invdet, b.id_inv, a.NOMBRE_ART, b.CANTIDAD_INVDET,a.PRECIO_ART * b.CANTIDAD_INVDET AS precio from ARTICULO a, INVENTARIO_DETALLE b where a.ID_ART=b.ID_ART";
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
    public DetalleInv list(int id) {
        String sql = "select * from INVENTARIO_DETALLE where id_invdet=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setId_detI(rs.getString("id_invdet"));
                art.setId_art(rs.getString("id_art"));
                art.setId_inv(rs.getString("id_inv"));
                art.setCantidad(rs.getString("cantidad_invdet"));
                //art.setPrecio(rs.getString("precio_invdet"));

            }
        } catch (Exception e) {
        }
        System.out.println(art);
        return art;
    }

    @Override
    public boolean add(DetalleInv art) {
        String sql = "INSERT INTO  INVENTARIO_DETALLE (id_art,id_inv, cantidad_invdet, precio_invdet)values('" + art.getId_art() + "','" + art.getId_inv() + "','" + art.getCantidad() + "','" + precio(art.getId_art()) + "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            System.out.println(sql + "dao");
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                String signo = signoTP(art.getId_inv());
                System.out.println("SSSIIIGGNNOOO   " + signo + "dd  " + art.getId_inv());
                String datos = "update ARTICULO set STOCK_art = STOCK_art" + signo + art.getCantidad() + " where id_art =" + art.getId_art();
                System.out.println(datos);
                PreparedStatement statement1 = con.prepareStatement(datos);
                statement1.executeUpdate();
                System.out.println("Insertado correctamente !");
            }
        } catch (Exception e) {
            System.out.println(e + sql + "dao");
        }
        return false;
    }

    public String precio(String art1) {
        String sql = "select a.PRECIO_ART * b.CANTIDAD_INVDET AS precio from ARTICULO a, INVENTARIO_DETALLE b where a.ID_ART=" + art1;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql + "precioDao");
            while (rs.next()) {

                art.setPrecio(rs.getString(1));

            }
        } catch (Exception e) {

        }
        return art1;
    }

    public String signoTP(String art1) {
        Movimiento mov = new Movimiento();
        String signo = "";
        String sql = "SELECT a.signo_tmov FROM TIPO_MOVIMIENTO a, INVENTARIO b WHERE a.id_tmov=b.id_tmov AND b.ID_INV=" + art1;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //ps.executeUpdate();
            ResultSet result = ps.executeQuery();
            System.out.println(sql + "SIGNODao");
            while (result.next()) {
                signo = result.getString(1);
                //mov.setSigno(rs.getString(1));
            }
        } catch (Exception e) {

        }
        return signo;
    }

    @Override
    public boolean edit(DetalleInv art) {
        String sql = "update INVENTARIO_DETALLE set id_art='" + art.getId_art() + "',cantidad_invdet='" + art.getCantidad() + "'where id_invdet=" + art.getId_detI();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //ps.executeUpdate();
            System.out.println(sql);
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                String signo = signoTP(art.getId_inv());
                System.out.println("SSSIIIGGNNOOO   " + signo + "dd  " + art.getId_inv());
                String datos = "update ARTICULO set STOCK_art = STOCK_art" + signo + art.getCantidad() + " where id_art =" + art.getId_art();
                System.out.println(datos);
                PreparedStatement statement1 = con.prepareStatement(datos);
                statement1.executeUpdate();
                System.out.println("Insertado correctamente !");
            }
        } catch (Exception e) {
            System.out.println(e + "editDAO");
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from INVENTARIO_DETALLE where id_invdet=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            //ps.executeUpdate();
            System.out.println(sql);
            int rowsInserted = ps.executeUpdate();
            DetalleInv art1 = list(id);
            System.out.println(art1);
            if (rowsInserted > 0) {
                String signo = signoTP(art1.getId_inv());
                System.out.println("SSSIIIGGNNOOO   " + signo + "dd  " + art1.getId_inv());
                if (signo.equals("+")) {
                    String datos = "update ARTICULO set STOCK_art = STOCK_art" + "-" + art1.getCantidad() + " where id_art =" + art1.getId_art();
                    System.out.println(datos);
                    PreparedStatement statement1 = con.prepareStatement(datos);
                    statement1.executeUpdate();
                    System.out.println("Insertado correctamente !");
                } else {
                    String datos = "update ARTICULO set STOCK_art = STOCK_art" + "+" + art1.getCantidad() + " where id_art =" + art1.getId_art();
                    System.out.println(datos);
                    PreparedStatement statement1 = con.prepareStatement(datos);
                    statement1.executeUpdate();
                    System.out.println("Insertado correctamente !");
                }
            }
        } catch (Exception e) {
            System.out.println(e + "delDAO");
        }
        return false;
    }

}
