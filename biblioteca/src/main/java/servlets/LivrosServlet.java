package servlets;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;
import repository.LivroRepository;

@WebServlet(name = "livros" ,urlPatterns = {"/livros"})
public class LivrosServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		LivroRepository repository = new LivroRepository();
		
		List<Livro> livros = new ArrayList<>();
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("products.jsp");

		livros = repository.findAll();
		
		if (livros.isEmpty()) {
			req.setAttribute("erro", "nullerror");
			dispatcher.forward(req, resp);
		} else {
			req.setAttribute("livros", livros);
			dispatcher.forward(req, resp);
		}
		
		
		
		
	}

}
