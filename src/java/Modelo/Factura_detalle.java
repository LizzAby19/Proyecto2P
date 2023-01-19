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
public class Factura_detalle {
    private String id_facdet;
    private String id_fac;
    private String id_art;
    private String cantidad_facdet;
    private String precio_facdet;

    public Factura_detalle() {
        
    }

    public Factura_detalle(String id_fac, String id_art, String cantidad_facdet, String precio_facdet) {
        this.id_facdet = id_facdet;
        this.id_fac = id_fac;
        this.id_art = id_art;
        this.cantidad_facdet = cantidad_facdet;
        this.precio_facdet = precio_facdet;
    }

    public String getId_facdet() {
        return id_facdet;
    }

    public void setId_facdet(String id_facdet) {
        this.id_facdet = id_facdet;
    }

    public String getId_fac() {
        return id_fac;
    }

    public void setId_fac(String id_fac) {
        this.id_fac = id_fac;
    }

    public String getId_art() {
        return id_art;
    }

    public void setId_art(String id_art) {
        this.id_art = id_art;
    }

    public String getCantidad_facdet() {
        return cantidad_facdet;
    }

    public void setCantidad_facdet(String cantidad_facdet) {
        this.cantidad_facdet = cantidad_facdet;
    }

    public String getPrecio_facdet() {
        return precio_facdet;
    }

    public void setPrecio_facdet(String precio_facdet) {
        this.precio_facdet = precio_facdet;
    }
}
