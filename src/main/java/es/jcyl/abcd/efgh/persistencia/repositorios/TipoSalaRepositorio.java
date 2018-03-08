package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.TipoSala;

@Repository
public interface TipoSalaRepositorio extends SoloLecturaRepositorio <TipoSala, Integer> {
	
	public List<TipoSala> findByTipo (String n);
	
	public List<TipoSala> findByTipoContainingIgnoreCase (String n);

}
