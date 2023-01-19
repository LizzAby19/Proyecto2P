<%-- 
    Document   : editInv
    Created on : 18-ene-2023, 3:07:44
    Author     : Liiz
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="Modelo.Movimiento"%>
<%@page import="DAO.MovimientoDAO"%>
<%@page import="Modelo.CabeceraInventario"%>
<%@page import="DAO.InventarioCDAO"%>
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
        <div class="container">
            <div class="col-lg-6">
                <%
                    InventarioCDAO dao = new InventarioCDAO();
                    int id = Integer.parseInt((String) request.getAttribute("idper"));
                    CabeceraInventario p = (CabeceraInventario) dao.list(id);
                %>
                <h1>Modificar INVENTARIO CABECERA</h1>
                <%
                    MovimientoDAO movdao = new MovimientoDAO();

                %>
                <form action="ControladorInvC">

                    <input class="form-control" type="hidden" name="txtInv" value="<%= p.getNumCabecera()%>" ><br>
                    Fecha:<br>
                    <input class="form-control" type="text" name="txtfecha" value="<%= p.getFecha()%>" ><br>
                    Movimiento: <br>
                    <select name="txtMovimiento" id="Movimiento" class="form-select">
                        <option value="">Seleccionar movimiento .... </option>
                        <%  ArrayList<Movimiento> lista = movdao.mostrarMov();
                            for (Movimiento elem : lista) {

                                System.out.println(elem.getCodigo());

                        %>
                        <option value="<%= elem.getCodigo()%>"><%=elem.getNombre()%></option>
                        <%

                            }
                        %>
                    </select>

                    <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                    <a href="inventarioT.jsp">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
