<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Editar</title>
<link rel="icon" href="imagens/movie.jpg">
<link rel="stylesheet" href="style1.css">
</head>
<body>
	<h1>Editar filme</h1>
	<form name="frmFilme" action="update">
		<table>
			<tr>
				<td><input type="text" name="id" id="caixa3" readonly
					value="<%out.print(request.getAttribute("id"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="nome" class="Caixa1"
					value="<%out.print(request.getAttribute("nome"));%>"></td>
			</tr>
			<tr>
				<td><input type="text" name="ano" class="Caixa2"
					value="<%out.print(request.getAttribute("ano"));%>"></td>
			</tr>

			<tr>
				<td><textarea rows="7" cols="30" name="descricao"
						class="Caixa1">
						<%
						out.print(request.getAttribute("descricao"));
						%>
					</textarea>
			</tr>
		</table>
		<input type="button" value="Salvar" class="Botao1" onclick="validar()">
		<a href="main" class="Botao2">voltar</a>
	</form>


	<script src="scripts/validador.js"></script>
</body>
</html>