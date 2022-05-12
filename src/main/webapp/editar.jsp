<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!--
/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
-->
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--

-->
<html>
    <head>
        <title>Actualizar Usuario</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="Stylesheet" href="resources/css/estiloRegistro.css">
    </head>
    <body>
        <main>

            <div id="register-form">
                <h1>Modificacion de usuario</h1>
                <form action="/proyectoSalon/EditarUsuario" method="post">
                 
                    <input id="iduser-r" type="text" value="${usuario.id}" name="idUsuario" />
                    <small id="warning-usernameempty">id Usuario esta vacío</small>
                    
                    <input id="username-r" type="text" value="${usuario.nombreUsuario}" name="nombreUsuario"/>
                    <small id="warning-usernameempty">Nombre de usuario esta vacío</small>
                    
                       <input id="email-r" type="email" value="${usuario.email}" name="email" />
                    <small id="warning-emailempty">Email esta vacío</small>
                    
                    <input id="telefono" type="text" value="${usuario.telefono}" name="telefono" />
                    <small id="warning-emailempty">Email esta vacío</small>
                    
                    <input id="password-r" type="password" value="${usuario.contraseña}" name="password"/>
                    <small id="warning-passlength">Contraseña debe tener al meos 8 dígitos</small>
                    
                   
                    <input type="submit" value="Editar">
                </form>
                <form action="/proyectoSalon/login.jsp">
                    <input type="submit" value="Cancelar">
                </form>
            </div>
           
        </main>
  
    </body>
</html>






