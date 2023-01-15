<%-- 
    Document   : newjspedit
    Created on : 14-ene-2023, 5:50:08
    Author     : Liiz
--%>

<%@page import="Modelo.Articulo"%>
<%@page import="DAO.ArticuloDAO"%>
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
              ArticuloDAO dao=new ArticuloDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Articulo p=(Articulo)dao.list(id);
          %>
            <h1>Modificar Articulo</h1>
            <form action="ControladorArt">
                
                <input class="form-control" type="hidden" name="txtId" value="<%= p.getCodigo_Articulo() %>" ><br>
                Nombre:<br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre_Articulo() %>" ><br>
                Precio: <br>
                <input class="form-control" type="text" name="txtPrec" value="<%= p.getPrecio_Articulo() %>"><br>
                Stock: <br>
                <input class="form-control" type="text" name="txtStock" value="<%= p.getStock_Articulo() %>"><br>
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="listar.jsp">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
