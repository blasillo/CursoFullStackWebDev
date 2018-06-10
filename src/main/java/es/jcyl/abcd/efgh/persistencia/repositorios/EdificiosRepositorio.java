package es.jcyl.abcd.efgh.persistencia.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import es.jcyl.abcd.efgh.persistencia.entidades.EdificioEntidad;
import es.jcyl.abcd.efgh.persistencia.entidades.TipoVia;

@Repository
public interface EdificiosRepositorio extends JpaRepository <EdificioEntidad, Integer> {
	
	
	//TODO: buscar los edificios por tipo de via y por nombre de via
	
	//TODO: buscar los edificios de una provincia @Query
	public List<EdificioEntidad> buscarPorProvincia ( @Param ("prov") String prov );
	
	//TODO: buscar los edificios por nombre del edificio
	
	
}
