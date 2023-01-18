/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CobradorDAO;
import Modelo.Cobrador;
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
 * @author Usuario
 */
@WebServlet(name = "ControladorCobrador", urlPatterns = {"/ControladorCobrador"})
public class ControladorCobrador extends HttpServlet {
    Cobrador cob = new Cobrador();
    CobradorDAO dao = new CobradorDAO();
    String idc;
    
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
        System.out.println("doGet ControladorCobrador");

        if (action.equalsIgnoreCase("listar")) {
            //acceso = listar;            
        } else if (action.equalsIgnoreCase("add")) {
            //acceso=add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            Integer cedula = Integer.parseInt(request.getParameter("txtCedula"));
            String nombre = request.getParameter("txtNombre");
            String direccion = request.getParameter("txtDireccion");
            cob.setCedula(cedula);
            cob.setNombre(nombre);
            cob.setDireccion(direccion);
            System.out.println(nombre + direccion  + "add");
            dao.add(cob);
            acceso = "listarCobrador.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            System.out.println(request.getParameter("id"));
            request.setAttribute("idCob", request.getParameter("id"));
            acceso = "editarCobrador.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            Integer id = Integer.parseInt(request.getParameter("txtId"));
            String nombre = request.getParameter("txtNombre");
            Integer cedula = Integer.parseInt(request.getParameter("txtCedula"));
            String direccion = request.getParameter("txtDireccion");
            System.out.println(nombre + direccion + idc + "control");
            cob.setId(id);
            cob.setNombre(nombre);
            cob.setCedula(cedula);
            cob.setDireccion(direccion);
            dao.edit(cob);
            acceso = "listarCobrador.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            cob.setId(id);

            dao.eliminar(id);
            acceso = "listarCobrador.jsp";
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
