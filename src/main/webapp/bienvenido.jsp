<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import = "com.salon.entity.UsuarioJPA"%>
  
<!--
/**
 *
 * @author Griselda Medina Avenda?o
 * Creado: 9 Mayo 2022
 * Actualizado: 11 Mayo 20211
 */
-->
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
<link rel="Stylesheet" href="resources/css/estiloRegistro.css">
</head>
<body>	
<h1>Bienvenid@: "${usuario.nombreUsuario}" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" /></h1>


        <form action="/proyectoSalon/ListarUsuario">
            <button>Ver usuarios registrados</button>
	</form>

</body>
</html>