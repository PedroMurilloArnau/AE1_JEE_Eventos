package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import modelo.beans.Evento;
import modelo.daos.EventoDaolmpl;
import modelo.daos.IntEventoDao;

/**
 * Implementa el inicio de nuestra página principal.
 * 
 * */
@WebServlet(description = "Trabaja con la página de inicio", urlPatterns = { "/inicio" })
public class HomeController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public HomeController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * Servlet#init(ServletConfig) Mediante el inint podemos realizar funciones para checkear
	 * el inicio de la sesion
	 * 
	 */
	public void init(ServletConfig config) throws ServletException {
		//Creo un init por si fuera necesario.
	}

	/**
	 * Con Nuestro método service crearemos la funcionalidad denuestro servlet.
	 * En nuestro caso lo utilizaremos para crear la lista de eventos,
	 * tanto de eventos activos como no activos. Y redigiremos los diferentes
	 * hilos a nuestro jsp "index.jsp"
	 * 
	 * 
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Creamos nuestra lista con una llamada al interface y mediante el método de nuestra lista recogemos todos los eventos.
		IntEventoDao ievnt = new EventoDaolmpl();
		List<Evento> lista = ievnt.findAll();
		
		//Generamos las propiedades de nuestro atributo "request" la lista y como se llamara la petición.
		request.setAttribute("listaeventos", lista);
		
		
		/*transferimos las peticiones del servlet HomeController a inex.jsp
		mediante el metodo getRequestDispatcher*/
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}

}
