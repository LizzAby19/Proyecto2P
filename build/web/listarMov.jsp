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
                                    <li><a class="dropdown-item" href="/Proyecto2P/inventarioT.jsp">Compleja </a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/reporte.jsp">Reporte</a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">Facturacion</a>
                                <ul class="dropdown-menu">
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarCli.jsp">Cliente</a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarCiu.jsp">Ciudad</a></li>
                                    <li><a class="dropdown-item" href="/Proyecto2P/listarFac.jsp">Compleja </a></li>
                                </ul>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">CXC</a>
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
        <div class="container">
            <br><br>
            Server Port:
            <%= request.getServerPort()%><br>
            Server Name: 
            <%= request.getServerName()%><br>
            Host Name: 
            <%= java.net.InetAddress.getLocalHost().getHostName()%><br>
            Host Address: 
            <%= java.net.InetAddress.getLocalHost().getHostAddress()%><br>
            <br> <br>
        </div>
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
