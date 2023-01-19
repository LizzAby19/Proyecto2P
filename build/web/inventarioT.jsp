<%-- 
    Document   : inventarioT
    Created on : 18-ene-2023, 2:50:20
    Author     : Liiz
--%>

<%@page import="Modelo.DetalleInv"%>
<%@page import="DAO.InventarioDDAO"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.CabeceraInventario"%>
<%@page import="DAO.InventarioCDAO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"/>
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
        <h1 style="text-align: center">Cabecera Inventario</h1>
        <div class="container">
            <a class="btn btn-success" href="inventario.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Id</th>
                        <th class="text-center">Fecha</th>
                        <th class="text-center">Movimiento</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    InventarioCDAO dao = new InventarioCDAO();
                    List<CabeceraInventario> list = dao.listar();
                    Iterator<CabeceraInventario> iter = list.iterator();
                    CabeceraInventario art = null;
                    while (iter.hasNext()) {
                        art = iter.next();

                %>

                <tbody>
                    <tr>
                        <td class="text-center"><%= art.getNumCabecera()%></td>
                        <td class="text-center"><%= art.getFecha()%></td>
                        <td class="text-center"><%= art.getMovimiento()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorInvC?accion=editar&id=<%= art.getNumCabecera()%>">Editar</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

        <h1 style="text-align: center">Detalle Inventario</h1>
        <div class="container">
            <a class="btn btn-success" href="inventarioD.jsp">Agregar Nuevo</a>
            <br><br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">Det</th>

                        <th class="text-center"># Inventario</th>
                        <th class="text-center">Art</th>
                        <th class="text-center">Cantidad</th>
                        <th class="text-center">Precio</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    InventarioDDAO dao1 = new InventarioDDAO();
                    List<DetalleInv> list1 = dao1.listar();
                    Iterator<DetalleInv> iter1 = list1.iterator();
                    DetalleInv art1 = null;
                    while (iter1.hasNext()) {
                        art1 = iter1.next();

                %>

                <tbody>
                    <tr>
                        <td class="text-center"><%= art1.getId_detI()%></td>
                        <td class="text-center"><%= art1.getId_inv()%></td>
                        <td class="text-center"><%= art1.getId_art()%></td>
                        <td class="text-center"><%= art1.getCantidad()%></td>
                        <td class="text-center"><%= art1.getPrecio()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="ControladorDet?accion=editar&id=<%= art1.getId_detI()%>">Editar</a>
                            <a class="btn btn-danger" href="ControladorDet?accion=eliminar&id=<%= art1.getId_detI()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>
        </div>

    </body>
</html>
