package controller;

import java.io.IOException;
import java.util.ArrayList;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.DAO;
import model.JavaBeans;

// TODO: Auto-generated Javadoc
/**
 * The Class Controller.
 */
@WebServlet(urlPatterns = { "/main", "/insert", "/select", "/update", "/delete" })
public class Controller extends HttpServlet {
	
	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The dao. */
	DAO dao = new DAO();
	
	/** The filme. */
	JavaBeans filme = new JavaBeans();

	/**
	 * Instantiates a new controller.
	 */
	public Controller() {
		super();

	}

	/**
	 * Do get.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		if (action.equals("/main")) {
			filmes(request, response);
		} else if (action.equals("/insert")) {
			novoFilme(request, response);
		} else if (action.equals("/select")) {
			listarFilme(request, response);
		} else if (action.equals("/update")) {
			editarFilme(request, response);
		} else if (action.equals("/delete")) {
			removerFilme(request, response);
		} else {
			response.sendRedirect("index.html");
		}

	}

	/**
	 * Filmes.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void filmes(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList<JavaBeans> lista = dao.listarFilmes();
		request.setAttribute("filmes", lista);
		RequestDispatcher rd = request.getRequestDispatcher("catalogo.jsp");
		rd.forward(request, response);
	}

	/**
	 * Novo filme.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void novoFilme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		filme.setNome(request.getParameter("nome"));
		filme.setAno(request.getParameter("ano"));
		filme.setDescricao(request.getParameter("descricao"));
		dao.inserirFilme(filme);
		response.sendRedirect("main");
	}

	/**
	 * Listar filme.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void listarFilme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		filme.setId(id);
		dao.selecionarFilme(filme);
		request.setAttribute("id", filme.getId());
		request.setAttribute("nome", filme.getNome());
		request.setAttribute("ano", filme.getAno());
		request.setAttribute("descricao", filme.getDescricao());
		RequestDispatcher rd = request.getRequestDispatcher("editar.jsp");
		rd.forward(request, response);
	}

	/**
	 * Editar filme.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void editarFilme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		filme.setId(request.getParameter("id"));
		filme.setNome(request.getParameter("nome"));
		filme.setAno(request.getParameter("ano"));
		filme.setDescricao(request.getParameter("descricao"));
		dao.alterarFilme(filme);
		response.sendRedirect("main");
	}

	/**
	 * Remover filme.
	 *
	 * @param request the request
	 * @param response the response
	 * @throws ServletException the servlet exception
	 * @throws IOException Signals that an I/O exception has occurred.
	 */
	protected void removerFilme(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		filme.setId(id);
		dao.deletarFilme(filme);
		response.sendRedirect("main");
	}

}
