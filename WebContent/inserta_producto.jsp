<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

<h1> Inserta Registro</h1>

<form name="form1" method="get" action="ControladorProductos">

<input type="hidden" name="instruccion" value="insertarBBDD">

	<table>
	
	<tr>
	
		<td width=27%>Código Artículo</td>
		
		<td width=73%><label for="CArt"></label>
		
		<input type="text" name="CArt" id="CArt"></td>
		
	</tr>
	
	<tr>
	
		<td>Sección</td>
		
		<td><label for="seccion"></label>
		
		<input type="text" name="seccion" id="seccion"></td>
		
	</tr>
	
	
	
	<tr>
	
		<td>Nombre Artículo</td>
		
		<td><label for="NArt"></label>
		
		<input type="text" name="NArt" id="NArt"></td>
		
	</tr>
	
	<tr>
	
		<td>Fecha</td>
		
		<td><label for="fecha"></label>
		
		<input type="text" name="fecha" id="fecha"></td>
		
	</tr>
	
	<tr>
	
		<td>Precio</td>
		
		<td><label for="precio"></label>
		
		<input type="text" name="precio" id="precio"></td>
		
	</tr>
	
	<tr>
	
		<td>Importado</td>
		
		<td><label for="importado"></label>
		
		<input type="text" name="importado" id="importado"></td>
		
	</tr>
	
	<tr>
	
		<td>País de origen</td>
		
		<td><label for="POrig"></label>
		
		<input type="text" name="POrig" id="POrig"></td>
		
	</tr>
	
	<tr>
	
	<td><input type="submit" name="envio" id="envio" value="Enviar"></td>
	
	<td><input type="reset" name="borrar" id="borrar" value="Restablecer"></td>
	
	</tr>
			
	</table>

</form>

</body>
</html>