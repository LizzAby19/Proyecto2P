/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Movimiento;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudMov {
    public List listar();
    public Movimiento list(int id);
    public boolean add(Movimiento art);
    public boolean edit(Movimiento art);
    public boolean eliminar(int id);
}
