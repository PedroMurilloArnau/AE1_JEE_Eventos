package modelo.daos;

import java.util.ArrayList;
import java.util.List;

import modelo.beans.Evento;




//Implementamos los métodos del interface.
public class EventoDaolmpl implements IntEventoDao{

	private List<Evento> lista;
	private List<Evento> listaActivos;
	
	//Montamos la lista mendiante el método "ventoDaoLmpl
	public EventoDaolmpl() {
		lista = new ArrayList<Evento>();
		cargarDatos();
	}
	//Mediante el método "cargarDatos()" cargamos todos los datos.
	private void cargarDatos() {
		
		lista.add(new Evento(1,"Boda","Boda Gitana","2003",2,"C/caladero","Cancelado","D",150,70,300.25,1));
		lista.add(new Evento(2,"Boda","Boda Flamenca","2003",2,"C/simbionte3","Activo","N",130,60,220,1));
		lista.add(new Evento(3,"Cumpleaños","Pallasos","2005",2,"C/carpesco2","Activo","D",150,70,60,2));
		lista.add(new Evento(4,"Despedida","A lo gogo","2007",2,"C/somosierra 13","Activo","N",150,70,40.50,3));
		lista.add(new Evento(5,"Cumpleaños","Pellero","2005",2,"C/forico 12","Activo","D",150,70,300.25,2));

	}
	
	//Con el método fidAll() nos carga la lista.
	@Override
	public List<Evento> findAll() {
	
		
		return lista;
	}
	
	//Mediante el método eliminar evento eliminamos el evento por su atributo "idevento".
	@Override
	public int eliminarEvento(int idevento) {
		Evento aux = new Evento();
		aux.setIdevento(idevento);
		int pos = lista.indexOf(aux);
		if (pos == -1) //No la ha encontrado.
			return 0;
		else
			return (lista.remove(pos) != null)?1:0;
	}
	
	//Mediante el método findById buscamos el evento por su id.
	@Override
	public Evento findById(int idevento) {
		Evento aux = new Evento();
		aux.setIdevento(idevento);
		int pos = lista.indexOf(aux);
		if (pos == -1) //No la ha encontrado.
			return null;
		else
			return lista.get(pos);
	}
}

