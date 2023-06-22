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
    <title>Agregar Vendedor</title>
</head>
<body>
<h1 id="tituloEncabezado" class="encabezado">Agregar Vendedor</h1>
<br>
<form action="vendedor" method="post">
    <div class="centrar">
        <label class="texto">Nombre:</label>
        <input name="nombre" type="text">
        <br>
        <label class="texto">RUT: </label>
        <input name="rut" type="text">
        <br>
        <label class="texto">Direccion:</label>
        <input name="direccion" type="text">
        <br>
        <label class="texto">Titulo Profesional:</label>
        <input name="tituloProfesional" type="text">
        <br>
        <label for="estado" class="texto">Estado Civil:</label>
        <select name="estadoCivil" id="estado">
            <option value="soltero">Soltero</option>
            <option value="casado">Casado</option>
            <option value="viudo">Viudo</option>
        </select>
        <br><br>
        <input type="submit" value="Enviar" class="boton">
    </div>
</form>
<br>
<a class="centrar" href="index.jsp">Volver</a>
</body>
</html>
