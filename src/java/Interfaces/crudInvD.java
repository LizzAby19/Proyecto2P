/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.DetalleInv;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudInvD {
    public List listar();
    public DetalleInv list(int id);
    public boolean add(DetalleInv art);
    public boolean edit(DetalleInv art);
    public boolean eliminar(int id);
}
