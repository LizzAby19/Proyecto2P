/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ClienteDAO;
import Modelo.Cliente;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Liiz
 */
@WebServlet(name = "ControladorCli", urlPatterns = {"/ControladorCli"})
public class ControladorCli extends HttpServlet {

    //String listar = "/Articulo/listar.jsp";
    //String add = "Articulo/add.jsp";
    //String edit = "Articulo/edit.jsp";
    Cliente p = new Cliente();
    ClienteDAO dao = new ClienteDAO();
    String idp;

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        
        if (action.equalsIgnoreCase("listar")) {
            //acceso = listar;            
        }else if(action.equalsIgnoreCase("add")){
            //acceso=add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String ruc = request.getParameter("txtRuc");
            String nom = request.getParameter("txtNom");
            String dir = request.getParameter("txtDir");
            p.setRuc_cli(ruc);
            p.setNombre_cli(nom);
            p.setDireccion_cli(dir);
            System.out.println(ruc+nom+dir+"add");
            dao.add(p);
            acceso="listarCli.jsp";
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso="editCli.jsp";
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id = request.getParameter("txtId");
            String ruc = request.getParameter("txtRuc");
            String nom = request.getParameter("txtNom");
            String dir = request.getParameter("txtDir");
            System.out.println(ruc+nom+dir+idp+"control");
            p.setId_cli(id);
            p.setRuc_cli(ruc);
            p.setNombre_cli(nom);
            p.setDireccion_cli(dir);
            dao.edit(p);
            acceso="listarCli.jsp";
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id=request.getParameter("id");
            p.setId_cli(id);
            
            dao.eliminar(Integer.parseInt(id));
            acceso="listarCli.jsp";
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }
    
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
