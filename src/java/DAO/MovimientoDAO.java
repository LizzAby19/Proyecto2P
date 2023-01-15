/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Interfaces.crudMov;
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
public class MovimientoDAO implements crudMov {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Movimiento mov = new Movimiento();

    @Override
    public List listar() {
        ArrayList<Movimiento> list = new ArrayList<>();
        String sql = "select*from proyecto.tipo_movimiento";
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Movimiento per = new Movimiento();
                per.setCodigo(rs.getString("id_tmov"));
                per.setNombre(rs.getString("nombre_tmov"));
                per.setSigno(rs.getString("signo_tmov"));

                list.add(per);
            }
        } catch (Exception e) {
        }
        return list;
    }

    @Override
    public Movimiento list(int id) {
        String sql = "select * from proyecto.tipo_movimiento where id_tmov=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                mov.setCodigo(rs.getString("id_tmov"));
                mov.setNombre(rs.getString("nombre_tmov"));
                mov.setSigno(rs.getString("signo_tmov"));

            }
        } catch (Exception e) {
        }
        return mov;
    }

    @Override
    public boolean add(Movimiento art) {
        String sql = "insert into proyecto.tipo_movimiento(nombre_tmov, signo_tmov)values('" + art.getNombre() + "','" + art.getSigno() + "')";
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

    @Override
    public boolean edit(Movimiento art) {
        String sql = "update proyecto.tipo_movimiento set nombre_tmov='" + art.getNombre() + "',signo_tmov='" + art.getSigno() + "'where id_tmov=" + art.getCodigo();
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
        String sql = "delete from proyecto.tipo_movimiento where id_tmov=" + id;
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
