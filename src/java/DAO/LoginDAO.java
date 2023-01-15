/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import Modelo.*;
import Controlador.conexion;
import Modelo.Usuario;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author Manue
 */
public class LoginDAO {
    int rspta=0;
    String sql="";
    ResultSet rs=null;
    conexion cn=new conexion();
    
    public int validarLogin(Usuario tm) throws Exception{
        sql="SELECT COUNT(id_usu) AS CANTIDAD FROM proyecto.usuario WHERE USUARIO_USU='"+tm.getUsuario()+"' AND CLAVE_USU='"+tm.getPassword()+"'";
        rs=cn.ejecutarConsulta(sql);
        while(rs.next()){
            rspta=rs.getInt("cantidad");
        }
    return  rspta;
    }
    
    
}

