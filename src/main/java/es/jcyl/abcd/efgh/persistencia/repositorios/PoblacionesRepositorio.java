package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.ProvinciaEntidad;


@Repository
public interface PoblacionesRepositorio extends SoloLecturaRepositorio <PoblacionEntidad, Integer> {
	
	
}
