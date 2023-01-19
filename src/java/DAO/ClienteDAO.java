/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Controlador.conexion;
import Modelo.Cliente;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import Interfaces.crudCli;

/**
 *
 * @author Liiz
 */
public class ClienteDAO implements crudCli {

    conexion cn = new conexion();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Cliente cli = new Cliente();

    @Override
    public List listar() {
        ArrayList<Cliente> list = new ArrayList<>();
        String sql = "select * from CLIENTE";
        System.out.println(sql);
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                Cliente per = new Cliente();
                per.setId_cli(rs.getString("id_cli"));
                per.setRuc_cli(rs.getString("ruc_cli"));
                per.setNombre_cli(rs.getString("nombre_cli"));
                per.setDireccion_cli(rs.getString("direccion_cli"));
                System.out.println(per);
                list.add(per);
            }
        } catch (Exception e) {
            System.out.println(e+"ex");
        }
        return list;
    }

    @Override
    public Cliente list(int id) {
        String sql = "select * from CLIENTE where id_cli=" + id;
        try {
            con = cn.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                cli.setId_cli(rs.getString("id_cli"));
                cli.setRuc_cli(rs.getString("ruc_cli"));
                cli.setNombre_cli(rs.getString("nombre_cli"));
                cli.setDireccion_cli(rs.getString("direccion_cli"));

            }
        } catch (Exception e) {
        }
        return cli;
    }

    @Override
    public boolean add(Cliente cli) {
        String sql = "insert into CLIENTE(ruc_cli, nombre_cli, direccion_cli)values('" + cli.getRuc_cli()+ "','" + cli.getNombre_cli()+ "','" + cli.getDireccion_cli() + "')";
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
    public boolean edit(Cliente cli) {
        String sql = "update CLIENTE set ruc_cli='" + cli.getRuc_cli() + "',nombre_cli='" + cli.getNombre_cli()+ "',direccion_cli='" + cli.getDireccion_cli() + "'where id_cli=" + cli.getId_cli();
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
        String sql = "delete from CLIENTE where id_cli=" + id;
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
