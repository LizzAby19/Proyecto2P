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
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        // String pass = "Espe.2022";
        String pass = "GommNcRgTXROuwJrJFKv";
        // String url = "jdbc:mysql://localhost:3306/proyecto";
        String url = "jdbc:mysql://containers-us-west-52.railway.app:5815/railway?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false&autoReconnect=true";
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
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        // String pass = "Espe.2022";
        String pass = "GommNcRgTXROuwJrJFKv";
        // String url = "jdbc:mysql://localhost:3306/proyecto";
        String url = "jdbc:mysql://containers-us-west-52.railway.app:5815/railway?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false&autoReconnect=true";
        Connection con = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);            
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
    }
    
    public Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String user = "root";
        // String pass = "Espe.2022";
        String pass = "GommNcRgTXROuwJrJFKv";
        // String url = "jdbc:mysql://localhost:3306/proyecto";
        String url = "jdbc:mysql://containers-us-west-52.railway.app:5815/railway?useTimeZone=true&serverTimezone=UTC&autoReconnect=true&useSSL=false&autoReconnect=true";
        Connection con = null;
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con=DriverManager.getConnection(url, user, pass);
            return con;
        } catch (Exception e) {
            System.err.println("Error"+e);
        }
        return null;
    }
}