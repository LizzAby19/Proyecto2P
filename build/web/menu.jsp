<%-- 
    Document   : menu
    Created on : 14-ene-2023, 3:30:48
    Author     : Liiz
--%>

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
        <br><br><br>
        <div class="container"style="text-align: center">
            <h1>Proyecto 2do Parcial</h1>
            <ul>
                <li>Lizbeth Pumisacho</li>
                <li>Wilmer Alquinga</li>
                <li>Silvio Montalvo</li>
            </ul>
        </div>
    </body>
</html>
