<%-- 
    Document   : listar
    Created on : 14-ene-2023, 5:50:24
    Author     : Liiz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Articulo"%>
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
        <jsp:include page="/menu.jsp" flush="true"/>
        <h1 style="text-align: center">Artículo</h1>
        <div class="container">
            <a class="btn btn-success" href="add.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">Stock</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ArticuloDAO dao = new ArticuloDAO();
                    List<Articulo> list = dao.listar();
                    Iterator<Articulo> iter = list.iterator();
                    Articulo art=null;
                    while(iter.hasNext()){
                        art = iter.next();
                    
                %>
                
                <tbody>
                    <tr>
                        <td class="text-center"><%= art.getCodigo_Articulo() %></td>
                        <td class="text-center"><%= art.getNombre_Articulo() %></td>
                        <td class="text-center"><%= art.getPrecio_Articulo() %></td>
                        <td class="text-center"><%= art.getStock_Articulo() %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorArt?accion=editar&id=<%= art.getCodigo_Articulo()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorArt?accion=eliminar&id=<%= art.getCodigo_Articulo() %>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
