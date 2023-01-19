/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import DAO.FacturaDetDAO;
import Modelo.Factura_detalle;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "ControladorFacDet", urlPatterns = {"/ControladorFacDet"})
public class ControladorFacDet extends HttpServlet{
    
    //String listar = "/Articulo/listar.jsp";
    //String add = "Articulo/add.jsp";
    //String edit = "Articulo/edit.jsp";
    Factura_detalle p = new Factura_detalle();
    FacturaDetDAO dao = new FacturaDetDAO();
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
            String art = request.getParameter("txtIdArt");
            String can = request.getParameter("txtCan");
            String pre = request.getParameter("txtPre");
            p.setId_art(art);
            p.setCantidad_facdet(can);
            p.setPrecio_facdet(pre);
            System.out.println(art+can+pre+"add");
            dao.add(p);
            acceso="listarFacDet.jsp";
        }else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idper",request.getParameter("id"));
            acceso="editFacDet.jsp";
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            String id = request.getParameter("txtFacDet");
            String art = request.getParameter("txtIdArt");
            String can = request.getParameter("txtCan");
            String pre = request.getParameter("txtPre");
            System.out.println(art+can+pre+idp+"control");
            p.setId_facdet(id);
            p.setId_art(art);
            p.setCantidad_facdet(can);
            p.setPrecio_facdet(pre);
            dao.edit(p);
            acceso="listarFacDet.jsp";
        }
        else if(action.equalsIgnoreCase("eliminar")){
            String id=request.getParameter("id");
            p.setId_facdet(id);
            
            dao.eliminar(Integer.parseInt(id));
            acceso="listarFacDet.jsp";
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
