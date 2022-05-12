
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!--
/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
-->
 
<!DOCTYPE html>
<html>
    <head>
        <title>Inicia sesión</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="Stylesheet" href="resources/css/estiloRegistro.css">
    </head>
    <body>
        <main>
            <div id="login-form" >
            <h1>Bienvenido, favor de acceder</h1>
            <form action="/proyectoSalon/login">
                <input id="username-l" type="text" placeholder="Nombre de usurio" name="email"/>
                <input id="password-l" type="password" placeholder="Contraseña" name="contraseña"/>
                <input type="submit" value="Iniciar Sesion">
            </form>
        </div>
        <div id="buttons">
            <form action="/proyectoSalon/registro.jsp">
                <input type="submit" value="Registrar">
            </form>
        </div>
    </main>
</body>

<script src="resources/js/registro.js"></script>
</html>
