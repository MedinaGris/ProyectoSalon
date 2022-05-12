
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@page import="com.salon.service.UsuarioServiceImplement"%>
<%@page import="com.salon.service.UsuarioService"%>
<%@page import="com.salon.entity.UsuarioJPA"%>
<%@page import="java.util.List"%>

<!--
/**
 *
 * @author Griselda Medina Avendaño
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
-->
 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link rel="Stylesheet" href="resources/css/estiloRegistro.css">
        <title>Usuarios Registrados</title>
    </head>
    <body>

        <table border="1">
            <tr>
                <th>Id</th>
                <th>Contrase?a</th>
                <th>email</th>
                <th>Nombre</th>
                <th>Telefono</th>
                <th>Actualizar</th>
                <th>Eliminar</th>

            </tr>



            <% List<UsuarioJPA> lista = (List<UsuarioJPA>) request.getAttribute("usuarios");
            for (UsuarioJPA usuario : lista){ %>
            <tr>
                <td><%=usuario.getId()%></td>;
                <td><%= usuario.getContraseña()%></td>;
                <td><%= usuario.getEmail()%></td>;
                <td><%= usuario.getNombreUsuario()%></td>;
                <td><%= usuario.getTelefono()%></td>;


                <td><form action="/proyectoSalon/EditarUsuario">
                        <input  type="text" value="<%=usuario.getId()%>"  name="idUsuario" hidden=true>
                        <button>Actualizar usuario</button></form>
                </td>

                <td><form action="/proyectoSalon/EliminarUsuario">
                        <input  type="text" value="<%=usuario.getId()%>"  name="idUsuario" hidden=true>
                        <button>Eliminar usuario</button></form>
                </td>
              </tr>
             
                <%}%>
        </table>

    </body>
</html>