/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cuenta;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CrudCuenta {
    public List listar();
    public Cuenta list(int id);
    public boolean add(Cuenta art);
    public boolean edit(Cuenta art);
    public boolean eliminar(int id);
}
