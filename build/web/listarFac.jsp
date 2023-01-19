<%-- 
    Document   : listarFac
    Created on : 18/01/2023, 0:07:38
    Author     : Alexander
--%>

<%@page import="java.util.Iterator"%>
<%@page import="java.util.List"%>
<%@page import="Modelo.Factura"%>
<%@page import="Modelo.Factura_detalle"%>
<%@page import="DAO.FacturaDAO"%>
<%@page import="DAO.FacturaDetDAO"%>
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
        <h1 style="text-align: center">Cabecera Factura</h1>
        <div class="container">
            <a class="btn btn-success" href="addFac.jsp">Agregar Nueva Cabecera</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Numero</th>
                        <th class="text-center">Fecha</th>
                        <th class="text-center">Ciudad</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    FacturaDAO dao = new FacturaDAO();
                    List<Factura> list = dao.listar();
                    Iterator<Factura> iter = list.iterator();
                    Factura cli = null;
                    while (iter.hasNext()) {
                        cli = iter.next();

                %>

                <tbody>
                    <tr>
                        <td class="text-center"><%= cli.getNumero_fac()%></td>
                        <td class="text-center"><%= cli.getFecha_fac()%></td>
                        <td class="text-center"><%= cli.getId_ciu()%></td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorFac?accion=editar&id=<%= cli.getId_fac()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorFac?accion=eliminar&id=<%= cli.getId_fac()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <h1 style="text-align: center">Detalle Factura</h1>
        <div class="container">
            <a class="btn btn-success" href="addFacDet.jsp">Agregar Nuevo Detalle</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>

                        <th class="text-center">Articulo</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    FacturaDetDAO daoDet = new FacturaDetDAO();
                    List<Factura_detalle> listDet = daoDet.listar();
                    Iterator<Factura_detalle> iterDet = listDet.iterator();
                    Factura_detalle cliDet = null;
                    while (iterDet.hasNext()) {
                        cliDet = iterDet.next();

                %>

                <tbody>
                    <tr>
                        <td class="text-center"><%= cliDet.getId_art()%></td>
                        <td class="text-center"><%= cliDet.getCantidad_facdet()%></td>
                        <td class="text-center"><%= cliDet.getPrecio_facdet()%></td>

                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorFac?accion=editar&id=<%= cli.getId_fac()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorFac?accion=eliminar&id=<%= cli.getId_fac()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>
    </body>
</html>
