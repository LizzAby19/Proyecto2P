package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.Iterator;
import java.util.List;
import Modelo.Ciudad;
import DAO.CiudadDAO;

public final class listarCiu_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("    <head>\r\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\r\n");
      out.write("        <title>JSP Page</title>\r\n");
      out.write("        <link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\"></link>\r\n");
      out.write("        <script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"></script>\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        <div id=\"menu\">\r\n");
      out.write("            <nav class=\"navbar navbar-expand-sm bg-dark navbar-dark\">\r\n");
      out.write("                <div class=\"col-9\"><h3 style=\"color: #fff\">Proyecto 2 Parcial</h3></div>\r\n");
      out.write("                <div class=\"container-fluid col-3\">\r\n");
      out.write("                    <div class=\"collapse navbar-collapse\" id=\"collapsibleNavbar\">\r\n");
      out.write("                        <ul class=\"navbar-nav\">\r\n");
      out.write("                            <li class=\"nav-item dropdown\">\r\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\">Inventario</a>\r\n");
      out.write("                                <ul class=\"dropdown-menu\">\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"http://localhost:8080/Proyecto2P/listar.jsp\">Articulo</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"http://localhost:8080/Proyecto2P/listarMov.jsp\">Tipo Movimiento</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Compleja </a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Reporte</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <ul class=\"navbar-nav\">\r\n");
      out.write("                            <li class=\"nav-item dropdown\">\r\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\">Facturacion</a>\r\n");
      out.write("                                <ul class=\"dropdown-menu\">\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"http://localhost:8080/Proyecto2P/listarCli.jsp\">Cliente</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"http://localhost:8080/Proyecto2P/listarCiu.jsp\">Ciudad</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"http://localhost:8080/Proyecto2P/listarFac.jsp\">Compleja </a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Reporte</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                        <ul class=\"navbar-nav\">\r\n");
      out.write("                            <li class=\"nav-item dropdown\">\r\n");
      out.write("                                <a class=\"nav-link dropdown-toggle\" href=\"#\" role=\"button\" data-bs-toggle=\"dropdown\">Inventario</a>\r\n");
      out.write("                                <ul class=\"dropdown-menu\">\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Articulo</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Tipo Movimiento</a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Compleja </a></li>\r\n");
      out.write("                                    <li><a class=\"dropdown-item\" href=\"\">Reporte</a></li>\r\n");
      out.write("                                </ul>\r\n");
      out.write("                            </li>\r\n");
      out.write("                        </ul>\r\n");
      out.write("                    </div>\r\n");
      out.write("                </div>\r\n");
      out.write("            </nav>\r\n");
      out.write("        </div>\r\n");
      out.write("        <h1 style=\"text-align: center\">Ciudad</h1>\r\n");
      out.write("        <div class=\"container\">\r\n");
      out.write("            <a class=\"btn btn-success\" href=\"addCiu.jsp\">Agregar Nuevo</a>\r\n");
      out.write("            <br><br>\r\n");
      out.write("            <table class=\"table table-bordered\">\r\n");
      out.write("                <thead>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                       \r\n");
      out.write("                        <th class=\"text-center\">Codigo</th>\r\n");
      out.write("                        <th class=\"text-center\">Nombre</th>\r\n");
      out.write("                        <th class=\"text-center\">ACCIONES</th>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                </thead>\r\n");
      out.write("                ");

                    CiudadDAO dao = new CiudadDAO();
                    List<Ciudad> list = dao.listar();
                    Iterator<Ciudad> iter = list.iterator();
                    Ciudad art=null;
                    while(iter.hasNext()){
                        art = iter.next();
                    
                
      out.write("\r\n");
      out.write("                \r\n");
      out.write("                <tbody>\r\n");
      out.write("                    <tr>\r\n");
      out.write("                        \r\n");
      out.write("                        <td class=\"text-center\">");
      out.print( art.getCodigo_ciu());
      out.write("</td>\r\n");
      out.write("                        <td class=\"text-center\">");
      out.print( art.getNombre_ciu());
      out.write("</td>\r\n");
      out.write("                        <td class=\"text-center\">\r\n");
      out.write("                            <a class=\"btn btn-warning\" href=\"ControladorCiu?accion=editar&id=");
      out.print( art.getId_ciu());
      out.write("\">Editar</a>\r\n");
      out.write("                            <a class=\"btn btn-danger\" href=\"ControladorCiu?accion=eliminar&id=");
      out.print( art.getId_ciu());
      out.write("\">Remove</a>\r\n");
      out.write("                        </td>\r\n");
      out.write("                    </tr>\r\n");
      out.write("                    ");
}
      out.write("\r\n");
      out.write("                </tbody>\r\n");
      out.write("            </table>\r\n");
      out.write("        </div>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
