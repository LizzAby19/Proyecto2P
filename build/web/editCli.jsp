<%-- 
    Document   : newjspedit
    Created on : 14-ene-2023, 5:50:08
    Author     : Liiz
--%>

<%@page import="Modelo.Cliente"%>
<%@page import="DAO.ClienteDAO"%>
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
              ClienteDAO dao=new ClienteDAO();
              int id=Integer.parseInt((String)request.getAttribute("idper"));
              Cliente p=(Cliente)dao.list(id);
          %>
            <h1>Modificar Cliente</h1>
            <form action="ControladorCli">
                
                <input class="form-control" type="hidden" name="txtId" value="<%= p.getId_cli()%>" ><br>
                Ruc:<br>
                <input class="form-control" type="text" name="txtRuc" value="<%= p.getRuc_cli()%>" ><br>
                Nombre: <br>
                <input class="form-control" type="text" name="txtNom" value="<%= p.getNombre_cli()%>"><br>
                Direccion: <br>
                <input class="form-control" type="text" name="txtDir" value="<%= p.getDireccion_cli()%>"><br>
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="listarCli.jsp">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
