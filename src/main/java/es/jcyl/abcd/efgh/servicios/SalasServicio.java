package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.Sala;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoSala;
import es.jcyl.abcd.efgh.persistencia.repositorios.SalasRepositorio;
import es.jcyl.abcd.efgh.persistencia.repositorios.TipoSalaRepositorio;

@Service
public class SalasServicio {

	
	@Autowired
	private SalasRepositorio repo;
	
	
	public void guardar ( Sala s ) {
		this.repo.save( s );
	}
	
	public void guardar ( List<Sala> s ) {
		this.repo.save( s );
	}
	
	
	public void actualizar ( Sala s ) {
		this.repo.save( s );
	}
	
	public void borrar ( Sala s) {
		this.repo.delete( s.getSalaId() );
	}
	
	
	public List<Sala> todos() {
		return (List<Sala>) this.repo.findAll();
	}
	
	public Sala buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public List<Sala> buscarPorCapacidad (int c) {
		return this.repo.buscarPorCapacidad( c );
	}
	
}
