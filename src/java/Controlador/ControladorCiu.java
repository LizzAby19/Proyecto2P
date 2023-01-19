/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.CiudadDAO;
import Modelo.Ciudad;
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
@WebServlet(name = "ControladorCiu", urlPatterns = {"/ControladorCiu"})
public class ControladorCiu extends HttpServlet {

    Ciudad p = new Ciudad();
    CiudadDAO dao = new CiudadDAO();
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
            String cod = request.getParameter("txtCod");
            String nom = request.getParameter("txtNom");
            p.setCodigo_ciu(cod);
            p.setNombre_ciu(nom);
            System.out.println(cod + nom  + "add");
            dao.add(p);
            acceso = "listarCiu.jsp";
        } else if (action.equalsIgnoreCase("editar")) {
            request.setAttribute("idper", request.getParameter("id"));
            acceso = "editCiu.jsp";
        } else if (action.equalsIgnoreCase("Actualizar")) {
            String id = request.getParameter("txtId");
            String cod = request.getParameter("txtCod");
            String nom = request.getParameter("txtNom");
            System.out.println(cod + nom + idp + "control");
            p.setId_ciu(id);
            p.setCodigo_ciu(cod);
            p.setNombre_ciu(nom);
            dao.edit(p);
            acceso = "listarCiu.jsp";
        } else if (action.equalsIgnoreCase("eliminar")) {
            String id = request.getParameter("id");
            p.setId_ciu(id);

            dao.eliminar(Integer.parseInt(id));
            acceso = "listarCiu.jsp";
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
