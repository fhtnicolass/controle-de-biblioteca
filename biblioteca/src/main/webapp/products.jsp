<%@page import="java.text.DecimalFormat"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@page import="repository.LivroRepository"%>
<%@page import="org.apache.catalina.startup.ClassLoaderFactory.Repository"%>
<%@page import="java.sql.DriverManager"%>
<%@page import="models.Livro, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Sistema de Biblioteca | IFPR</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	<link href="<%= request.getContextPath() %>/assets/css/style.css" rel="stylesheet" type="text/css" />
	
</head>
<body>
<div class="container">

<header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
      <a href="<%= request.getContextPath() %>" class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">Cadastro de Livros</span>
      </a>

      	
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h5 class="display-4 fw-normal">Tabela de Listagem</h5>
      <p class="fs-5 text-muted">
      	Aplicação para listagem de livros feito em Java. <br />
      	funcionalidades: cadastrar, listar, editar e excluir.
      </p>
    </div>
  </header>
  
  
   <a class="btn btn-primary" href="<%= request.getContextPath() %>/livros/register">novo livro</a>


	<% List<Livro> livros = (List<Livro>) request.getAttribute("livros"); %>

	<table class="table">
		<thead>
			<tr>
				<td>#id</td>
				<td>name</td>
				<td>autor</td>
				<td>descrição</td>
				<td>status</td>
				
			</tr>
		</thead>
		
		<tbody>
	
			<% for (Livro p : livros) { %>
			<tr>
				<td><%= p.getId()%></td>
				<td><%= p.getName()%></td>
				<td><%= p.getAutor()%></td>
				<td><%= p.getResumedDescription()%></td>
				
				<td><%= p.getStatus()%></td>
				<td><a href="<%= request.getContextPath() %>/livros/edit?id=<%= p.getId()%>">editar</a> | <a href="<%= request.getContextPath() %>/livros/delete?id=<%= p.getId()%>">excluir</a></td>
			</tr>
			<% } %>
		</tbody>

	</table>




</div>
</body>
</html>