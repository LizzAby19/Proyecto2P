/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.CrudCobrador;
import Modelo.Cobrador;
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
public class CobradorDAO implements CrudCobrador {
    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cobrador cob = new Cobrador();

    @Override
    public List listar() {
        ArrayList<Cobrador> list = new ArrayList<>();
        String sql = "select * from proyecto.COBRADOR";
        try {
            con = cn.getConnection();
            System.out.println(sql);
            System.out.println(con.getClientInfo(sql));
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cobrador cobRes = new Cobrador();
                cobRes.setId(rs.getInt("ID_COB"));
                cobRes.setCedula(rs.getInt("CEDULA_COB"));
                cobRes.setNombre(rs.getString("NOMBRE_COB"));
                cobRes.setDireccion(rs.getString("DIRECCION_COB"));
                list.add(cobRes);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el listado: " + e.getMessage());
        }
        return list;
    }

    @Override
    public Cobrador list(int id) {
        String sql = "select * from proyecto.cobrador where ID_COB=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cob.setId(rs.getInt("ID_COB"));
                cob.setCedula(rs.getInt("CEDULA_COB"));
                cob.setNombre(rs.getString("NOMBRE_COB"));
                cob.setDireccion(rs.getString("DIRECCION_COB"));
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener el cobrador con id: " + id + 
                    "\n Error: " + e.getMessage());
        }
        return cob;
    }

    @Override
    public boolean add(Cobrador cob) {
        String sql = "insert into proyecto.cobrador(CEDULA_COB, NOMBRE_COB, DIRECCION_COB) "
                + "values('" + cob.getCedula()+ "','" + cob.getNombre()+ "','" + cob.getDireccion()+ "')";
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
    public boolean edit(Cobrador cob) {
        String sql = "update proyecto.articulo set CEDULA_COB='" + cob.getCedula() + "', NOMBRE_COB='" + cob.getNombre() + "', DIRECCION_COB='" + cob.getDireccion() + "'where ID_COB=" + cob.getId();
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
        String sql = "delete from proyecto.cobrador where ID_COB=" + id;
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
