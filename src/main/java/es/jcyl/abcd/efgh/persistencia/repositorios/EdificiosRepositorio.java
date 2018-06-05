package es.jcyl.abcd.efgh.persistencia.repositorios;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;

@Repository
public interface EdificiosRepositorio extends JpaRepository <EdificioEntidad, Integer> {
	
	
}
