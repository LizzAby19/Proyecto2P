<%-- 
    Document   : addFac
    Created on : 18/01/2023, 0:32:51
    Author     : Alexander
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
        <jsp:include page="menu.jsp" flush="true"/>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Detalle Factura</h1>
                <form action="ControladorFac">
                    Articulo: <br>
                    <input class="form-control" type="text" name="txtNumFac"><br>
                    Cantidad: <br>
                    <input class="form-control" type="text" name="txtFecha"><br>
                    Precio: <br>
                    <input class="form-control" type="text" name="txtIdCiu"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="listarFac.jsp">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
