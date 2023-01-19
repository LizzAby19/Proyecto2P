/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudInvC;
import Modelo.CabeceraInventario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Liiz
 */
public class InventarioCDAO implements crudInvC {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    CabeceraInventario art = new CabeceraInventario();

    @Override
    public List listar() {
        ArrayList<CabeceraInventario> list = new ArrayList<>();
        String sql = "select a.id_inv,a.FECHA_INV, b.NOMBRE_TMOV from INVENTARIO a, TIPO_MOVIMIENTO b WHERE a.ID_TMOV = b.ID_TMOV ";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {

                CabeceraInventario per = new CabeceraInventario();
                per.setNumCabecera(rs.getString(1));
                per.setFecha(rs.getString(2));
                per.setMovimiento(rs.getString(3));
                //System.out.println(rs.getString(3) + "22");
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e + "error");
        }
        return list;
    }

    @Override
    public CabeceraInventario list(int id) {
        String sql = "select * from INVENTARIO where id_inv=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setNumCabecera(rs.getString("id_inv"));
                art.setFecha(rs.getString("fecha_inv"));
                art.setMovimiento(rs.getString("id_tmov"));

            }
        } catch (Exception e) {
        }
        return art;
    }

    @Override
    public boolean add(CabeceraInventario art) {

        //int movR = codigoMovimiento(art.getMovimiento());
        String sql = "INSERT INTO  INVENTARIO (id_inv, id_tmov, fecha_inv)values('" + art.getNumCabecera() + "','" + art.getMovimiento() + "','" + art.getFecha() + "')";
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

    public int codigoMovimiento(String nombreMov) {
        int codigo = 0;
        String sql = "SELECT id_tmov FROM TIPO_MOVIMIENTO WHERE nombre_tmov=" + nombreMov;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                art.setMovimiento(rs.getString("id_tmov"));
            }
        } catch (Exception e) {
            System.out.println(e + "rec Cod");
        }
        return 0;
    }

    @Override
    public boolean edit(CabeceraInventario art) {
        String sql = "update INVENTARIO set fecha_inv='" + art.getFecha() + "',id_tmov='" + art.getMovimiento() + "'where id_inv=" + art.getNumCabecera();
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
    
         public ArrayList<CabeceraInventario> mostrarInv() {
        ArrayList<CabeceraInventario> lista = new ArrayList<>();
        try {
            String sql = "select * from INVENTARIO";
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();

            System.out.println(sql);
            while (rs.next()) {
                String cod = rs.getString("id_inv");
                String nombre = rs.getString("fecha_inv");
                String prec = rs.getString("id_tmov");
                
                CabeceraInventario movd = new CabeceraInventario();
                movd.setNumCabecera(cod);
                movd.setFecha(nombre);
                movd.setMovimiento(prec);
                
                lista.add(movd);
            }
        } catch (Exception e) {
            System.out.println(e + "listM");
        }

        return lista;
    }

}
