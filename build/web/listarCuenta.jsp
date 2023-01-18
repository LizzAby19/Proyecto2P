<%-- 
    Document   : listarCuenta
    Created on : 18/01/2023, 17:17:02
    Author     : Usuario
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Cuenta"%>
<%@page import="DAO.CuentaDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Cuentas por cobrar</title>
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
                                    <li><a class="dropdown-item" href="/Proyecto2P/listar.jsp">Articulo</a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarMov.jsp">Tipo Movimiento</a></li>
                                    <li><a class="dropdown-item" href="">Compleja </a></li>
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
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Cuentas por cobrar</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarFormaPago.jsp">Forma de pago</a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarCobrador.jsp">Cobrador</a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarCuenta.jsp">Cuentas por cobrar </a></li>
                                    <li><a class="dropdown-item" href="">Reporte</a></li>
                                </ul>
                            </li>
                        </ul>
                    </div>
                </div>
            </nav>
        </div>
        
        <h1 style="text-align: center">Cuentas por cobrar</h1>
        <div class="container">
            <a class="btn btn-success" href="crearCuenta.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Factura</th>
                        <th class="text-center">Fecha</th>
                        <th class="text-center">Estado</th>
                    </tr>
                </thead>
                <%
                    CuentaDAO dao = new CuentaDAO();
                    List<Cuenta> list = dao.listar();
                    Iterator<Cuenta> iter = list.iterator();
                    Cuenta art=null;
                    while(iter.hasNext()){
                        art = iter.next();
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= art.getId()%></td>
                        <td class="text-center"><%= art.getIdFactura() %></td>
                        <td class="text-center"><%= art.getFecha() %></td>
                        <td class="text-center"><%= art.getEstado() %></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorCuenta?accion=editar&id=<%= art.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorCuenta?accion=eliminar&id=<%= art.getId()%>">Eliminar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
