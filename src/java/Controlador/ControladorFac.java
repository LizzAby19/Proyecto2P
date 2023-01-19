/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.FacturaDAO;
import Modelo.Factura;
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
 * @author Alexander
 */
@WebServlet(name = "ControladorFac", urlPatterns = {"/ControladorFac"})
public class ControladorFac extends HttpServlet {
    
    //String listar = "/Articulo/listar.jsp";
    //String add = "Articulo/add.jsp";
    //String edit = "Articulo/edit.jsp";
    Factura p = new Factura();
    FacturaDAO dao = new FacturaDAO();
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
            String fac = request.getParameter("txtNumFac");
            String fech = request.getParameter("txtFecha");
            String ciu = request.getParameter("txtIdCiu");
            p.setNumero_fac(fac);
            p.setFecha_fac(fech);
            p.setId_ciu(ciu);
            System.out.println(fac+fech+ciu+"add");
            dao.add(p);
            acceso="listarFac.jsp";
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso="editFac.jsp";
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id = request.getParameter("txtIdFac");
            String fac = request.getParameter("txtNumFac");
            String fech = request.getParameter("txtFecha");
            String ciu = request.getParameter("txtIdCiu");
            System.out.println(fac+fech+ciu+idp+"control");
            p.setId_fac(id);
            p.setNumero_fac(fac);
            p.setFecha_fac(fech);
            p.setId_ciu(ciu);
            dao.edit(p);
            acceso="listarFac.jsp";
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id=request.getParameter("id");
            p.setId_fac(id);
            
            dao.eliminar(Integer.parseInt(id));
            acceso="listarFac.jsp";
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
