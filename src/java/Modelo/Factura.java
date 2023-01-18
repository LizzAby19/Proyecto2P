/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Alexander
 */
public class Factura {
    private String id_fac;
    private String id_ciu;
    private String id_cli;
    private String numero_fac;
    private String fecha_fac;
    private float total_fac;

    public Factura() {
    }

    public Factura(String id_fac, String id_ciu, String id_cli, String numero_fac, String fecha_fac, float total_fac) {
        this.id_fac = id_fac;
        this.id_ciu = id_ciu;
        this.id_cli = id_cli;
        this.numero_fac = numero_fac;
        this.fecha_fac = fecha_fac;
        this.total_fac = total_fac; 
    }

    public String getId_fac() {
        return id_fac;
    }

    public void setId_fac(String id_fac) {
        this.id_fac = id_fac;
    }

    public String getId_ciu() {
        return id_ciu;
    }

    public void setId_ciu(String id_ciu) {
        this.id_ciu = id_ciu;
    }

    public String getId_cli() {
        return id_cli;
    }

    public void setId_cli(String id_cli) {
        this.id_cli = id_cli;
    }

    public String getNumero_fac() {
        return numero_fac;
    }

    public void setNumero_fac(String numero_fac) {
        this.numero_fac = numero_fac;
    }

    public String getFecha_fac() {
        return fecha_fac;
    }

    public void setFecha_fac(String fecha_fac) {
        this.fecha_fac = fecha_fac;
    }

    public float getTotal_fac() {
        return total_fac;
    }

    public void setTotal_fac(float total_fac) {
        this.total_fac = total_fac;
    }
}
