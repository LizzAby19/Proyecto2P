/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CuentaDetalleDAO;
import DAO.FormaPagoDAO;
import Modelo.CuentaDetalle;
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
@WebServlet(name = "ControladorCuentaDetalle", urlPatterns = {"/ControladorCuentaDetalle"})
public class ControladorCuentaDetalle extends HttpServlet {
    CuentaDetalle pay = new CuentaDetalle();
    CuentaDetalleDAO dao = new CuentaDetalleDAO();
    String idp;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
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
            Integer idCuenta = Integer.parseInt(request.getParameter("txtIdCuenta"));
            Integer idCobrador = Integer.parseInt(request.getParameter("txtIdCobrador"));
            Integer idFormaPago = Integer.parseInt(request.getParameter("txtIdFormaPago"));            
            String fecha = request.getParameter("txtFecha");
            Double valor = Double.parseDouble(request.getParameter("txtValor"));
            
            pay.setIdCuenta(idCuenta);
            pay.setIdCobrador(idCobrador);
            pay.setIfFormaPago(idFormaPago);
            pay.setValor(valor);
            pay.setFecha(fecha);
            System.out.println(fecha + valor  + "add");
            dao.add(pay);
            acceso = "listarCuenta.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            System.out.println(request.getParameter("id"));
            request.setAttribute("idCuenDet", request.getParameter("id"));
            acceso = "editarCuentaDetalle.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            Integer id = Integer.parseInt(request.getParameter("txtId"));
            Integer idCuenta = Integer.parseInt(request.getParameter("txtIdCuenta"));
            Integer idCobrador = Integer.parseInt(request.getParameter("txtIdCobrador"));
            Integer idFormaPago = Integer.parseInt(request.getParameter("txtIdFormaPago"));            
            String fecha = request.getParameter("txtFecha");
            Double valor = Double.parseDouble(request.getParameter("txtValor"));
            System.out.println(valor + fecha + idp + "control");
            pay.setId(id);
            pay.setIdCuenta(idCuenta);
            pay.setIdCobrador(idCobrador);
            pay.setIfFormaPago(idFormaPago);
            pay.setValor(valor);
            pay.setFecha(fecha);
            dao.edit(pay);
            acceso = "listarCuenta.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            Integer id = Integer.parseInt(request.getParameter("id"));
            pay.setId(id);

            dao.eliminar(id);
            acceso = "listarCuenta.jsp";
        }
        RequestDispatcher vista = request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
