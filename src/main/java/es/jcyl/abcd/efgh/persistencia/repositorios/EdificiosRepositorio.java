package es.jcyl.abcd.efgh.persistencia.repositorios;

import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import es.jcyl.abcd.efgh.persistencia.entidades.*;

@Repository
public interface EdificiosRepositorio extends JpaRepository <EdificioEntidad, Integer> {
	
	
}
