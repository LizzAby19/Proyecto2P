/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.FormaPago;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CrudFormaPago {
    public List listar();
    public FormaPago list(int id);
    public boolean add(FormaPago art);
    public boolean edit(FormaPago art);
    public boolean eliminar(int id);
}
