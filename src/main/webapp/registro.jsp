<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="Stylesheet" href="resources/css/estiloRegistro.css">
    </head>
    <body>
        <main>

            <div id="register-form">
                <h1>Bienvenido, favor de registrarse</h1>
                <form action="/proyectoSalon/CrearUsuario">
                 
                      <input id="iduser-r" type="text" placeholder="Id Usuario" name="idUsuario"/>
                    <small id="warning-usernameempty">id Usuario esta vacío</small>
                    
                    <input id="username-r" type="text" placeholder="Nombre de usuario" name="nombreUsuario"/>
                    <small id="warning-usernameempty">Nombre de usuario esta vacío</small>
                    
                       <input id="email-r" type="email" placeholder="Email" name="email" />
                    <small id="warning-emailempty">Email esta vacío</small>
                    
                    <input id="telefono" type="text" placeholder="Telefono" name="telefono" />
                    <small id="warning-emailempty">Email esta vacío</small>
                    
                    <input id="password-r" type="password" placeholder="Contraseña" name="password"/>
                    <small id="warning-passlength">Contraseña debe tener al meos 8 dígitos</small>
                    
                   
                    <input type="submit" value="Registrar">
                </form>
                <form action="/proyectoSalon/login.jsp">
                    <input type="submit" value="Cancelar">
                </form>
            </div>
           
        </main>
  
    </body>
</html>











     