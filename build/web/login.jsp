<%-- 
    Document   : login
    Created on : 26-feb-2020, 17:55:01
    Author     : Manue
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <%  String rspta="";
        if(request.getParameter("rspta")!=null){
            int r=Integer.parseInt(request.getParameter("rspta"));
            if(r==0){
                rspta="Error: datos incorrectos";
            }
        }
    %>
    <body>
    <center>
        <div class="container-fluid mt-4 col-6" >
            <div class="card " style="background:#C5D2F0 ">
                <div class="card-body">
                    <form class="form-sing" action="LoginController" method="POST">
                        <div class="form-group text-center">
                            <h3>LOGIN</h3><br>
                        </div>
                        <div class="form-group">
                            <br>
                            <label>Usuario:</label>
                            <input type="text" name="txtusuario" class="form-control mt-2" required>
                        </div>
                        <div class="form-group">
                            <br>
                            <label>Contraseña:</label>
                            <input type="password" name="txtclave" class="form-control mt-2"  required>
                        </div>
                        <br>
                       <center>
                            <input type="submit" class="btn btn-primary " name="btn-login" value="Ingresar">
                            <a  value="Registrarse" href="index.jsp" class="btn btn-secondary ">Registrarse</a>
                        </center>
                        <p style="color: red;"><%=rspta %></p>
                    </form>
                </div>
            </div>
        </div>
       <!-- <div class="container" style="margin-top: 80px;">
            
            <form method="post" action="/Login/LoginController">
                <div class="card" style="width: 30rem;">
                <div class="card-body">
                    <h2>Iniciar Sesion</h2>
                    <input type="text" name="txtusuario" class="form-control mt-2" placeholder="Ingrese Usuario" required>
                    <input type="password" name="txtclave" class="form-control mt-2" placeholder="Ingrese Clave" required>
                    <input type="submit" class="btn btn-primary btn-block mt-2" name="btn-login" value="Ingresar">
                    <p style="color: red;"><%=rspta %></p>
                </div>
            </div>
            </form>
        </div>-->
    </center>
</body>
</html>
