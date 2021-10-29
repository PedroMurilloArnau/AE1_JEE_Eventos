package modelo.daos;

import java.util.List;

import modelo.beans.Evento;



//Implementamos el interface para recorrer la lista de evento.
public interface IntEventoDao {
	
	Evento findById(int idevento);
	List<Evento> findAll();
	int eliminarEvento(int idevento);
	
	
}
