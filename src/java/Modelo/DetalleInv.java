/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Liiz
 */
public class DetalleInv {

    private String id_detI;
    private String id_art;
    private String id_inv;
    private String cantidad;
    private String precio;

    @Override
    public String toString() {
        return "DetalleInv{" + "id_detI=" + id_detI + ", id_art=" + id_art + ", id_inv=" + id_inv + ", cantidad=" + cantidad + ", precio=" + precio + '}';
    }

    public DetalleInv() {
    }

    public DetalleInv(String id_detI, String id_art, String id_inv, String cantidad, String precio) {
        this.id_detI = id_detI;
        this.id_art = id_art;
        this.id_inv = id_inv;
        this.cantidad = cantidad;
        this.precio = precio;
    }
    
    
    
    public String getId_detI() {
        return id_detI;
    }

    public void setId_detI(String id_detI) {
        this.id_detI = id_detI;
    }

    public String getId_art() {
        return id_art;
    }

    public void setId_art(String id_art) {
        this.id_art = id_art;
    }

    public String getId_inv() {
        return id_inv;
    }

    public void setId_inv(String id_inv) {
        this.id_inv = id_inv;
    }

    public String getCantidad() {
        return cantidad;
    }

    public void setCantidad(String cantidad) {
        this.cantidad = cantidad;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    
}
