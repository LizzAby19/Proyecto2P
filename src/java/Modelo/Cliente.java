/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Cliente  {


    private String id_cli;
    private String ruc_cli;
    private String nombre_cli;
    private String direccion_cli;

    public Cliente() {
    }

    public Cliente(String id_cli, String ruc_cli, String nombre_cli, String direccion_cli) {
        this.id_cli = id_cli;
        this.ruc_cli = ruc_cli;
        this.nombre_cli = nombre_cli;
        this.direccion_cli = direccion_cli;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getRuc_cli() {
        return ruc_cli;
    }

    public void setRuc_cli(String ruc_cli) {
        this.ruc_cli = ruc_cli;
    }

    public String getNombre_cli() {
        return nombre_cli;
    }

    public void setNombre_cli(String nombre_cli) {
        this.nombre_cli = nombre_cli;
    }

    public String getDireccion_cli() {
        return direccion_cli;
    }

    public void setDireccion_cli(String direccion_cli) {
        this.direccion_cli = direccion_cli;
    }

    

   
}