/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Articulo;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudArt {
    public List listar();
    public Articulo list(int id);
    public boolean add(Articulo art);
    public boolean edit(Articulo art);
    public boolean eliminar(int id);
}
