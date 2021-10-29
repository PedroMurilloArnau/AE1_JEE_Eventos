package controller;

import java.io.IOException;
import java.util.ArrayList;
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
 * Servlet implementation class GestionEventos
 */
@WebServlet(description = "Para las tareas de los eventos", urlPatterns = { "/gestion" })
public class GestionEventos extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GestionEventos() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * En nuestro caso al iniciar el objeto, creamos un mensaje por consola.
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		//Este metodo llama cada vez que iniciemos el servlet.
		System.out.println("Entrando en init solo una vez");
	}

	/**En este caso nuestro metodo service controlara y administrar las diferentes peticiones.
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Entrando en un hilo ");
		
		//Creamos una variable "opcion" que recogera el atributo request de las opciones que se le envian al Servlet.
		String opcion = request.getParameter("opcion");
		
		/*A su vez creamos un declaración "Switch / case" para redirigir las diferentes opciones de los diferentes casos.
		 * cada uno de loscasos llamara a un método determinado.
		 */
		switch(opcion) {
		case "activos":
			procActivos( request,  response);
			break;
		case "alta":
			procalta( request,  response);
			break;
		case "editar":
			proceditar( request,  response);
			break;
		case "eliminar":
			proceliminar( request,  response);
			break;
		case "cancelar":
			procCancelar( request,  response);
			break;
		default:
			System.out.println("opcion incorrecta : " + opcion);
		}
		}
	/**
	 * Mediante el método "procActivos" podremos administrar la lista de eventos para conseguir
	 * una nueva lista en la que solo aparezcan los eventos activos.
	 * 
	 * Finalemente la redirigimos la nueva lista al "index.jsp".
	 * 
	 * 
	 * @author Pedro Murillo
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procActivos(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Como hemos visto anteriormente creamos nuestra lista.
		IntEventoDao ievnt = new EventoDaolmpl();
		List<Evento> lista = ievnt.findAll();
		
		//Mediante el loop "for" recorremos los diferentes eventos, eliminando los que no son activos. 
		for(int i=1;i< lista.size();++i) {
			Evento evento = ievnt.findById(i);
			if(evento.getEstado()!="Activo") {
				ievnt.eliminarEvento(i);
			}
		}
		
		//Recorremos denuevo la lista.
		lista = ievnt.findAll();
		request.setAttribute("mensaje","LISTA DE ACTIVOS:");
	
		request.setAttribute("listaeventos", lista);
		
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * Mediante el siguiente método daramos de alta un objeto y devolvemos la lista.
	 * 
	 * Primero recogemos los atributos de nuestro nuevo objeto "evento". Mediante request.geAttribute.
	 * Luego si no exista la lista creamos una nueva.
	 * Creamos el nuevo evento y le pasamos los atributos con su valor.
	 * Añadimos nuestro elemnto a a la lista.
	 * Posteriorme pasamos el control del servlet a "index.jsp" pasandole la lista.
	 * 
	 * @author Pedro Murillo
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procalta(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Creamos con el metodos del interface una nueva lista.
		IntEventoDao ievnt = new EventoDaolmpl();
		
		//La lista recogera los atributos que se le envíen mediante el metod getAttribute, almacenandolos en "listaeventos"
		List<Evento> lista = (List<Evento>)request.getAttribute("listaeventos");
		
		//Cargamos la lsita que tenemos guardada mediante el metodo findALL.
		lista = ievnt.findAll();
		
		//Si la lista estuviera vacia crearíamos una nueva lista con el método if.
		if (lista == null) {
			lista = new ArrayList<Evento>();
		}
		
		//Creamos un nuevo objeto de tipo evento donde vamos a almacenar características de los parámetros.
		Evento evento = new Evento();
		
		//El id al ser único y en nuestro caso asociado a la llegada de un nuevo objeto, lo agregamos sumando al "size" de la lista + 1.
		evento.setIdevento(lista.size()+1);
		
		//Por defecto nuestro Objeto tendrá como estado "Activo".
		evento.setEstado("Activo");
		
		/*Indexamos la dupla de atributos con su valor correspondiente. Efectuo el cambio de tipo de atributos donde
		corresponda ya que el atributo nos llega al constructor mediante el request.getParameter de tipo String.
		*/
		evento.setNombre(request.getParameter("nombre"));
		evento.setAforomaximo(Integer.parseInt(request.getParameter("aforomaximo")));
		evento.setDescripcion(request.getParameter("descripcion"));
		evento.setDestacado(request.getParameter("destacado"));
		evento.setFechainicio(request.getParameter("fechainicio"));
		evento.setPrecio(Double.parseDouble(request.getParameter("precio")));
		evento.setDuracion(Integer.parseInt(request.getParameter("duracion")));
		evento.setMinimoasistencia(Integer.parseInt(request.getParameter("minimoasistencia")));
		evento.setIdtipo(Integer.parseInt(request.getParameter("idtipo")));
		evento.setDireccion(request.getParameter("direccion"));
		
		//Agregamos el objeto nuevo a la lista.
		lista.add(evento);
		
		//pasamos los atributos de "lsitaeventos" de nuestro arraylist "lista".
		request.setAttribute("listaeventos", lista);
		
		//Pasamos el control desde nuestro servlet al jsp "index.jsp".
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * Mediante el siguiente método mostraremos un evento en un nuevo jsp "productosEditados.jsp".
	 * 
	 * Primero recogemos el atributos de nuestro objeto mediante su "id".
	 * Hacemos una llamada a la lista mediante el interface y invocamos el metod "findById()"
	 * para encontrar el Evento. 
	 * Finalemente pasamos el control del servlet a "productosEditados.jsp" pasandole el "Evento".
	 * 
	 * @author Pedro Murillo
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void proceditar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Recogemos la dupla de atributos con su valor y mediante el metodo Integer.parseInt lo transformamos en un entero.		
		int id = Integer.parseInt(request.getParameter("id"));
			
			//Mediante el interfaz creamos una nueva lista.
			IntEventoDao ievnt = new EventoDaolmpl();
			
			//Mediante el metodo de buscar por su Id buscamos el objeto de nuestra lista.
			Evento evento = ievnt.findById(id);
			
			//Pasamos los atributos de nuestro objeto obtenido por su id.
			request.setAttribute("evento", evento);
			
			//Pasamos totalmente el control desde nuestro servlet al jsp "productosEditados.jsp".
			request.getRequestDispatcher("productosEditados.jsp").forward(request, response);
	}
	
	/**
	 * Mediante el siguiente método eliminaremos un objeto "evento" y luego mostraremos la lista
	 * resultante en el jsp "index.jsp".
	 * 
	 * Primero recogemos el atributos de nuestro objeto mediante su "id".
	 * Hacemos una llamada a la lista mediante el interface y invocamos el metod "findAll()"
	 * para recoger todos los eventos de la lista.
	 * Invocaremos el método del interfaz "eliminarvento()"para eliminar nuestro evento identificandolo
	 * mediante su "id". 
	 * Finalemente pasamos el control del servlet a "index.jsp" pasandole la lista.
	 * 
	 * @author Pedro Murillo
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void proceliminar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Obtengo el valor del Id mediante una transformacion por Intger.parseInt
		int id = Integer.parseInt(request.getParameter("id"));
		
		//Creamos una nueva nueva instancia a nuestra lista de Eventos y despleagamos toda la lista.
		IntEventoDao ievnt = new EventoDaolmpl();
		List<Evento> lista = ievnt.findAll();
		
		//Con el metodo del interface "eliminarEvento" vamos a eliminar el elemento.
		ievnt.eliminarEvento(id);
		
		//Construimos la lista de nuevo.
		lista = ievnt.findAll();
		
		//Pasamos de nuevo el request y el response a "index.jsp".
		request.setAttribute("listaeventos", lista);
		
		//Pasamos un mensaje a "mensaje".
		request.setAttribute("mensaje","La lista queda así tras eliminar un elemento");
		
		//Pasamos totalmente el control desde nuestro servlet al jsp "index.jsp"
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	
	/**
	 * Mediante el siguiente método cambiaremos el atributo de un objeto "evento" de tipo "Estedo" a "Cancelado" y luego mostraremos la lista
	 * resultante en el jsp "index.jsp". 
	 * Primero recogemos el atributos de nuestro objeto mediante su "id".
	 * Invocaremos el método del interfaz "findAll()" para crear la lista, invocamos el método "findById() mediante su "Id" identificamos el objeto
	 * y mediante el método del objeto evento "setEstado()"cambiaremos su atributo de Estado a "Cancelado". 
	 * Finalemente pasamos el control del servlet a "index.jsp" pasandole el "Evento".
	 * 
	 * @author Pedro Murillo
	 * @param request
	 * @param response
	 * @throws ServletException
	 * @throws IOException
	 */
	protected void procCancelar(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		IntEventoDao ievnt = new EventoDaolmpl();
		List<Evento> lista = ievnt.findAll();
		Evento evento = ievnt.findById(id);
		evento.setEstado("Cancelado");
		
		
		request.setAttribute("listaeventos", lista);
		request.getRequestDispatcher("index.jsp").forward(request, response);
	}
	}

