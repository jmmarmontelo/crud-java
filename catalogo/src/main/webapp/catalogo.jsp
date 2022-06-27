<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="model.JavaBeans"%>
<%@ page import="java.util.ArrayList"%>
<%
ArrayList<JavaBeans> lista = (ArrayList<JavaBeans>) request.getAttribute("filmes");
%>
<!DOCTYPE html>
<html lang="pt-br">
<link rel="icon" href="imagens/movie.jpg">
<link rel="stylesheet" href="style1.css">
<head>
<meta charset="UTF-8">
<title>Filmes</title>
</head>
<body>
	<h1>Lista de Filmes</h1>
	<a href="novo.html" class="Botao1">Adicionar Filme</a>

	<table id="tabela">
		<thead>
			<tr>
				<th>id</th>
				<th>Nome</th>
				<th>Ano</th>
				<th>Descricao</th>
				<th>Opcoes</th>
			</tr>
		</thead>
		<tbody>
			<%
			for (int i = 0; i < lista.size(); i++) {
			%>
			<tr>
				<td><%=lista.get(i).getId()%></td>
				<td><%=lista.get(i).getNome()%></td>
				<td><%=lista.get(i).getAno()%></td>
				<td><textarea rows="7" cols="20" readonly="readonly"
						class="Caixa1"><%=lista.get(i).getDescricao()%></textarea></td>
				<td><a href="select?id=<%=lista.get(i).getId()%>"
					class="Botao1">Editar</a> <a
					href="javascript:confirmar(<%=lista.get(i).getId()%>)"
					class="Botao2">Excluir</a></td>
			</tr>
			<%
			}
			%>
		</tbody>
	</table>
	<script src="scripts/confirmador.js"></script>
</body>
</html>