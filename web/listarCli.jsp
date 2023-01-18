<%-- 
    Document   : listar
    Created on : 14-ene-2023, 5:50:24
    Author     : Liiz
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
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

        <div id="menu">
            <nav class="navbar navbar-expand-sm bg-dark navbar-dark">
                <div class="col-9"><h3 style="color: #fff">Proyecto 2 Parcial</h3></div>
                <div class="container-fluid col-3">
                    <div class="collapse navbar-collapse" id="collapsibleNavbar">
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Inventario</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="http://localhost:8080/Proyecto2P/listar.jsp">Articulo</a></li>
                                    <li><a class="dropdown-item" href="http://localhost:8080/Proyecto2P/listarMov.jsp">Tipo Movimiento</a></li>
                                    <li><a class="dropdown-item" href="">Compleja </a></li>
                                    <li><a class="dropdown-item" href="">Reporte</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Facturacion</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="http://localhost:8080/Proyecto2P/listarCli.jsp">Cliente</a></li>
                                    <li><a class="dropdown-item" href="http://localhost:8080/Proyecto2P/listarCiu.jsp">Ciudad</a></li>
                                    <li><a class="dropdown-item" href="http://localhost:8080/Proyecto2P/listarFac.jsp">Compleja </a></li>
                                    <li><a class="dropdown-item" href="">Reporte</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Inventario</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="">Articulo</a></li>
                                    <li><a class="dropdown-item" href="">Tipo Movimiento</a></li>
                                    <li><a class="dropdown-item" href="">Compleja </a></li>
                                    <li><a class="dropdown-item" href="">Reporte</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        <h1 style="text-align: center">Cliente</h1>
        <div class="container">
            <a class="btn btn-success" href="addCli.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Ruc</th>
                        <th class="text-center">Nombre</th>
                        <th class="text-center">Direccion</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    ClienteDAO dao = new ClienteDAO();
                    List<Cliente> list = dao.listar();
                    Iterator<Cliente> iter = list.iterator();
                    Cliente cli = null;
                    while (iter.hasNext()) {
                        cli = iter.next();

                %>

                <tbody>
                    <tr>
                         <td class="text-center"><%= cli.getRuc_cli()%></td>
                          <td class="text-center"><%= cli.getNombre_cli()%></td>
                            <td class="text-center"><%= cli.getDireccion_cli()%></td>
                       
                       
                       
                      
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorCli?accion=editar&id=<%= cli.getId_cli()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorCli?accion=eliminar&id=<%= cli.getId_cli()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
