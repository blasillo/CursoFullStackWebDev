package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.Poblacion;
import es.jcyl.abcd.efgh.persistencia.entidades.Provincia;


@Repository
@RepositoryRestResource (collectionResourceRel="poblaciones", path="poblaciones")
public interface PoblacionesRepositorio extends SoloLecturaRepositorio <Poblacion, Integer> {
	
	
	public List<Poblacion> findTop5ByProvinciaOrderByPoblacionAsc (Provincia p);
	
	public List<Poblacion> findTop5ByProvinciaAndPoblacionStartingWithIgnoreCase (Provincia p, String pop);
	
	public Page<Poblacion> findByProvinciaAndPoblacionStartingWithIgnoreCase (Provincia p, String pop, Pageable pagina);
}
