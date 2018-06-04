package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;


@Repository
public interface PoblacionesRepositorio extends SoloLecturaRepositorio <PoblacionEntidad, Integer> {
	
	// TODO: consulta las 5 primeras poblaciones del nombre de una provincia ordenadas asc
	public List<PoblacionEntidad> findTop5ByProvinciaProvinciaStartingWithIgnoreCaseOrderByPoblacionAsc (String p);
	
	//TODO: consulta las 5 primeras poblaciones por provincia 
	public List<PoblacionEntidad> findTop5ByProvinciaAndPoblacionStartingWithIgnoreCase (ProvinciaEntidad p, String pop);
	
	//TODO: consulta paginada de poblaciones por nombre y por provincia 
	public Page<PoblacionEntidad> findByProvinciaAndPoblacionStartingWithIgnoreCase (ProvinciaEntidad p, String pop, Pageable pagina);
}
