/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CuentaDAO;
import Modelo.Cuenta;
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
@WebServlet(name = "ControladorCuenta", urlPatterns = {"/ControladorCuenta"})
public class ControladorCuenta extends HttpServlet {
    Cuenta cuenta = new Cuenta();
    CuentaDAO dao = new CuentaDAO();
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
        processRequest(request, response);
        String acceso = "";
        String action = request.getParameter("accion");
        System.out.println("doGet ControladorCobrador");

        if (action.equalsIgnoreCase("listar")) {
            //acceso = listar;            
        } else if (action.equalsIgnoreCase("add")) {
            //acceso=add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            Integer idFactura = Integer.parseInt(request.getParameter("txtIdFactura"));
            String estado = request.getParameter("txtEstado");
            String fecha = request.getParameter("txtFecha");
            cuenta.setIdFactura(idFactura);
            cuenta.setEstado(estado);
            cuenta.setFecha(fecha);
            System.out.println(estado + fecha  + "add");
            dao.add(cuenta);
            acceso = "listarCuenta.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            System.out.println(request.getParameter("id"));
            request.setAttribute("idCue", request.getParameter("id"));
            acceso = "editarCuenta.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            Integer id = Integer.parseInt(request.getParameter("txtId"));
            Integer idFactura = Integer.parseInt(request.getParameter("txtIdFactura"));
            String estado = request.getParameter("txtEstado");
            String fecha = request.getParameter("txtFecha");
            System.out.println(idFactura + estado + idc + "control");
            cuenta.setId(id);
            cuenta.setIdFactura(idFactura);
            cuenta.setEstado(estado);
            cuenta.setFecha(fecha);
            dao.edit(cuenta);
            acceso = "listarCuenta.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            cuenta.setId(id);

            dao.eliminar(id);
            acceso = "listarCuenta.jsp";
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
