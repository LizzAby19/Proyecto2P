/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.CabeceraInventario;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudInvC {
    public List listar();
    public CabeceraInventario list(int id);
    public boolean add(CabeceraInventario art);
    public boolean edit(CabeceraInventario art);
}
