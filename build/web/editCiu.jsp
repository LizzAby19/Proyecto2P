<%-- 
    Document   : editMov
    Created on : 14-ene-2023, 15:33:28
    Author     : Liiz
--%>

<%@page import="DAO.CiudadDAO"%>
<%@page import="Modelo.Ciudad"%>
<%@page import="DAO.CiudadDAO"%>
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
              CiudadDAO dao=new CiudadDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Ciudad p=(Ciudad)dao.list(id);
          %>
            <h1>Modificar Ciudad</h1>
            <form action="ControladorCiu">
                
                <input class="form-control" type="hidden" name="txtId" value="<%= p.getId_ciu()%>" ><br>
                Codigo<br>
                <input class="form-control" type="text" name="txtCod" value="<%= p.getCodigo_ciu()%>" ><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre_ciu()%>"><br>
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="listarCiu.jsp">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
