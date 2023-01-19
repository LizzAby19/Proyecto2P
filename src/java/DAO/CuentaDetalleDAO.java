/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.CrudCuentaDetalle;
import Modelo.CuentaDetalle;
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
public class CuentaDetalleDAO implements CrudCuentaDetalle{
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    CuentaDetalle pay = new CuentaDetalle();

    @Override
    public List listar() {
        ArrayList<CuentaDetalle> list = new ArrayList<>();
        String sql = "select * from CUENTA_DETALLE";
        try {
            con = cn.getConnection();
            System.out.println(sql);
            System.out.println(con.getClientInfo(sql));
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                CuentaDetalle cobRes = new CuentaDetalle();
                cobRes.setId(rs.getInt("ID_CUENDET"));
                cobRes.setIdCuenta(rs.getInt("ID_CUE"));
                cobRes.setIdCobrador(rs.getInt("ID_COB"));
                cobRes.setIfFormaPago(rs.getInt("ID_FOR"));
                cobRes.setValor(rs.getDouble("VALOR_CUENDET"));
                cobRes.setFecha(rs.getString("FECHA_CUENDET"));
                list.add(cobRes);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el listado: " + e.getMessage());
        }
        return list;
    }

    @Override
    public CuentaDetalle list(int id) {
        String sql = "select * from CUENTA_DETALLE where ID_CUENDET=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                pay.setId(rs.getInt("ID_CUENDET"));
                pay.setIdCuenta(rs.getInt("ID_CUE"));
                pay.setIdCobrador(rs.getInt("ID_COB"));
                pay.setIfFormaPago(rs.getInt("ID_FOR"));
                pay.setValor(rs.getDouble("VALOR_CUENDET"));
                pay.setFecha(rs.getString("FECHA_CUENDET"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener la forma de pago con id: " + id + 
                    "\n Error: " + e.getMessage());
        }
        return pay;
    }

    @Override
    public boolean add(CuentaDetalle art) {
        String sql = "insert into CUENTA_DETALLE(ID_CUE, ID_COB, ID_FOR, VALOR_CUENDET, FECHA_CUENDET) "
                + "values('" + art.getIdCuenta() + "','" + art.getIdCobrador() + "'," + art.getIfFormaPago()+ "'," + art.getValor() + "'," + art.getFecha()+ "')";
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
    public boolean edit(CuentaDetalle art) {
        String sql = "update CUENTA_DETALLE set ID_CUE=" + art.getIdCuenta() + ", ID_COB=" + art.getIdCobrador()+ ",ID_FOR=" + art.getIfFormaPago()+ ",VALOR_CUENDET=" + art.getValor()+ ", FECHA_CUENDET='" + art.getFecha()+ "'where ID_CUENDET=" + art.getId();
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
        String sql = "delete from CUENTA_DETALLE where ID_CUENDET=" + id;
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
