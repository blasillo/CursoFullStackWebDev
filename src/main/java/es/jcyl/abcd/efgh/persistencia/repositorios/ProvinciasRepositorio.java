package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.Provincia;


@Repository
@RepositoryRestResource (collectionResourceRel="provincias", path="provincias")
public interface ProvinciasRepositorio extends SoloLecturaRepositorio <Provincia, Integer> {
	
	public List<Provincia> findByProvinciaStartingWithIgnoreCase ( @Param ("prov") String prov ); 
	

}
