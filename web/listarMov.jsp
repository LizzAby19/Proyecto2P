<%-- 
    Document   : listarMov
    Created on : 14-ene-2023, 15:33:42
    Author     : Liiz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Movimiento"%>
<%@page import="DAO.MovimientoDAO"%>
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
        <jsp:include page="/menu.jsp" flush="true"/>
        <h1 style="text-align: center">MOVIMIENTO</h1>
        <div class="container">
            <a class="btn btn-success" href="addMov.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Signo</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    MovimientoDAO dao = new MovimientoDAO();
                    List<Movimiento> list = dao.listar();
                    Iterator<Movimiento> iter = list.iterator();
                    Movimiento art=null;
                    while(iter.hasNext()){
                        art = iter.next();
                    
                %>
                
                <tbody>
                    <tr>
                        <td class="text-center"><%= art.getCodigo() %></td>
                        <td class="text-center"><%= art.getNombre() %></td>
                        <td class="text-center"><%= art.getSigno() %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorMov?accion=editar&id=<%= art.getCodigo() %>">Editar</a>
                            <a class="btn btn-danger" href="ControladorMov?accion=eliminar&id=<%= art.getCodigo() %>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
