/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.CuentaDetalle;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CrudCuentaDetalle {
    public List listar();
    public CuentaDetalle list(int id);
    public boolean add(CuentaDetalle art);
    public boolean edit(CuentaDetalle art);
    public boolean eliminar(int id);
}
