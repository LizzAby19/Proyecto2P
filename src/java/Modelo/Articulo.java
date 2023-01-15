/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;


public class Articulo  {


    private String Codigo_Articulo;
    private String Nombre_Articulo;
    private String Precio_Articulo;
    private String Stock_Articulo;

    public Articulo() {
    }

    public String getCodigo_Articulo() {
        return Codigo_Articulo;
    }

    public void setCodigo_Articulo(String Codigo_Articulo) {
        this.Codigo_Articulo = Codigo_Articulo;
    }

    public String getNombre_Articulo() {
        return Nombre_Articulo;
    }

    public void setNombre_Articulo(String Nombre_Articulo) {
        this.Nombre_Articulo = Nombre_Articulo;
    }

    public String getPrecio_Articulo() {
        return Precio_Articulo;
    }

    public void setPrecio_Articulo(String Precio_Articulo) {
        this.Precio_Articulo = Precio_Articulo;
    }

    public String getStock_Articulo() {
        return Stock_Articulo;
    }

    public void setStock_Articulo(String Stock_Articulo) {
        this.Stock_Articulo = Stock_Articulo;
    }

  

    

}