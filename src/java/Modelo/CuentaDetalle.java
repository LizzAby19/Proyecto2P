/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

/**
 *
 * @author Usuario
 */
public class CuentaDetalle {
    private Integer id;
    private Integer idCuenta;
    private Integer idCobrador;
    private Integer ifFormaPago;
    private String fecha;
    private Double valor;

    public CuentaDetalle() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIdCuenta() {
        return idCuenta;
    }

    public void setIdCuenta(Integer idCuenta) {
        this.idCuenta = idCuenta;
    }

    public Integer getIdCobrador() {
        return idCobrador;
    }

    public void setIdCobrador(Integer idCobrador) {
        this.idCobrador = idCobrador;
    }

    public Integer getIfFormaPago() {
        return ifFormaPago;
    }

    public void setIfFormaPago(Integer ifFormaPago) {
        this.ifFormaPago = ifFormaPago;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }
}
