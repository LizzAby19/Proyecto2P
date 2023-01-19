<%-- 
    Document   : editDet
    Created on : 18-ene-2023, 12:55:30
    Author     : Liiz
--%>

<%@page import="Modelo.DetalleInv"%>
<%@page import="DAO.InventarioDDAO"%>
<%@page import="Modelo.Movimiento"%>
<%@page import="DAO.MovimientoDAO"%>
<%@page import="Modelo.Articulo"%>
<%@page import="DAO.ArticuloDAO"%>
<%@page import="java.util.ArrayList"%>
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
            <div class="container-fluid col-md-6">
                <%
                        InventarioDDAO dao = new InventarioDDAO();
                        int id = Integer.parseInt((String) request.getAttribute("idper"));
                        DetalleInv p = (DetalleInv) dao.list(id);
                    %>
                <h1>MODIFICAR Detalle Inventario</h1>
                <form action="ControladorDet">
                    <%
                        ArticuloDAO movdao1 = new ArticuloDAO();

                    %>
                    <input class="form-control" type="hidden" name="txtInv" value="<%= p.getId_detI() %>" ><br>
                    # Inventario:<br>
                    <input class="form-control" type="text" name="txtfecha" value="<%= p.getId_inv()%>" ><br>
                    

                    <br>Artículo<br>
                    <select name="txtArt" id="Movimiento" class="form-select">
                        <option >Seleccionar articulo .... </option>
                        <%  ArrayList<Articulo> lista1 = movdao1.mostrarArt();
                            for (Articulo elem : lista1) {

                                System.out.println(elem.getCodigo_Articulo());

                        %>
                        <option value="<%= elem.getCodigo_Articulo()%>"><%=elem.getNombre_Articulo()%></option>
                        <%

                            }
                        %>
                    </select>

                    <br>Cantidad: <br>
                    <input class="form-control" type="text" name="txtCant"  value="<%=p.getCantidad()%>">

                    <input  class="btn btn-primary mx-3" type="submit" name="accion" value="Actualizar">
                    <a href="inventarioT.jsp">Regresar</a>                  
                </form>
            </div>

        </div>

    </body>
</html>
