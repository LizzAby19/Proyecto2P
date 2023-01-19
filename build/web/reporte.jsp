<%-- 
    Document   : inventarioT
    Created on : 18-ene-2023, 2:50:20
    Author     : Liiz
--%>

<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="Controlador.conexion"%>
<%@page import="Modelo.Articulo"%>
<%@page import="DAO.ArticuloDAO"%>
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

            <h1 style="text-align: center">REPORTE</h1>

            <form class="form" style="padding-left: 400px; display: flex;" >
                <input class="form-control" type="text" name="txtbuscar">
                <input class="btn btn-secondary" type="submit" value="buscar">
            </form>

            <div class="container">

                <br><br>
                <table class="table table-bordered">
                    <thead>
                        <tr>
                            <th class="text-center">Art</th>
                            <th class="text-center">Stock</th>

                        </tr>
                    </thead>
                    <%            
                        ArticuloDAO dao1 = new ArticuloDAO();
                        List<Articulo> list1 = dao1.listar();
                        Iterator<Articulo> iter1 = list1.iterator();
                        Articulo art1 = null;
                        while (iter1.hasNext()) {
                            art1 = iter1.next();

                    %>

                    <tbody>
                        <tr>
                            <td class="text-center"><%= art1.getNombre_Articulo()%></td>
                            <td class="text-center"><%= art1.getStock_Articulo()%></td>
                        </tr>
                        <%}%>
                    </tbody>
                </table>
            </div>

    </body>
</html>
