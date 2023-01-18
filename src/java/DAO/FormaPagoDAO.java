/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.CrudFormaPago;
import Modelo.Cobrador;
import Modelo.FormaPago;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import WSAG_Utilidades.WSAG_Seguridad;

/**
 *
 * @author Usuario
 */
public class FormaPagoDAO implements CrudFormaPago {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    FormaPago pay = new FormaPago();

    @Override
    public List listar() {
        ArrayList<FormaPago> list = new ArrayList<>();
        String sql = "select * from FORMA_PAGO";
        try {
            con = cn.getConnection();
            System.out.println(sql);
            System.out.println(con.getClientInfo(sql));
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                FormaPago cobRes = new FormaPago();
                cobRes.setId(rs.getInt("ID_FOR"));
                cobRes.setCodigo(rs.getString("CODIGO_FOR"));
                cobRes.setNombre(rs.getString("NOMBRE_FOR"));
                list.add(cobRes);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el listado: " + e.getMessage());
        }
        return list;
    }

    @Override
    public FormaPago list(int id) {
        String sql = "select * from FORMA_PAGO where ID_FOR=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pay.setId(rs.getInt("ID_FOR"));
                pay.setNombre(rs.getString("NOMBRE_FOR"));
                pay.setCodigo(rs.getString("CODIGO_FOR"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la forma de pago con id: " + id + 
                    "\n Error: " + e.getMessage());
        }
        return pay;
    }

    @Override
    public boolean add(FormaPago payment) {
        String codigoEncriptado = WSAG_Seguridad.WSAG_Encriptar(payment.getCodigo());
        String sql = "insert into FORMA_PAGO(CODIGO_FOR, NOMBRE_FOR) "
                + "values('" + codigoEncriptado + "','" + payment.getNombre()+ "')";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql + "dao");
            return true;
        } catch (SQLException e) {
            System.out.println(e +sql +"dao");
        }
        return false;
    }

    @Override
    public boolean edit(FormaPago art) {
        String codigoEncriptado = WSAG_Seguridad.WSAG_Encriptar(art.getCodigo());
        String sql = "update FORMA_PAGO set CODIGO_FOR='" + codigoEncriptado + "', NOMBRE_FOR='" + art.getNombre() + "'where ID_FOR=" + art.getId();
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al editar: " + e.getMessage());
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
        String sql = "delete from FORMA_PAGO where ID_FOR=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            ps.executeUpdate();
            System.out.println(sql);
            return true;
        } catch (SQLException e) {
            System.out.println("Error al eliminar: " + e.getMessage());
            return false;
        }
    }
    
}
