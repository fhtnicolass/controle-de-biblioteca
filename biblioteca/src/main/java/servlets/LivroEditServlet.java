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

import repository.ILivroRepository;
import repository.LivroRepository;

@MultipartConfig
@WebServlet("/edit")
public class LivroEditServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ILivroRepository repository = new LivroRepository();

		req.setCharacterEncoding("utf-8");
		
		Integer id = Integer.valueOf(req.getParameter("id"));

		Livro livro = repository.findById(id);

		req.setAttribute("livro", livro);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-product.jsp");
		dispatcher.forward(req, resp);

	}

	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		
		ILivroRepository repository = new LivroRepository();
		
		Integer id = Integer.valueOf(req.getParameter("field-id"));
		
		Livro livro = repository.findById(id);

		String name = req.getParameter("field-name");

		String autor = req.getParameter("field-autor");

		String description = req.getParameter("field-description");
		String date = req.getParameter("field-date");	
		
		if(date.length() > 10) { date = "";};
		String error = null;
		
		Status status = null;
		
		try {
			status = Status.valueOf(req.getParameter("status")); 
		} catch (Exception e) {
			// TODO Auto-generated catch bl
			error = "";
		}
	
		
		
		if(name != null || autor != null || description != null  || date.isBlank() == false  || error != null) {
		    livro.setName(name);
			livro.setStatus(status);
			livro.setAutor(autor);
			livro.setDescription(description);
			try {
				livro.setDataLancamento(date);
			} catch (Exception e) {
				req.setAttribute("error", "error");
				req.setAttribute("livro", livro);
				RequestDispatcher dispatcher = req.getRequestDispatcher("/edit-product.jsp");
				dispatcher.forward(req, resp);
			}
			
			if(repository.update(livro)) {
			   resp.sendRedirect("/biblioteca");
			}else {
				req.setAttribute("error", "error");
				resp.sendRedirect("/edit");
			}
			
		}else {
			req.setAttribute("error", "error");
			resp.sendRedirect("/edit");
		}
		
	}
		
	
}
