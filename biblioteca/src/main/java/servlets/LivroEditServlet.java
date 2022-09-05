package servlets;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import models.Livro;
import models.Livro.Status;
import models.Product;
import repository.ILivroRepository;
import repository.LivroRepository;

@MultipartConfig
@WebServlet("/livros/edit")
public class LivroEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		ILivroRepository repository = new LivroRepository();

		req.setCharacterEncoding("utf-8");

		if (req.getParameter("id") != null) {

			Integer id = Integer.valueOf(req.getParameter("id"));

			Livro livro = repository.findById(id);

			req.setAttribute("livro", livro);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-product.jsp");
			dispatcher.forward(req, resp);

		} else {

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
			repository.update(livro);

			RequestDispatcher dispatcher = req.getRequestDispatcher("/products");
			dispatcher.forward(req, resp);

		}
	}
}
