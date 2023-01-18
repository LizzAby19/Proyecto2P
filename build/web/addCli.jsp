<%-- 
    Document   : add
    Created on : 14-ene-2023, 5:50:03
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
        <jsp:include page="menu.jsp" flush="true"/>
        <div class="container">
            <div class="col-lg-6">
                <h1>Agregar Cliente</h1>
                <form action="ControladorCli">
                    Ruc: <br>
                    <input class="form-control" type="text" name="txtRuc"><br>
                    Nombre: <br>
                    <input class="form-control" type="text" name="txtNom"><br>
                    Direccion: <br>
                    <input class="form-control" type="text" name="txtDir"><br>
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="listar.jsp">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
