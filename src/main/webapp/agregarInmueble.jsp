<%--
  Created by IntelliJ IDEA.
  User: Aspire3
  Date: 22-06-2023
  Time: 9:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" type="text/css" href="estilos.css">
    <title>Agregar Inmueble</title>
</head>
<body>
<h1 id="tituloEncabezado" class="encabezado">Agregar Inmueble</h1>
<br>
<form action="inmueble" method="post">
    <div class="centrar">
        <label class="texto">Codigo Inmueble:</label>
        <input name="cod_inmueble" type="number">
        <br>
        <label for="tipo" class="texto">Tipo de Construccion: </label>
        <select name="tipoConstruccion" id="tipo">
            <option value="madera">Madera</option>
            <option value="cemento">Cemento</option>
            <option value="otro">Otro</option>
        </select>
        <br>
        <label class="texto">Ciudad:</label>
        <input name="ciudad" type="text">
        <br>
        <label class="texto">Direccion:</label>
        <input name="direccion" type="text">
        <br>
        <label class="texto">Precio:</label>
        <input name="precio" type="number">
        <br>
        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<br>
<a class="centrar" href="index.jsp">Volver</a>
</body>
</html>
