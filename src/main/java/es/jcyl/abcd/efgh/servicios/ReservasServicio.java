package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.Reserva;
import es.jcyl.abcd.efgh.persistencia.entidades.Sala;
import es.jcyl.abcd.efgh.persistencia.repositorios.ReservasRepositorio;

@Service
public class ReservasServicio {
	
	
	@Autowired
	private ReservasRepositorio repo;
	
	
	public List<Reserva> todos() {
		return (List<Reserva>) this.repo.findAll();
	}
	
	public Reserva buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public void guardar ( Reserva r ) {
		this.repo.save( r );
	}
	
	public void actualizar ( Reserva s ) {
		this.repo.save( s );
	}
	
	public void borrar ( Reserva s) {
		this.repo.delete( s );
	}
	

}
