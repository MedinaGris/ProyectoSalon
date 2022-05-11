<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
  <%@ page import = "com.salon.entity.UsuarioJPA"%>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel="Stylesheet" href="resources/css/estiloRegistro.css">
</head>
<body>	
<h1>Bienvenido: "${usuario.nombreUsuario}" &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<fmt:formatDate value="${today}" pattern="yyyy-MM-dd" />.</h1>


        <form action="/proyectoSalon/registrados.jsp">
            <button>Ver usuarios registrados</button>
	</form>

</body>
</html>