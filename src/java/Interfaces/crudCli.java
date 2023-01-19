/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Modelo.Cliente;
import java.util.List;

/**
 *
 * @author Liiz
 */
public interface crudCli {
    public List listar();
    public Cliente list(int id);
    public boolean add(Cliente cli);
    public boolean edit(Cliente cli);
    public boolean eliminar(int id);
}
