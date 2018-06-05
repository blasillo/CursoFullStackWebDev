package es.jcyl.abcd.efgh.persistencia.repositorios;

import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.PoblacionEntidad;


@Repository
public interface PoblacionesRepositorio extends SoloLecturaRepositorio <PoblacionEntidad, Integer> {
	
	
}
