/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Liiz
 */
public class conexion {
    PreparedStatement ps=null;
    public static Connection conectar() {
        String driver = "com.mysql.jdbc.Driver";
        String user = "root";
        String pass = "Espe.2022";
        String url = "jdbc:mysql://localhost:3306/proyecto";
        Connection con = null;
        try {
            Class.forName(driver);
            con = DriverManager.getConnection(url, user, pass);
            if (con != null) {

                System.out.println("Exito....!!");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex);
            System.out.println("Fallaste....!!!" + ex);

        }
        return con;
    }
     public ResultSet ejecutarConsulta(String sql) throws Exception{
    Statement st=null;
    st=conectar().createStatement();
    ResultSet rs=st.executeQuery(sql);
    return rs;
    }
    public int ejecutarActualizacionP(String sql,Object[] params)throws SQLException{
        ps=conectar().prepareStatement(sql);
        //definir los valores para los argumentos
        for(int i=0;i<params.length;i++){
                ps.setObject(i+1,params[i]);
                }
        int r=ps.executeUpdate(); //retorna la cantidad de registros actualizados    
        return r;   
    }
    public void desconectar() throws SQLException{
    conectar().close();
    }
    Connection con;
    public  conexion(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection("jdbc:mysql://localhost:3306/proyecto","root","Espe.2022");            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    public Connection getConnection(){
        return con;
    }
}
