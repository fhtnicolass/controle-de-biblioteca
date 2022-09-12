<%@page import="models.Livro"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="repository.LivroRepository"%>
<%@ page import="models.Livro, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Cadastro de livros | IFPR</title>

<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx"
	crossorigin="anonymous">
<link href="<%= request.getContextPath() %>/assets/css/style.css"
	rel="stylesheet" type="text/css" />

</head>
<body>
	<div class="container">

		<header>
			<div
				class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
				<a href="<%= request.getContextPath() %>"
					class="d-flex align-items-center text-dark text-decoration-none">
					<span class="fs-4">Cadastro de livros</span>
				</a>

				<nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
					<a class="me-3 py-2 text-dark text-decoration-none" href="#">Features</a>
					<a class="me-3 py-2 text-dark text-decoration-none" href="#">Enterprise</a>
					<a class="me-3 py-2 text-dark text-decoration-none" href="#">Support</a>
					<a class="py-2 text-dark text-decoration-none" href="#">Pricing</a>
				</nav>
			</div>

		</header>


		<% Livro livro = (Livro) request.getAttribute("livro"); %>

		<form action="<%= request.getContextPath() %>/edit"
			method="post" enctype="multipart/form-data">

			<div class="mb-3">
				<label for="id" class="form-label">#id</label> <input type="number"
					name="field-id" class="form-control" id="id"
					value="<%=livro.getId() %>" readonly>
			</div>

			<div class="mb-3">
				<label for="name" class="form-label">Product Name</label> <input
					type="text" name="field-name" class="form-control" id="name"
					value="<%=livro.getName() %>">
			</div>
			
			<div class="mb-3">
				<label for="name" class="form-label">Nome do autor:</label> <input
					type="text" name="field-autor" class="form-control" id="name"
					value="<%=livro.getAutor() %>">
			</div>

			<div class="mb-3">
				<label for="price" step='0.01' class="form-label">Data de
					Lançamento:</label> <input type="text" name="field-date"
					class="form-control" id="price"
					value="<%=livro.getDataLancamento() %>">
			</div>

			<div class="mb-3">
				<label for="description" class="form-label">Description</label>
				<textarea class="form-control" name="field-description"
					id="description" rows="3"><%= livro.getDescription() %></textarea>
			</div>
			
			<div class="form-outline mb-4">

				<label class="form-label" for="form3Example3cg">Altere o status do Livro: </label>

				<div class="form-check">
					<input type="radio" class="form-check-input" id="radio1"
						name="status" value="INDISPONIVEL"> <label
						class="form-check-label" for="radio1">INDISPONIVEL</label>
				</div>

				<div class="form-check">
					<input type="radio" class="form-check-input" id="radio2"
						name="status" value="DISPONIVEL" checked> <label
						class="form-check-label" for="radio2" >DISPONIVEL</label>
				</div>
				<div class="form-check">
					<input type="radio" class="form-check-input" id="radio3"
						name="status" value="EMPRESTADO"> <label
						class="form-check-label" for="radio3">EMPRESTADO</label>
				</div>
			</div>
			<div class="mb-3">
				<input class="btn btn-primary" type="submit" value="atualizar"
					name="submit">
			</div>

		</form>
		<% if (request.getAttribute("error") == "error") { %>
				 <td style = "color:red">ERRO: DATA INVALIDA<td>	
		<% }%>
	</div>
</body>
</html>