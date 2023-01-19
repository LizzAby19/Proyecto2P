/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Factura;
import java.util.List;

/**
 *
 * @author Alexander
 */
public interface crudFac {
    public List listar();
    public Factura list(int id);
    public boolean add(Factura cli);
    public boolean edit(Factura cli);
    public boolean eliminar(int id);
}
