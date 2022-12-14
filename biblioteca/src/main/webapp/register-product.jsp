<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@ page import="repository.LivroRepository"%>
<%@ page import="models.Livro, java.util.List"%>

<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<title>Cadastro de produtos | IFPR</title>
	
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-gH2yIJqKdNHPEq0n4Mqa/HGKIhSkIHeL5AyhkYV8i59U5AR6csBvApHHNl/vI1Bx" crossorigin="anonymous">
	
</head>
<body>
<div class="container">

<header>
    <div class="d-flex flex-column flex-md-row align-items-center pb-3 m-4 border-bottom">
            <a href="<%= request.getContextPath() %>" class="d-flex align-items-center text-dark text-decoration-none">
        <span class="fs-4">Edição de produtos</span>
      </a>
      

      <nav class="d-inline-flex mt-2 mt-md-0 ms-md-auto">
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Features</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Enterprise</a>
        <a class="me-3 py-2 text-dark text-decoration-none" href="#">Support</a>
        <a class="py-2 text-dark text-decoration-none" href="#">Pricing</a>
      </nav>
    </div>

    <div class="pricing-header p-3 pb-md-4 mx-auto text-center">
      <h1 class="display-4 fw-normal">Tabela de Preços</h1>
      <p class="fs-5 text-muted">Quickly build an effective pricing table for your potential customers with this Bootstrap example. It’s built with default Bootstrap components and utilities with little customization.</p>
    </div>
  </header>


	<form action="<%= request.getContextPath() %>/register" method="post">
	
		<div class="mb-3">
		  <label for="name" class="form-label">Nome do Livro:</label>
		  <input type="text" name="field-name" class="form-control" id="name" >
		</div>
		
		<div class="mb-3">
		  <label for="price" step='0.01' class="form-label">Autor do Livro:</label>
		  <input type="text" name="field-autor" class="form-control" id="price" >
		</div>
		
		<div class="mb-3">
		  <label for="description" class="form-label">Sinopse:</label>
		  <textarea class="form-control" name="field-description" id="description" rows="3"></textarea>
		</div>
		
		<div class="form-outline mb-4">
											   <input type="date" id="form3Example4cdg" class="form-control form-control-lg" name = "field-date"/> 
												
												<label
												class="form-label" for="form3Example4cdg">Data de Lançamento
												</label>
		</div>
		
		<div class="mb-3">
			<input class="btn btn-primary" type="submit" value="registrar" name="submit">
		</div>
	
	</form>
	
	<% if(request.getAttribute("error") == "dberror" || request.getAttribute("error") == "nullerror"){ %>
	
		  <p style="color: red"> <%= request.getAttribute("erro").toString() %></p> 
		  
	<%  } %>
  	
  	
</div>
</body>
</html>