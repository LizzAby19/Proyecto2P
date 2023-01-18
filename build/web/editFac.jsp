<%-- 
    Document   : editFac
    Created on : 18/01/2023, 0:07:51
    Author     : Alexander
--%>

<%@page import="Modelo.Factura"%>
<%@page import="DAO.FacturaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet"></link>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    </head>
    <body>
        <jsp:include page="menu.jsp" flush="true"/>
        <div class="container">
            <div class="col-lg-6">
              <%
              FacturaDAO dao=new FacturaDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Factura p=(Factura)dao.list(id);
          %>
            <h1>Modificar Cabecera Factura</h1>
            <form action="ControladorFac">
                
                <input class="form-control" type="hidden" name="txtIdFac" value="<%= p.getId_fac()%>" ><br>
                Numero:<br>
                <input class="form-control" type="text" name="txtNumFac" value="<%= p.getNumero_fac()%>" ><br>
                Fecha: <br>
                <input class="form-control" type="text" name="txtFecha" value="<%= p.getFecha_fac()%>"><br>
                Ciudad: <br>
                <input class="form-control" type="text" name="txtIdCiu" value="<%= p.getId_ciu()%>"><br>
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="listarFac.jsp">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>