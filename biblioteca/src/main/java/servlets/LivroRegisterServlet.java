package servlets;


import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;
import models.Livro.Status;
import models.Product;
import repository.LivroRepository;

@WebServlet(name = "register", urlPatterns = {"/livros/register"})
public class LivroRegisterServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		RequestDispatcher dispatcher = req.getRequestDispatcher("/register-product.jsp");
		dispatcher.forward(req, resp);

	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("POST - CADASTRAR USUARIO");
		Livro livro = new Livro();
		String id = req.getParameter("field-id");

		String name = req.getParameter("field-name");

		String autor = req.getParameter("field-autor");

		String description = req.getParameter("field-description");
				
		Status status = Status.valueOf(req.getParameter("field-status"));
		
		String date = req.getParameter("field-date");
		
		livro.setId(Integer.valueOf(id));
		livro.setName(name);
		livro.setStatus(status);
		livro.setAutor(autor);
		livro.setDescription(description);
		livro.setDataLancamento(date);
		LivroRepository repository = new LivroRepository();
		if (repository.insert(livro)) {
			resp.sendRedirect("/Aula9/livros");
		} else {
			// enviar um atributo msg de erro
			System.out.println("fds");
			
		}

		

	}


}
