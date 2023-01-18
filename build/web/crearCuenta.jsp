<%-- 
    Document   : crearCuenta
    Created on : 18/01/2023, 17:17:17
    Author     : Usuario
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Forma de pago</title>
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
        
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Cuenta por cobrar</h1>
                <form action="ControladorCuenta">
                    Factura: <br>
                    <input class="form-control" type="text" name="txtIdFactura"><br>
                    Estado: <br>
                    <input class="form-control" type="text" name="txtEstado"><br>
                    Fecha <br>
                    <input class="form-control" type="text" name="txtFecha"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="listarCuenta.jsp">Regresar</a>
                </form>
            </div>
        </div>
    </body>
</html>
