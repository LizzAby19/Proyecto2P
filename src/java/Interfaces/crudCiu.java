/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Ciudad;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudCiu {
    public List listar();
    public Ciudad list(int id);
    public boolean add(Ciudad art);
    public boolean edit(Ciudad art);
    public boolean eliminar(int id);
}
