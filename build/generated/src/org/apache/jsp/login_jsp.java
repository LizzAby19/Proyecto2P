package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class login_jsp extends org.apache.jasper.runtime.HttpJspBase
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

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\n");
      out.write("        <title>JSP Page</title>\n");
      out.write("    </head>\n");
      out.write("    ");
  String rspta="";
        if(request.getParameter("rspta")!=null){
            int r=Integer.parseInt(request.getParameter("rspta"));
            if(r==0){
                rspta="Error: datos incorrectos";
            }
        }
    
      out.write("\n");
      out.write("    <body>\n");
      out.write("    <center>\n");
      out.write("        <div class=\"container-fluid mt-4 col-6\" >\n");
      out.write("            <div class=\"card \" style=\"background:#C5D2F0 \">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <form class=\"form-sing\" action=\"LoginController\" method=\"POST\">\n");
      out.write("                        <div class=\"form-group text-center\">\n");
      out.write("                            <h3>LOGIN</h3><br>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <br>\n");
      out.write("                            <label>Usuario:</label>\n");
      out.write("                            <input type=\"text\" name=\"txtusuario\" class=\"form-control mt-2\" required>\n");
      out.write("                        </div>\n");
      out.write("                        <div class=\"form-group\">\n");
      out.write("                            <br>\n");
      out.write("                            <label>Contraseña:</label>\n");
      out.write("                            <input type=\"password\" name=\"txtclave\" class=\"form-control mt-2\"  required>\n");
      out.write("                        </div>\n");
      out.write("                        <br>\n");
      out.write("                       <center>\n");
      out.write("                            <input type=\"submit\" class=\"btn btn-primary \" name=\"btn-login\" value=\"Ingresar\">\n");
      out.write("                            <a  value=\"Registrarse\" href=\"index.jsp\" class=\"btn btn-secondary \">Registrarse</a>\n");
      out.write("                        </center>\n");
      out.write("                        <p style=\"color: red;\">");
      out.print(rspta );
      out.write("</p>\n");
      out.write("                    </form>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("       <!-- <div class=\"container\" style=\"margin-top: 80px;\">\n");
      out.write("            \n");
      out.write("            <form method=\"post\" action=\"/Login/LoginController\">\n");
      out.write("                <div class=\"card\" style=\"width: 30rem;\">\n");
      out.write("                <div class=\"card-body\">\n");
      out.write("                    <h2>Iniciar Sesion</h2>\n");
      out.write("                    <input type=\"text\" name=\"txtusuario\" class=\"form-control mt-2\" placeholder=\"Ingrese Usuario\" required>\n");
      out.write("                    <input type=\"password\" name=\"txtclave\" class=\"form-control mt-2\" placeholder=\"Ingrese Clave\" required>\n");
      out.write("                    <input type=\"submit\" class=\"btn btn-primary btn-block mt-2\" name=\"btn-login\" value=\"Ingresar\">\n");
      out.write("                    <p style=\"color: red;\">");
      out.print(rspta );
      out.write("</p>\n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("            </form>\n");
      out.write("        </div>-->\n");
      out.write("    </center>\n");
      out.write("</body>\n");
      out.write("</html>\n");
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
