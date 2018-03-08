package es.jcyl.abcd.efgh.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import es.jcyl.abcd.efgh.persistencia.entidades.Edificio;
import es.jcyl.abcd.efgh.persistencia.entidades.Sala;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;
import es.jcyl.abcd.efgh.persistencia.repositorios.EdificiosRepositorio;

@Service
public class EdificiosServicio {
	
	@Autowired
	private EdificiosRepositorio repo;
	
	
	public void guardar ( Edificio e ) {
		this.repo.save( e );
	}
	
	public void guardar ( List<Edificio> e ) {
		this.repo.save( e );
	}
	
	
	public void actualizar ( Edificio e ) {
		this.repo.save( e );
	}
	
	public void borrar ( Edificio e) {
		this.repo.delete( e.getEdificioId() );
	}
	
	
	public List<Edificio> todos() {
		return (List<Edificio>) this.repo.findAll();
	}
	
	public Edificio buscarPorId ( int id ) {
		return this.repo.findOne( new Integer (id));
	}
	
	public List<Edificio> buscarPorDireccion ( String c) {
		return this.repo.findByDireccionNombreViaContainsIgnoreCase( c );
	}
	
	public List<Edificio> buscarPorTipoVia ( TipoVia tv ) {
		return this.repo.findByDireccionTipoVia(tv);
	}
	
	public List<Edificio> buscarPorProvincia ( String prov ) {
		return this.repo.buscarPorProvincia(prov);
	}

}
