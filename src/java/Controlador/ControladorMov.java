/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.MovimientoDAO;
import Modelo.Movimiento;
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
@WebServlet(name = "ControladorMov", urlPatterns = {"/ControladorMov"})
public class ControladorMov extends HttpServlet {

    Movimiento p = new Movimiento();
    MovimientoDAO dao = new MovimientoDAO();
    String idp;

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
        } else if (action.equalsIgnoreCase("add")) {
            //acceso=add;
        } else if (action.equalsIgnoreCase("Agregar")) {
            String nom = request.getParameter("txtNom");
            String prec = request.getParameter("txtPrec");
            p.setNombre(nom);
            p.setSigno(prec);
            System.out.println(nom + prec  + "add");
            dao.add(p);
            acceso = "listarMov.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = "editMov.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            String id = request.getParameter("txtId");
            String nom = request.getParameter("txtNom");
            String prec = request.getParameter("txtPrec");
            System.out.println(nom + prec + idp + "control");
            p.setCodigo(id);
            p.setNombre(nom);
            p.setSigno(prec);
            dao.edit(p);
            acceso = "listarMov.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            p.setCodigo(id);

            dao.eliminar(Integer.parseInt(id));
            acceso = "listarMov.jsp";
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
