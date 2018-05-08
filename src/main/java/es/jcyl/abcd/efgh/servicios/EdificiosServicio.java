package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.SalaEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;
import es.jcyl.abcd.efgh.persistencia.repositorios.EdificiosRepositorio;

@Service
public class EdificiosServicio {
	
	@Autowired
	private EdificiosRepositorio repo;
	
	
	public void guardar ( EdificioEntidad e ) {
		this.repo.save( e );
	}
	
	public void guardar ( List<EdificioEntidad> e ) {
		this.repo.save( e );
	}
	
	
	public void actualizar ( EdificioEntidad e ) {
		this.repo.save( e );
	}
	
	public void borrar ( EdificioEntidad e) {
		this.repo.delete( e.getEdificioId() );
	}
	
	
	public List<EdificioEntidad> todos() {
		return (List<EdificioEntidad>) this.repo.findAll();
	}
	
	public EdificioEntidad buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public List<EdificioEntidad> buscarPorDireccion ( String c) {
		return this.repo.findByDireccionNombreViaContainsIgnoreCase( c );
	}
	
	public List<EdificioEntidad> buscarPorTipoVia ( TipoVia tv ) {
		return this.repo.findByDireccionTipoVia(tv);
	}
	
	public List<EdificioEntidad> buscarPorProvincia ( String prov ) {
		return this.repo.buscarPorProvincia(prov);
	}

}
