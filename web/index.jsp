<%-- 
    Document   : login
    Created on : 14-ene-2023, 0:29:42
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
        <div class="container-fluid mt-4 col-6" >
            <div class="card " style="background:#C5D2F0 ">
                <div class="card-body">
                    <form class="form-sing" action="UsuarioS" method="POST">
                        <div class="form-group text-center">
                            <h3>REGISTRATE</h3><br>
                        </div>
                        <div class="form-group">
                            <br>
                            <label>Nuevo Usuario:</label>
                            <input type="text" name="txtuser" class="form-control">
                        </div>
                        <div class="form-group">
                            <br>
                            <label>Nueva Contraseña:</label>
                            <input type="password" name="txtpass" class="form-control">
                        </div>
                        <br>
                        <center>
                            <input type="submit" name="accionR" value="Registrarse" class="btn btn-primary">
                            <a href="login.jsp" class="btn btn-success ">Regresar</a>
                        </center>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>