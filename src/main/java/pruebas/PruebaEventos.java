package pruebas;


import modelo.beans.Evento;
import modelo.daos.EventoDaolmpl;
import modelo.daos.IntEventoDao;

public class PruebaEventos {

	//Monto una estructura de pruebas de los eventos de la lista para ver como trabajan.

	public static void main(String[] args) {
		
		IntEventoDao eventi = new EventoDaolmpl();
		//Probamos el método de editar un evento.
		for(Evento eve: eventi.findAll()) 
			System.out.println(eve);
		
		//pruebo el método de eliminar evento.
		eventi.eliminarEvento(1);
		for(Evento eve: eventi.findAll()) 
		System.out.println(eve);

		
	}

}
