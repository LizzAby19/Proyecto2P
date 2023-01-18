/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cobrador;
import java.util.List;

/**
 *
 * @author Usuario
 */
public interface CrudCobrador {
    public List listar();
    public Cobrador list(int id);
    public boolean add(Cobrador art);
    public boolean edit(Cobrador art);
    public boolean eliminar(int id);
}
