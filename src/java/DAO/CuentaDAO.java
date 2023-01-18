/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.CrudCuenta;
import Modelo.Cuenta;
import Modelo.FormaPago;
import WSAG_Utilidades.WSAG_Seguridad;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class CuentaDAO implements CrudCuenta {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cuenta pay = new Cuenta();

    @Override
    public List listar() {
        ArrayList<Cuenta> list = new ArrayList<>();
        String sql = "select * from CUENTA";
        try {
            con = cn.getConnection();
            System.out.println(sql);
            System.out.println(con.getClientInfo(sql));
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cuenta cuenta = new Cuenta();
                cuenta.setId(rs.getInt("ID_CUE"));
                cuenta.setIdFactura(Integer.parseInt(rs.getString("ID_FAC")));
                cuenta.setFecha(rs.getString("FECHA_CUE"));
                cuenta.setEstado(rs.getString("ESTADO_CUE"));
                list.add(cuenta);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el listado: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Cuenta list(int id) {
        String sql = "select * from CUENTA where ID_CUE=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pay.setId(rs.getInt("ID_CUE"));
                pay.setIdFactura(Integer.parseInt(rs.getString("ID_FAC")));
                pay.setEstado(rs.getString("FECHA_CUE"));
                pay.setFecha(rs.getString("ESTADO_CUE"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la forma de pago con id: " + id + 
                    "\n Error: " + e.getMessage());
        }
        return pay;
    }

    @Override
    public boolean add(Cuenta art) {
        String sql = "insert into CUENTA(ID_FAC, ESTADO_CUE, FECHA_CUE) "
                + "values(" + art.getIdFactura() + ",'" + art.getEstado() + "','"
                + art.getFecha() + "')";
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
    public boolean edit(Cuenta art) {
        String sql = "update CUENTA set ID_FAC=" + art.getIdFactura() + ", FECHA_CUE='" + art.getFecha() + "', ESTADO_CUE='" + art.getEstado() + "' where ID_CUE=" + art.getId();
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
        String sql = "delete from CUENTA where ID_CUE=" + id;
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
