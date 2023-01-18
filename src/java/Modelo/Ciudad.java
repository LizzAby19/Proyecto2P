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

public class Ciudad  {

    private String id_ciu;
    private String codigo_ciu;
    private String nombre_ciu;

    public Ciudad() {
    }

    public Ciudad(String id_ciu, String codigo_ciu, String nombre_ciu) {
        this.id_ciu = id_ciu;
        this.codigo_ciu = codigo_ciu;
        this.nombre_ciu = nombre_ciu;
    }

    public String getId_ciu() {
        return id_ciu;
    }

    public void setId_ciu(String id_ciu) {
        this.id_ciu = id_ciu;
    }

    public String getCodigo_ciu() {
        return codigo_ciu;
    }

    public void setCodigo_ciu(String codigo_ciu) {
        this.codigo_ciu = codigo_ciu;
    }

    public String getNombre_ciu() {
        return nombre_ciu;
    }

    public void setNombre_ciu(String nombre_ciu) {
        this.nombre_ciu = nombre_ciu;
    }

    

    
    
 }