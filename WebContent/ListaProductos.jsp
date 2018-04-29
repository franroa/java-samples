<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
    
    
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>

<Style type="text/css">

.cabecera{

	font-size:1.2em;

	font-weight:bold;
	
	color:#FFFFFF;
	
	background-color:#08088A;
	
}

.filas{

	text-align: center;
	
	background-color:#5882FA;

}

table{

	float:left;

}

#ContenedorBoton{

	margin-left: 1000px;

}

</Style>

</head>

<body>

	<table>
	
	<tr>
	
	<td class= "cabecera"> Codígo Artículo </td>
	
	<td class= "cabecera"> Sección </td>
	
	<td class= "cabecera"> Nombre Artículo </td>
	
	<td class= "cabecera"> Fecha </td>
	
	<td class= "cabecera"> Precio </td>
	
	<td class= "cabecera"> Importado </td>
	
	<td class= "cabecera"> País de Origen </td>
	
	<td class= "cabecera"> Acción </td>
	
	</tr>
	
	<c:forEach var="tempProd" items= "${LISTAPRODUCTOS}">
	
	<c:url var="linktemp" value="ControladorProductos">
	
		<c:param name="instruccion" value="cargar"></c:param>
		
		<c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
	
	</c:url>
	
	<c:url var="linktempEliminar" value="ControladorProductos">
	
	<!-- link para eliminar cada registro con su campo clave -->
	
		<c:param name="instruccion" value="eliminar"></c:param>
		
		<c:param name="CArticulo" value="${tempProd.cArt}"></c:param>
	
	</c:url>
	
	
	<tr>
	
	<td class= "filas">${tempProd.cArt}</td>
	
	<td class= "filas">${tempProd.seccion}</td>
	
	<td class= "filas">${tempProd.nArt}</td>
	
	<td class= "filas">${tempProd.precio}</td>
	
	<td class= "filas">${tempProd.fecha}</td>
	
	<td class= "filas">${tempProd.importado}</td>
	
	<td class= "filas">${tempProd.pOrig}</td>
		
	<td class= "filas"><a href="${linktemp}">Actualizar</a>&nbsp<a href="${linktempEliminar}">Eliminar</a></td>
		
	</tr>
	
	</c:forEach>
	
	</table>
	
	<div id="ContenedorBoton">
	
		<input type="button" value="Insertar Registro"  onclick="window.location.href='inserta_producto.jsp'"/>
	
</div>	
	
	
</body>

</html>