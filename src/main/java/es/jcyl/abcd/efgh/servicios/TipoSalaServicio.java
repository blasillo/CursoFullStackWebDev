package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.TipoSala;
import es.jcyl.abcd.efgh.persistencia.repositorios.TipoSalaRepositorio;

@Service
public class TipoSalaServicio {

	@Autowired
	private TipoSalaRepositorio repo;
	
	
	
	public void guardar ( TipoSala s ) {
		//this.repo.save( s );
	}
	
	public List<TipoSala> todos() {
		return (List<TipoSala>) this.repo.findAll();
	}
	
	
	public List<TipoSala> buscarPorTipo(String tipo) {
		return (List<TipoSala>) this.repo.findByTipoContainingIgnoreCase(tipo);
	}
}
