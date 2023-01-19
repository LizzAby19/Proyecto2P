/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.InventarioDDAO;
import Modelo.DetalleInv;
import java.io.IOException;
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
@WebServlet(name = "ControladorDet", urlPatterns = {"/ControladorDet"})
public class ControladorDet extends HttpServlet {

    DetalleInv p = new  DetalleInv();
    InventarioDDAO dao = new InventarioDDAO();
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

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
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
            String nom = request.getParameter("txtInv");
            String prec = request.getParameter("txtArt");
            String stock = request.getParameter("txtCant");
            
            p.setId_inv(nom);
            p.setId_art(prec);
            p.setCantidad(stock);
            
            System.out.println(nom+ "add");
            dao.add(p); 
            acceso = "inventarioT.jsp";
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso="editDet.jsp";
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String cod = request.getParameter("txtInv");
            String id = request.getParameter("txtfecha");
            String nom = request.getParameter("txtArt");
            String prec = request.getParameter("txtCant");
            System.out.println(nom+prec+id+"control");
            p.setId_detI(cod);
            p.setId_inv(id);
            p.setId_art(nom);
            p.setCantidad(prec);
            dao.edit(p);
            acceso="inventarioT.jsp";
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id=request.getParameter("id");
            p.setId_detI(id);
            dao.eliminar(Integer.parseInt(id));
            acceso="inventarioT.jsp";
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
