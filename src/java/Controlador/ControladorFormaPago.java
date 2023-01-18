/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CobradorDAO;
import DAO.FormaPagoDAO;
import Modelo.Cobrador;
import Modelo.FormaPago;
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
@WebServlet(name = "ControladorFormaPago", urlPatterns = {"/ControladorFormaPago"})
public class ControladorFormaPago extends HttpServlet {
    FormaPago pay = new FormaPago();
    FormaPagoDAO dao = new FormaPagoDAO();
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
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println("doGet ControladorCobrador");

        if (action.equalsIgnoreCase("listar")) {
            //acceso = listar;            
        } else if (action.equalsIgnoreCase("add")) {
            //acceso=add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String codigo = request.getParameter("txtCodigo");
            String nombre = request.getParameter("txtNombre");
            pay.setCodigo(codigo);
            pay.setNombre(nombre);
            System.out.println(nombre + codigo  + "add");
            dao.add(pay);
            acceso = "listarFormaPago.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            System.out.println(request.getParameter("id"));
            request.setAttribute("idPay", request.getParameter("id"));
            acceso = "editarFormaPago.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            Integer id = Integer.parseInt(request.getParameter("txtId"));
            String codigo = request.getParameter("txtCodigo");
            String nombre = request.getParameter("txtNombre");
            System.out.println(nombre + codigo + idp + "control");
            pay.setId(id);
            pay.setNombre(nombre);
            pay.setCodigo(codigo);
            dao.edit(pay);
            acceso = "listarFormaPago.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            pay.setId(id);

            dao.eliminar(id);
            acceso = "listarFormaPago.jsp";
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
