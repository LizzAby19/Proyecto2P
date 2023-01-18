/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Usuario;
import java.sql.Connection;
import Controlador.conexion;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import javax.servlet.annotation.WebServlet;

/**
 *
 * @author Liiz
 */
@WebServlet(name = "UsuarioDAO", urlPatterns = {"/UsuarioDAO"})
public class UsuarioDAO {

    public static ResultSet rs;

    public static int registrarUsuario(Usuario u) {
        int est = 0;
        try {
            Connection con = conexion.conectar();
            String sql = "insert into USUARIO (usuario_usu, clave_usu) values (?,?)";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, u.getUsuario());
            ps.setString(2, u.getPassword());
            est = ps.executeUpdate();
            System.out.println("reg usu!!");
            con.close();
        } catch (Exception e) {
            System.out.println("no reg usu!!"+e);
        }
        return est;
    }

}
