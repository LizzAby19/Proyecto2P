/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.ArticuloDAO;
import Modelo.Articulo;
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
@WebServlet(name = "ControladorArt", urlPatterns = {"/ControladorArt"})
public class ControladorArt extends HttpServlet {

    //String listar = "/Articulo/listar.jsp";
    //String add = "Articulo/add.jsp";
    //String edit = "Articulo/edit.jsp";
    Articulo p = new Articulo();
    ArticuloDAO dao = new ArticuloDAO();
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
            String nom = request.getParameter("txtNom");
            String prec = request.getParameter("txtPrec");
            String stock = request.getParameter("txtStock");
            p.setNombre_Articulo(nom);
            p.setPrecio_Articulo(prec);
            p.setStock_Articulo(stock);
            System.out.println(nom+prec+stock+"add");
            dao.add(p);
            acceso="listar.jsp";
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso="edit.jsp";
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id = request.getParameter("txtId");
            String nom = request.getParameter("txtNom");
            String prec = request.getParameter("txtPrec");
            String stock = request.getParameter("txtStock");
            System.out.println(nom+prec+stock+idp+"control");
            p.setCodigo_Articulo(id);
            p.setNombre_Articulo(nom);
            p.setPrecio_Articulo(prec);
            p.setStock_Articulo(stock);
            dao.edit(p);
            acceso="listar.jsp";
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id=request.getParameter("id");
            p.setCodigo_Articulo(id);
            
            dao.eliminar(Integer.parseInt(id));
            acceso="listar.jsp";
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
