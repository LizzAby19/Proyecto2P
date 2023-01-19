/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Liiz
 */
@Entity
public class CabeceraInventario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private String numCabecera;
    private String movimiento;
    private String fecha;

    public CabeceraInventario(String numCabecera, String movimiento, String fecha) {
        this.numCabecera = numCabecera;
        this.movimiento = movimiento;
        this.fecha = fecha;
    }

    public String getNumCabecera() {
        return numCabecera;
    }

    public void setNumCabecera(String numCabecera) {
        this.numCabecera = numCabecera;
    }

    public String getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(String movimiento) {
        this.movimiento = movimiento;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public CabeceraInventario() {
    }  
    
}

